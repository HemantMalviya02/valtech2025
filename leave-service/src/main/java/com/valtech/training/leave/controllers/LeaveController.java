package com.valtech.training.leave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.leave.services.LeaveService;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveVO;

@RestController
@RequestMapping("/api/v1/leaves")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	
	@PostMapping("/approve")
	public LeaveVO approveLeave(@RequestBody ApproveLeaveVO vo) {
		return leaveService.approveLeave(vo);
	}
	
	@PostMapping("/apply")
	public LeaveVO applyLeave(@RequestBody LeaveVO vo) {
		return leaveService.applyLeave(vo);
	}
	
	
	@GetMapping("/{id}")
	public LeaveVO getLeave(@PathVariable("id") long id) {
		LeaveVO vo =  leaveService.getLeave(id);
		EmployeeVO man = leaveService.getManager(vo.employeeId());
		System.out.println("Emp = "+vo.employeeId() + " Manager = "+ man.id());
		return vo;
	}
	
	@GetMapping("/")
	public List<LeaveVO> getAllLeaves() {
		return leaveService.getAllLeaves();
	}
	
	@PostMapping("/")
	public LeaveVO createLeave(@RequestBody LeaveVO vo) {
		return leaveService.saveOrUpdate(vo);
	}
	@PutMapping("/{id}")
	public LeaveVO updateLeave(@PathVariable("id") long id, @RequestBody LeaveVO vo) {
		return leaveService.update(vo, id);
	}
}

