package com.employee.managment.Employee.Management.controller;

import com.employee.managment.Employee.Management.model.LeaveManagement;
import com.employee.managment.Employee.Management.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @GetMapping("/getAllLeaveRequests")
    public ResponseEntity<List<LeaveManagement>> getRequests() {
        return leaveService.getAllLeaveRequests();

    }

    @PostMapping("/addLeaveRequest")
    public ResponseEntity<LeaveManagement> add(@RequestBody LeaveManagement leaveManagement){
        return leaveService.addLeaveRequest(leaveManagement);
    }
}
