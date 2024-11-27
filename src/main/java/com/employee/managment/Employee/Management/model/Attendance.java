package com.employee.managment.Employee.Management.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String checkInTime;
    private String checkOutTime;
    private Double hoursWorked;

    // Getters and Setters
}
