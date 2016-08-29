package tradeblotter.web;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import chat.group.*;

@Path("/chat")
public class ChatResource {
	


		private ChatGroupRemote bean;
		private static boolean loginConfirmation = false;
		public ChatResource() {
	        try {
	        	InitialContext context = new InitialContext();
	            bean = (ChatGroupRemote) context.lookup("java:app/TradeBlotterEJB/ChatGroup!chat.group.ChatGroupRemote");
	        }
			catch (NamingException ex) {}
		}
		
		
		
		@POST
	    @Consumes("application/x-www-form-urlencoded") 
	    @Produces("text/plain")
	    public void addPlayer(@FormParam("userID")String userID,
	                            @FormParam("message") String message) {

			bean.postMessage(userID, message);
		}

//		@GET
//		@Produces("application/json")
//	    @Path("/{categoryName}")
//		public List<Product> getProductsInCategory(@PathParam("categoryName")String categoryName) {
//
//			if (bean == null) 
//				return null;
//			
//			return bean.getProductsInCategory(categoryName);	
//		}
//	}
////
}
