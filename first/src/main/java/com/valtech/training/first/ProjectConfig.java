package com.valtech.training.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	
	@Bean
	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
		return new SimpleInterestImpl(arithmetic);
	}
	
	@Bean
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}
}
