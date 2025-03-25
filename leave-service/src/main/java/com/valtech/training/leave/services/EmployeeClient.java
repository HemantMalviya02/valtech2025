package com.valtech.training.leave.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.leave.config.FeignClientConfig;
import com.valtech.training.leave.vos.EmployeeVO;

@FeignClient(name = "EMPLOYEE-SERVICE", configuration = FeignClientConfig.class)
public interface EmployeeClient {
	
	@GetMapping("/api/v1/employees/{id}") 
	EmployeeVO getEmployeeAsManager(@PathVariable long id);
}

//@Component
//public class EmployeeClient {
//	
//	public long getManager(long empId) {
//		RestTemplate temp = new RestTemplate();
//		String url = "http://localhost:9010/api/v1/employees/"+empId;
//		EmployeeVO emp = temp.getForObject(url, EmployeeVO.class);
//		return emp.managerId();
//	}
//}
