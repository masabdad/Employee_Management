package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public interface EmployeeService {
    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> addEmployee(Employee employee);

    ResponseEntity<Employee> getById( Long id);

    ResponseEntity<Employee> deleteEmployeeById(Long id);

    ResponseEntity<Employee> updateEmployee(Employee employee, Long id);


    ResponseEntity<List<Employee>> getEmployeeByAge();

    ResponseEntity<List<Employee>> getEmployeeByNationality();

    ResponseEntity<Employee> getNewestEmployee();


    ResponseEntity<Employee> updateEmployeeStatus(Long activeEmployeeId, String newStatus);

}
