package webservices;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class HelloWorldClient {

	public static void main(String[] args) {
		ClientProxyFactoryBean client = new  ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/HelloWorld");
		HelloWorld hw = client.create(HelloWorld.class);
		System.out.println(hw.getClass().getName());
		System.out.println(hw.hello(" Web Services..."));
	}

}
