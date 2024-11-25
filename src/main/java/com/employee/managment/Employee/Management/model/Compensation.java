package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.PayrollFrequency;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Compensation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compensationId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private String basicPay;
    private String allowance;
    private String deduction;
    private String bonus;
    private PayrollFrequency payrollFrequency;
    private String bankAccountNumber;
    private String bankName;
    private int branchCode;
}
