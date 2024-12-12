package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManagerService {
    ResponseEntity<List<Employee>> getAllEmployeesByAdmin();
}
