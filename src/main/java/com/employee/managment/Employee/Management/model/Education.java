package com.employee.managment.Employee.Management.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.time.Year;

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private String degree;
    private String institution;
    private Year yearOfCompletion;

}
