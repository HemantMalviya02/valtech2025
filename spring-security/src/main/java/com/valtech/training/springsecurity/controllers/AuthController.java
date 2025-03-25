package com.valtech.training.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.services.UserManagerService;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;
import com.valtech.training.springsecurity.vos.UserVO;



@Controller
public class AuthController {
	
	@Autowired
	private UserManagerService userManagerService;
	
	@GetMapping("/changePassword")
	public String showChangePasswordForm() {
		return "changePassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@AuthenticationPrincipal User user, @ModelAttribute ChangePasswordVO changePassword) {
		userManagerService.changePassword(user.getUsername(), changePassword);
		return "login";
	}
	 
	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVO user) {
		userManagerService.registerUser(user.to());
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "User";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin";
	}
}
