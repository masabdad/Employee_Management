package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.Performance;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PerformanceService {
    ResponseEntity<List<Performance>> getAllReviews(Performance performance);

    ResponseEntity<Performance> addFeedback(Performance performance);

    ResponseEntity<List<Performance>> getEmployeeReviewById(Long id);

    ResponseEntity<Performance> getReviewById(Long id);
}
