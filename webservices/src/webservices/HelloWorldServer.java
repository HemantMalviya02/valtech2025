package webservices;

import org.apache.cxf.frontend.ServerFactoryBean;
//responsible for creating beans in java class

public class HelloWorldServer {
	
	public static void main(String[] args) {
	
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7777/HelloWorld");
		
		server.setServiceBean(new HelloWorldImpl());
		server.setServiceClass(HelloWorld.class);
		
		server.create();
		System.out.println("Server Running...");
	}
}
