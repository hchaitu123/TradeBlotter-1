package tradeblotter.web;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import tradeBlotter.ejb.DummyData; 

@ApplicationPath("/rest")
public class RestApp extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public RestApp(){
	     singletons.add(new TradeResource());
	     singletons.add(new DummyData());
	     singletons.add(new ChatResource());
	}
	
	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}

}



