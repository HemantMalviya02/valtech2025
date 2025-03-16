package com.valtech.training.employee.services;

import java.util.List;

import com.valtech.training.employee.vos.EmployeeVO;

public interface EmployeeService {

	EmployeeVO saveOrUpdateEmployee(EmployeeVO e);

	EmployeeVO getEmployee(long id);

	List<EmployeeVO> getAllEmployees();

}