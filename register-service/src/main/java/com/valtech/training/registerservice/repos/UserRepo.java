package com.valtech.training.registerservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.registerservice.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	List<User> findAllByKidTrue();
}
