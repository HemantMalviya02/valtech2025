package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO (long id, int amount, String subscriptionStart, String subscriptionEnd, List<Long> userIds){
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyy");
	
	public Subscription to(List<User> user) {
		LocalDate startDate = LocalDate.parse(subscriptionStart, FORMATTER);
		LocalDate endDate = LocalDate.parse(subscriptionEnd, FORMATTER);
		Subscription s = new Subscription(amount, startDate, endDate);
		s.setUsers(user);
		return s;
	}
	
	public static SubscriptionVO from(Subscription s) {
		String startDate = s.getSubscriptionStart().format(FORMATTER);
		String endDate = s.getSubscriptionEnd().format(FORMATTER);
		List<Long> ids = s.getUsers().stream().map(user -> user.getId()).collect(Collectors.toList());
		return new SubscriptionVO(s.getId(), s.getAmount(), startDate, endDate, ids);
	}
	
}
