package tradeBlotter.ejb;

import java.util.List;

import javax.ejb.Remote;

import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

@Remote
public interface TradeBlotterRemote {
	
	public List<User> addUser(String name);
	public List<TradeInfo> displayTradeInformation();

}
