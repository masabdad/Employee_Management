package com.employee.managment.Employee.Management.model;

import jakarta.persistence.JoinColumn;

import java.util.Date;

public class Performance {
    private int performanceId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private Date reviewDate;
    private String reviewer;
    private float ratings;
    private String feedback;
}
