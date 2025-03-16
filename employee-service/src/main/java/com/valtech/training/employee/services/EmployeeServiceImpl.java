package com.valtech.training.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.employee.entities.Employee;
import com.valtech.training.employee.repos.EmployeeRepo;
import com.valtech.training.employee.vos.EmployeeVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeVO saveOrUpdateEmployee(EmployeeVO e) {
		Employee manager = e.managerId()==0 ? null :  employeeRepo.getReferenceById(e.managerId());
		Employee emp = employeeRepo.save(e.to(manager));
		return EmployeeVO.from(emp);
	}
	
	@Override
	public EmployeeVO getEmployee(long id) {
		return EmployeeVO.from(employeeRepo.getReferenceById(id));
	}
	
	@Override
	public List<EmployeeVO> getAllEmployees() {
		return employeeRepo.findAll().stream().map(e -> EmployeeVO.from(e)).collect(Collectors.toList());
	}
}
