package tradeblotter.web;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

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
		
		@POST
	    @Consumes("application/x-www-form-urlencoded") 
	    @Produces("text/plain")
	    public String addPlayer(@FormParam("playerName")String playerName,
	                            @FormParam("team")@DefaultValue("Swansea")String team) {

	        return "Added player " + playerName + " to team " + team;
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
