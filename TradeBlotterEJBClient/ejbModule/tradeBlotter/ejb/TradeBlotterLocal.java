package tradeBlotter.ejb;

import java.util.List;

import javax.ejb.Local;

import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

@Local
public interface TradeBlotterLocal {


	public List<User> addUser();
	public List<TradeInfo> displayTradeInformation();
	
}
