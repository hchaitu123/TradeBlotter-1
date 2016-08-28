package tradeBlotter.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class TradeBlotter
 */
@Stateful
@Local(TradeBlotterLocal.class)
@Remote(TradeBlotterRemote.class)
public class TradeBlotter implements TradeBlotterRemote, TradeBlotterLocal {


	@PersistenceContext(name="TradeBlotterJPA-PU")
	EntityManager em; 
	
	
	
    public List<User> addUser(String name) {

	     User user1 = new User();
	     user1.setUserName(name);
	     em.persist(user1);
	     List<User> users = new ArrayList<User>();
	     users.add(user1);
	     return users;
	     
		
	    }
    public List<TradeInfo> displayTradeInformation(){
    	
    	

        TypedQuery<TradeInfo> query = em.createQuery("SELECT p FROM TradeInfo AS p", TradeInfo.class);

        // Execute the query, and get a collection of entities back.
        List<TradeInfo> products = query.getResultList();

        return products;
    	
    	
    	
    }
    
    
    
    
}

//	    @Override
//	    public List<Product> getAllProducts() {
//
//	        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product AS p", Product.class);
//
//	        // Execute the query, and get a collection of entities back.
//	        List<Product> products = query.getResultList();
//
//	        for (Product product: products) {
//	            displayProductOnServerConsole("Got product in getAllProducts()", product);
//	        }
//
//	        return products;
//	    }


//	    public List<Product> getProductsByName(String productName) {
//
//	    	String sql = "SELECT p FROM Product AS p WHERE p.productName LIKE '%" + productName + "%'";
//	        System.out.println(sql);
//	        TypedQuery<Product> query = em.createQuery(sql, Product.class);
//
//	        // Execute the query, and get a collection of products back.
//	        List<Product> products = query.getResultList();
//
//	        for (Product product: products) {
//	            displayProductOnServerConsole("Got product in getProductsByName()", product);
//	        }
//
//	        return products;
//	    }

//	    public List<Product> getProductsInCategory(String categoryName) {
//
//	        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product AS p WHERE p.category.categoryName = :name", Product.class);
//	        query.setParameter("name", categoryName);
//
//	        // Execute the query, and get a collection of products back.
//	        List<Product> products = query.getResultList();
//
//	        for (Product product: products) {
//	            displayProductOnServerConsole("Got product in getProductsInCategory()", product);
//	        }
//
//	        return products;
//	    }
//
//
//	    @Override
//	    public void increaseAllPrices(double delta) {
//
//	        // Get all products from the database.
//	        List<Product> products = getAllProducts();
//
//	        for (Product product: products) {
//	            double currentPrice = product.getUnitPrice();
//	            double newPrice = currentPrice + delta;
//	            product.setUnitPrice(newPrice);
//	        }
//
//	        // No need to manually save in database, EM will do it automatically.
//	    }
//
//
//	    private void displayProductOnServerConsole(String message, Product product) {
//
//	        System.out.println(message);
//	        if (product == null) {
//	            System.out.print("Product is null");
//	        } else {
//	            System.out.println(product);
//	        }
//	    }
	


