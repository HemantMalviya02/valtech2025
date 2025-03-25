package com.valtech.training.sprisecauth2.sprsecauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(req -> req.anyRequest().authenticated());
		security.oauth2Login(Customizer.withDefaults());
		return security.build();
	}
}
