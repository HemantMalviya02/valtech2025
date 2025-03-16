package com.valtech.training.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.employee.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
