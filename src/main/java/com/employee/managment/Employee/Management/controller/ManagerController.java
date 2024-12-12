package com.employee.managment.Employee.Management.controller;


import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("all-employees")
    public ResponseEntity<List<Employee>> getEmployee(){
        return managerService.getAllEmployeesByAdmin();
    }
}
