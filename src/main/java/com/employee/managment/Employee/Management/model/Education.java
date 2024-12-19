package com.employee.managment.Employee.Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="education")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    private String degree;
    private String institution;
    private int yearOfCompletion;
}
