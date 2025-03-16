package com.valtech.training.leave.vos;


/*
 * manager will approve the leave with the leaveId,
 * put a comment,
 * and send his own id as manager
 */

public record ApproveLeaveVO (long leaveId, String comments, long manager) {

}
