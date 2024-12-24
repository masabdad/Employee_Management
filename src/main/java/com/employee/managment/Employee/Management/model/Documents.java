package com.employee.managment.Employee.Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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
}
