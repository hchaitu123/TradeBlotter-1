package chat.group;

import javax.ejb.Local;

@Local
public interface ChatGroupLocal {
	public void postMessage(String userID, String message);
}
