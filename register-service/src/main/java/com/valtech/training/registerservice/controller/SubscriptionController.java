package com.valtech.training.registerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping("/")
	public List<SubscriptionVO> fetchAllSubscription() {
		return subscriptionService.getAllSubscription();
	}
	
	@PostMapping("/")
	public SubscriptionVO saveSubscription(@RequestBody SubscriptionVO vo) {
		return subscriptionService.createSubscription(vo);
	}
	
	@GetMapping("/{id}")
	public SubscriptionVO fetchSubscription(@PathVariable("id") long id) {
		return subscriptionService.getById(id);
	}
}
