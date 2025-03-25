package com.valtech.training.registerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<UserVO> fetchAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/")
	public UserVO saveUser(@RequestBody UserVO vo) {
		return userService.signIn(vo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserVO> fetchUser (@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(userService.getUser(id));
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity.of(Optional.empty());
		}
		
	}
	
	@PostMapping("/subscription/{sid}")
	public void addUserToSubscription(@PathVariable("sid") long sid, @RequestBody UserVO vo) {
		userService.addUserToSubscription(vo, sid);
	}
	
	
	@DeleteMapping("/{userId}")
	public void deleteUserFromSubscription(@PathVariable("userId") long userId) {
		userService.deleteUserFromSubscription(userId);
	}
}
