package com.valtech.training.loanmanagement.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanmanagement.services.LoanService;
import com.valtech.training.loanmanagement.webservices.LoanServiceWSImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint loanServiceWS(LoanService loanService) {
			EndpointImpl endPoint = new EndpointImpl(bus,new LoanServiceWSImpl(loanService));
			endPoint.setAddress("/loanService");
			endPoint.publish();
		    return endPoint;
	}
	
	

}
