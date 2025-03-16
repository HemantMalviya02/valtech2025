package com.valtech.training.leave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.leave.services.LeaveService;
import com.valtech.training.leave.vos.LeaveMasterVO;

@RestController
@RequestMapping("/api/v1/leaveMasters")
public class LeaveMasterController {
	
	@Autowired
	private LeaveService leaveService;
	
	
	@GetMapping("/{empId}")
	public LeaveMasterVO getLeaveMaster(@PathVariable("empId") long empId) {
		return leaveService.getLeaveMaster(empId);
	}
	
	@GetMapping("/")
	public List<LeaveMasterVO> getLeaveMasters() {
		return leaveService.getAllLeaveMasters();
	}
	
	@PostMapping("/")
	public LeaveMasterVO saveOrUpdateLeaveMaster(@RequestBody LeaveMasterVO vo) {
		return leaveService.createLeaveMaster(vo);
	}
}
