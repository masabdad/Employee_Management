package com.employee.managment.Employee.Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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



}
