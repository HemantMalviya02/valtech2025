package com.valtech.training.leave.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.leave.entities.Leave;

@Repository
public interface LeaveRepo extends JpaRepository<Leave, Long>{

	List<Leave> findAllByEmployeeId(long emp);
	
}
