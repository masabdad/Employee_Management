package com.employee.managment.Employee.Management.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private String documentType;
    private String documentUrl;

    @Temporal(TemporalType.DATE)
    private Date uploadedDate;

    // Getters and Setters
}
