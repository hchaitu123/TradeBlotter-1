package tradeblotter.web;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tradeBlotter.ejb.TradeBlotterRemote;
import tradeBlotter.jpa.*;

@Path("/user")
public class TradeResource {
	


		private TradeBlotterRemote bean; 
		
		public TradeResource() {
	        try {
	        	InitialContext context = new InitialContext();
	            bean = (TradeBlotterRemote) context.lookup("java:app/TradeBlotterEJB/TradeBlotter!tradeBlotter.ejb.TradeBlotterRemote");
	        // JNDI LOOK UP
	        }
			catch (NamingException ex) {}
		}
		
		@GET
		@Produces("application/json")
		public List<TradeInfo> displayTradeInfo() {

			if (bean == null) {
				return null;
				}
			
			else {
				return bean.displayTradeInformation();
			}
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
