package com.valtech.training.leave.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.entities.Leave;

public record LeaveVO(long id, String fromDate, String toDate, 
						String leaveType, String leaveStatus, String reason, String comments, long employeeId) {
	
	public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyy");
	
	
	public void updateTo(Leave leave) {
		LocalDate from = LocalDate.parse(fromDate, FORMATTER);
		LocalDate to = LocalDate.parse(toDate, FORMATTER);
		LeaveType ltype = LeaveType.valueOf(leaveType);
		LeaveStatus lstatus = LeaveStatus.valueOf(leaveStatus);
		leave.setFromDate(from);
		leave.setToDate(to);
		leave.setLeaveType(ltype);
		leave.setLeaveStatus(lstatus);
		leave.setReason(reason);
		leave.setComments(comments);
	}
	
	public Leave to() {
		LocalDate from = LocalDate.parse(fromDate, FORMATTER);
		LocalDate to = LocalDate.parse(toDate, FORMATTER);
		LeaveType ltype = LeaveType.valueOf(leaveType);
		LeaveStatus lstatus = LeaveStatus.valueOf(leaveStatus);
		return new Leave(id, from, to, ltype, lstatus, reason, comments, employeeId);
	}
	
	public static List<LeaveVO> to(List<Leave> leaves) {
		return leaves.stream().map(l -> from(l)).collect(Collectors.toList());
	}
	
	public static LeaveVO from(Leave l) {
		String from = l.getFromDate().format(FORMATTER);
		String to = l.getToDate().format(FORMATTER);
		String ltype = l.getLeaveType().name();
		String lstatus = l.getLeaveStatus().name();
		return new LeaveVO(l.getId(), from, to, ltype, lstatus, 
						  l.getReason(), l.getComments(), l.getEmployeeId());
	}
}


