package com.valtech.training.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.repos.UserRepo;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;

import jakarta.annotation.PostConstruct;

@Service
public class UserManagerServiceImpl implements UserDetailsService, UserManagerService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@PostConstruct
	public void init() {
		if(userRepo.count() == 0) {
			registerUser(new User(0, "scott", "tiger", "USER"));
			registerUser(new User(0, "admin", "admin", "USER", "ADMIN"));
		}
	}
	
	@Override
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}

	@Override
	public void changePassword(String username, ChangePasswordVO changePassword) {
		User user = (User) loadUserByUsername(username);
		
		if(passwordEncoder.matches(changePassword.currentPassword(), user.getPassword())) {
			if(changePassword.newPassword().equals(changePassword.confirmPassword())) {
				user.setPassword(passwordEncoder.encode(changePassword.newPassword()));
				userRepo.save(user);
			}
		}
	}
	
}
