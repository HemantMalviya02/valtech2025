package com.valtech.training.springsecurityjwt.config;

import org.springframework.beans.factory.annotation.Autowired;

//import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	
	@Autowired 
	@Lazy
	private JWTFilter jwtFilter;

	@Autowired
	@Lazy         				// the securityFilterChain will create at last 
	private LoginFilter loginFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception {
		security.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests.requestMatchers("/hello").permitAll()
				.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
//		security.addFilterBefore(loginFilter, BasicAuthenticationFilter.class);
//		security.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class);
		return security.build();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.builder().username("scott").password("tiger").roles("USER").build());
		manager.createUser(User.builder().username("admin").password("admin").roles("USER", "ADMIN").build());
		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
	}
}
