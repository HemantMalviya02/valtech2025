package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO signIn(UserVO vo);

	List<UserVO> getAllUsers();

	UserVO getUser(long id);

	UserVO addUserToSubscription(UserVO vo, long id);

	void deleteUserFromSubscription(long userId);

}