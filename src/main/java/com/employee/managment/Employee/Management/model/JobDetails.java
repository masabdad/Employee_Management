package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.EmploymentType;
import jakarta.persistence.JoinColumn;

public class JobDetails {
    private int id;
    private String designation;
    private String department;
    private String jobGrade;
    private String workLocation;
    private EmploymentType employmentType;

    @JoinColumn(name = "employeeId")
    private int employeeId;
}
