package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.LeaveStatus;
import com.employee.managment.Employee.Management.model.enums.LeaveType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "leaveManagement")
public class LeaveManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    // Getters and Setters


}
