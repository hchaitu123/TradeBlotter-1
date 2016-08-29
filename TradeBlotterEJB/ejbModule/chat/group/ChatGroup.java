package chat.group;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import tradeBlotter.jpa.GroupChat;
import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class ChatGroup
 */
@Stateful
@Local(ChatGroupLocal.class)
@Remote(ChatGroupRemote.class)
public class ChatGroup implements ChatGroupRemote, ChatGroupLocal {

    /**
     * Default constructor. 
     */
	
	

	@Resource
	private SessionContext sessionContext;
	
	@PersistenceContext(name="TradeBlotterJPA-PU")
	public EntityManager em; 
	
	
    public ChatGroup() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void postMessage(String userID ,String message){
    	GroupChat groupChat = new GroupChat();
    	
    	TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		
		User LoginUser = userData.get(0);
		String department = LoginUser.getDepartment();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String timestamp = time.toString();
		
		TypedQuery<GroupChat> messageIdQuery = em.createQuery("SELECT p FROM GroupChat AS p ORDER BY p.messageID DESC", GroupChat.class);

	    // Execute the query, and get a collection of entities back.
	    List<GroupChat> messageData = messageIdQuery.getResultList();
	    int counter = 0;
	    String prevMessageId = null;
		
		//To position the cursor to the resultset starting columns.
		for(GroupChat t : messageData){
			if(counter==0){	
			//System.out.println(t.getTradeID() + t.getTradeType() + t.getSubmissionDate() + t.getStatus() + t.getIsin() + t.getProduct() + t.getQuantity() + t.getPrice() + t.getQuoteVolume() + t.getTerms() + t.getTraderID() + t.getFirmName() );
			
			prevMessageId = t.getMessageID();
			counter=1;
			}
		}
	    
		String messageId = "" + (Integer.parseInt(prevMessageId)+1);
	    
		groupChat.setMessageID(messageId);
		groupChat.setUserID(userID);
    	groupChat.setTimeStamp(timestamp);
    	groupChat.setDepartment(department);
    	groupChat.setMessage(message);
    	

    	em.persist(groupChat);	

    }
}
