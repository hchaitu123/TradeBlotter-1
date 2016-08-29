package chat.group;

import javax.ejb.Remote;

@Remote
public interface ChatGroupRemote {

	
	public void postMessage(String userID, String message);
	
	
}
