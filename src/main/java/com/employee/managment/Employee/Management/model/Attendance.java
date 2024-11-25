package com.employee.managment.Employee.Management.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import org.hibernate.annotations.GeneratorType;

import java.time.LocalDateTime;
import java.util.Date;

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendanceId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private Date date;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private float hoursWorked;

}
