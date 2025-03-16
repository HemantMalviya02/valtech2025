package com.valtech.training.leave.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveVO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveControllerTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testApplyAndApprove() {
		String url = "http://localhost:"+port+"/api/v1/leaves/";
		LeaveVO vo = restTemplate.postForObject(url+"apply", new LeaveVO(0, "08-03-2025", "09-03-2025", LeaveType.CASUAL.name(),
				LeaveStatus.APPLIED.name(), "Going to Native", "", 2), LeaveVO.class);
		assertTrue(vo.id() !=0);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPLIED.name());
//		complete for others 
		ApproveLeaveVO avo = new ApproveLeaveVO(vo.id(), "Your Leave is Approved", 1);
		vo = restTemplate.postForObject(url+"approve", avo, LeaveVO.class);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPROVED.name());
	}
	
	@Test
	void test() {
		String url = "http://localhost:"+port+"/api/v1/leaves/";
		
		List leaves = restTemplate.getForObject(url, List.class);
		
		if(leaves.size() == 0) {
			restTemplate.postForObject(url, new LeaveVO(0, "08-03-2025", "09-03-2025", LeaveType.CASUAL.name(),
										LeaveStatus.APPLIED.name(), "Going to Native", "", 1), LeaveVO.class);
			
			restTemplate.postForObject(url, new LeaveVO(0, "12-03-2025", "13-03-2025", LeaveType.SICK.name(),
					LeaveStatus.APPLIED.name(), "Have Fever", "", 4), LeaveVO.class);
			
			restTemplate.postForObject(url, new LeaveVO(8, "08-03-2025", "09-03-2025", LeaveType.CASUAL.name(),
					LeaveStatus.APPLIED.name(), "Going to native", "", 2), LeaveVO.class);
			
			restTemplate.postForObject(url, new LeaveVO(8, "08-03-2025", "09-03-2025", LeaveType.CASUAL.name(),
					LeaveStatus.APPLIED.name(), "Going to native", "", 2), LeaveVO.class);
		}
	}

}
