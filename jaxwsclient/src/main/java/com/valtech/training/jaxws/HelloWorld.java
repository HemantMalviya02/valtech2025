package com.valtech.training.jaxws;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	String Hello(String name);

}