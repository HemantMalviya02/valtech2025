package com.valtech.training.loanmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.loanmanagement.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer>{
	
	List<Loan> findAllByCustomerName(String name);

}
