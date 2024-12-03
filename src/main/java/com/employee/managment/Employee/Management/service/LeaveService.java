package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.LeaveManagement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LeaveService {
    ResponseEntity<List<LeaveManagement>> getAllLeaveRequests();

    ResponseEntity<LeaveManagement> addLeaveRequest(LeaveManagement leaveManagement);

}
