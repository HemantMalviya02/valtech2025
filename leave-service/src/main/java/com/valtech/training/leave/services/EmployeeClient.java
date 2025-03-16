package com.valtech.training.leave.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.leave.vos.EmployeeVO;

@Component
public class EmployeeClient {
	
	public long getManager(long empId) {
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9010/api/v1/employees/"+empId;
		EmployeeVO emp = temp.getForObject(url, EmployeeVO.class);
		return emp.managerId();
	}
}
