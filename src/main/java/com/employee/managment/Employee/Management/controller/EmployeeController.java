package com.employee.managment.Employee.Management.controller;
import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired(required = true)
    EmployeeService employeeService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @GetMapping("/getAgeOfEmployee40")
    public ResponseEntity<List<Employee>> getByAge() {
        return employeeService.getEmployeeByAge();
    }

    @GetMapping("/getNationalityOfEmployees")
    public ResponseEntity<List<Employee>> getEmployeeNationality() {
        return employeeService.getEmployeeByNationality();
    }

    @GetMapping("/getNewestEmployee")
    public ResponseEntity<Employee> getNewEmployee() {
        return employeeService.getNewestEmployee();
    }

    @PutMapping(value = "/updateStatus/{activeEmployeeId}/{newStatus}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployeeStatus(
            @PathVariable Long activeEmployeeId,
            @PathVariable String newStatus) {
        return employeeService.updateEmployeeStatus(activeEmployeeId, newStatus);
    }


}


