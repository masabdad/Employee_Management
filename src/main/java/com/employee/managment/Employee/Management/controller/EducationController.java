package com.employee.managment.Employee.Management.controller;

import com.employee.managment.Employee.Management.model.Education;
import com.employee.managment.Employee.Management.service.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/education")
public class EducationController {
    @Autowired
    EducationService educationService;

    @GetMapping(value = "/getEmployeeEducation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Education>> getEducationByEmployeeId(@PathVariable Long id){
        return educationService.getEmployeesEducation(id);
    }

    @GetMapping("/getAllEducation")
    public ResponseEntity<List<Education>> getAllEducation(){
        return educationService.getAllEducation();
    }

    @PostMapping("/addEducation")
    @Operation(summary = "Adding Eduction")
    public ResponseEntity<Education> addEducation(@RequestBody Education education){
        return educationService.addEmployeeEducation(education);
    }

    @PutMapping("/updateEducation/{id}")
    public ResponseEntity<Education> updateEducation(@RequestBody Education education, @PathVariable Long id){
        return educationService.updateEducationById(education, id);
    }


}
