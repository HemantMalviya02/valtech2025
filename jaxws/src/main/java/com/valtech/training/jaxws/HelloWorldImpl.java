package com.valtech.training.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.valtech.training.jaxws.HelloWorld",
			name = "HelloWorld", portName = "HelloWorldPort")
public class HelloWorldImpl implements HelloWorld {
	
	@Override
	public String Hello(String name) {
		return "Hello World" + name + "from Jax WS";
	}
}	
