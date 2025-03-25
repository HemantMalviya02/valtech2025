package com.valtech.training.leave.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
//@EnableFeignClients
public class FeignClientConfig {
	
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
	
	@Bean
	public Logger logger() {
		return new OneLineLogger();
	}
}
