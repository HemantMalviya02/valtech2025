package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	
	@Override
	public UserVO signIn(UserVO vo) {
		Subscription sc = new Subscription();
		sc.setAmount(5000);
		sc.setSubscriptionStart(LocalDate.now());
		sc.setSubscriptionEnd(LocalDate.now().plusYears(1));
		subscriptionRepo.save(sc);
		User user = vo.to(sc);
		user = userRepo.saveAndFlush(user);
		sc.addUser(user);
		return UserVO.from(user);
		
	}
	
	@Override
	public List<UserVO> getAllUsers() {
		return UserVO.from(userRepo.findAll()); 
	}
	
	@Override
	public UserVO getUser(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public UserVO addUserToSubscription(UserVO vo, long sid) {//login
		User user = vo.to(subscriptionRepo.getReferenceById(sid));
		user = userRepo.save(user);
		return UserVO.from(user);
	}

	@Override
	public void deleteUserFromSubscription(long userId) {
		User user = userRepo.getReferenceById(userId);
		Subscription sub = user.getSubscription();
		sub.removeUser(user);
		userRepo.delete(user);		
	}
}
