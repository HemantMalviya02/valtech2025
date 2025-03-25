package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public SubscriptionVO createSubscription(SubscriptionVO vo) {
		List<User> users = userRepo.findAllById(vo.userIds());
		Subscription sc = vo.to(users);
		sc = subscriptionRepo.save(sc);
		return SubscriptionVO.from(sc);
	}
	
	@Override
	public List<SubscriptionVO> getAllSubscription() {
		return subscriptionRepo.findAll().stream().map(s -> SubscriptionVO.from(s)).collect(Collectors.toList());
	}
	
	@Override
	public SubscriptionVO getById(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}
}
