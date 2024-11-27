package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.Education;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EducationService {
    ResponseEntity<List<Education>> getEmployeesEducation(Long id);

    ResponseEntity<Education> getAllEducation(Education edu);

    ResponseEntity<Education> addEmployeeEducation(Education education);

    ResponseEntity<Education> updateEducationById(Education education, Long id);
}
