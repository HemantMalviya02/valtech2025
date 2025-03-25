package com.valtech.training.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LeaveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveServiceApplication.class, args);
	}

}
