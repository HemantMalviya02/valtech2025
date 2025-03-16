package com.valtech.training.leave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.entities.Leave;
import com.valtech.training.leave.entities.LeaveMaster;
import com.valtech.training.leave.repos.LeaveMasterRepo;
import com.valtech.training.leave.repos.LeaveRepo;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private LeaveMasterRepo leaveMasterRepo;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	
	/**
	 * getting the leave by the leaveId
	 * from the leave get the employeeId using the employeeClient get his manager
	 * check if the manager is valid 
	 * Invalid manager -> add comment Invalid manager, and send request back
	 * Valid manager -> update the leave master, set the leave status as approved, update the leave and return.
	 */
	
	@Override
	public LeaveVO approveLeave(ApproveLeaveVO vo) {
		
		Leave leave = leaveRepo.getReferenceById(vo.leaveId());
		long manager = employeeClient.getManager((leave.getEmployeeId()));    //get from employee service. 
		if(manager == vo.manager()) {
			LeaveMaster lm = leaveMasterRepo.findByEmployeeId(leave.getEmployeeId());
			lm.takeLeaves(leave);
			leaveMasterRepo.save(lm);
			leave.approveLeave(lm, manager);
			leave.updateLeave(vo.comments());
		}
		else {
			leave.updateLeave("You are not the Manager to approve");
		}
		
		
//		challenge : we have to call the employeeMicroService to understand the manager.
		
		
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
	@Override
	public LeaveVO applyLeave(LeaveVO vo) {
		Leave leave = vo.to();
		leave.setLeaveStatus(LeaveStatus.APPLIED);
		leave.checkLeaveApplicationAndUpdateStatus(leaveMasterRepo.findByEmployeeId(vo.employeeId()));
		leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
	
	@Override
	public List<LeaveVO> getAllLeaves() {
		return leaveRepo.findAll().stream().map(l -> LeaveVO.from(l)).collect(Collectors.toList());
	}
	
	
	@Override
	public List<LeaveVO> getLeavesByEmployee(long emp) {
		List<Leave> leaves =  leaveRepo.findAllByEmployeeId(emp);
		return LeaveVO.to(leaves);
		
//		return LeaveVO.to(leaveRepo.findAllByEmployeeId(emp));
	}
	
	@Override
	public LeaveVO saveOrUpdate(LeaveVO vo) {
		Leave leave = vo.to();
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
//	one employee can apply multiple leaves 
	@Override
	public LeaveVO getLeave(long id) {
		return LeaveVO.from(leaveRepo.getReferenceById(id));
	}
		
	@Override
	public List<LeaveMasterVO> getAllLeaveMasters() {
		return leaveMasterRepo.findAll().stream().map(lm -> LeaveMasterVO.from(lm))
							  .collect(Collectors.toList());
	}
	
	@Override
	public LeaveMasterVO createLeaveMaster(LeaveMasterVO vo) {
		LeaveMaster lm = vo.to();
		lm = leaveMasterRepo.save(lm);
		return LeaveMasterVO.from(lm);
	}
	
	@Override
	public LeaveMasterVO getLeaveMaster(long employeeId) {
		LeaveMaster lm = leaveMasterRepo.findByEmployeeId(employeeId);
		return LeaveMasterVO.from(lm);
	}

	@Override
	public LeaveVO update(LeaveVO vo, long id) {
		Leave leave = leaveRepo.getReferenceById(id);
		vo.updateTo(leave);
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}

	
}
