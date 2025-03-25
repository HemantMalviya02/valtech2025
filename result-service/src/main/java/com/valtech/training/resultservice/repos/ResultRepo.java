package com.valtech.training.resultservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.resultservice.entities.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long>{

	
}
