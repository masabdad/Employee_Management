package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.LeaveStatus;
import com.employee.managment.Employee.Management.model.enums.LeaveType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.Date;

public class LeaveManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int leaveId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private LeaveType leaveType;
    private Date endDate;
    private LeaveStatus leaveStatus;

}
