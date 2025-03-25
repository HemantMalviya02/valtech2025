package com.valtech.training.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;

import jakarta.annotation.PostConstruct;

public interface UserManagerService {

	void init();

	void registerUser(User user);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	void changePassword(String username, ChangePasswordVO changePassword);

}