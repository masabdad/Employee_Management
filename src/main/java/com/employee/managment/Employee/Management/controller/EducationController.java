package com.employee.managment.Employee.Management.controller;

import com.employee.managment.Employee.Management.model.Education;
import com.employee.managment.Employee.Management.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    EducationService educationService;

    @GetMapping("/getEmployeeEducation/{id}")
    public ResponseEntity<List<Education>> getEducationByEmployeeId(@PathVariable Long id){
        return educationService.getEmployeesEducation(id);
    }

    @GetMapping("/getAllEducation")
    public ResponseEntity<Education> getAllEducation(@RequestBody Education edu){
        return educationService.getAllEducation(edu);
    }

    @PostMapping("/addEducation")
    public ResponseEntity<Education> addEducation(@RequestBody Education education){
        return educationService.addEmployeeEducation(education);
    }

    @PutMapping("/updateEducation/{id}")
    public ResponseEntity<Education> updateEducation(@RequestBody Education education, @PathVariable Long id){
        return educationService.updateEducationById(education, id);
    }


}
