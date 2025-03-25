package com.valtech.training.registerservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO (long id, String name, String mobile, String email, long  subscriptionId, Boolean kid) {
	
	public User to(Subscription s) {
		User user =  new User(name, mobile, email, kid);
		user.setSubscription(s);
		return user;
	}
	
	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getName(), u.getMobile(), u.getEmail(), u.getSubscription().getId(), u.isKid());
	}
	
	public static List<UserVO> from(List<User> users) {
		return users.stream().map(user -> UserVO.from(user)).collect(Collectors.toList());
	}
}
