package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.Gender;
import com.employee.managment.Employee.Management.model.enums.Status;
import jakarta.persistence.*;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId")
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Date dateOfBirth;
    @NonNull
    private Gender gender;
    @NonNull
    private String nationality;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
    @NonNull
    private String currentAddress;
    @NonNull
    private String permanentAddress;
    @NonNull
    private Date dateOfJoining;
    @NonNull
    private Status status;

    @ManyToOne
    @JoinColumn(name = "managerId")
    private Integer managerId;

}
