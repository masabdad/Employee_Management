package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.Role;
import com.employee.managment.Employee.Management.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String gender;
    private Date dateOfBirth;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String currentAddress;
    private String permanentAddress;


    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skills> skills;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Education> education;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Performance> performance;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<LeaveManagement> leaveManagement;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Documents> documents;

}
