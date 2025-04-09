package com.valtech.training.apigateaway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gateawayConfig {
	
	@Bean 
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get").uri("http://httpbin.org:80"))
				.route(p -> p.path("/api/v1/employees/*").uri("lb://EMPLOYEE-SERVICE"))
				.route(p -> p.path("/api/v1/leaves/*").uri("lb://LEAVE-SERVICE"))
				.route(p -> p.path("/api/v1/leaveMasters/*").uri("lb://LEAVE-SERVICE"))
				.route(p -> p.path("/api/v1/questions/*").uri("lb://question"))
				.route(p -> p.path("/api/v1/quiz/*").uri("lb://QUIZ-SERVICE"))
				.build();
	}
}
