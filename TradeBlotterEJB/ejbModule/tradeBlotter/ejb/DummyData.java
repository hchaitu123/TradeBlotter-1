package tradeBlotter.ejb;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tradeBlotter.jpa.TradeInfo;

@Path("/data")
public class DummyData {
	
	private TradeBlotterRemote bean; 
	
	public DummyData() {
        try {
        	InitialContext context = new InitialContext();
            bean = (TradeBlotterRemote) context.lookup("java:app/TradeBlotterEJB/TradeBlotter!tradeBlotter.ejb.TradeBlotterRemote");
        // JNDI LOOK UP
        }
		catch (NamingException ex) {}
	}
	
	
	
	@GET
	@Produces("application/json")
	public String displayTradeInfo() {

		if (bean == null) {
			return null;
			}
		
		else {
			bean.dummyDataGenerator();
			return "Started";
		}
	}
	

}
