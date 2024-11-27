package com.employee.managment.Employee.Management.controller;


import com.employee.managment.Employee.Management.model.Performance;
import com.employee.managment.Employee.Management.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    PerformanceService performanceService;

    @GetMapping("/getAllReview")
    public ResponseEntity<List<Performance>> getAllReview(@RequestBody Performance performance){
        return performanceService.getAllReviews(performance);
    }

    @PostMapping("/addReview")
    public ResponseEntity<Performance> addReview(@RequestBody Performance performance){
        return performanceService.addFeedback(performance);
    }

    @GetMapping("/getEmployeeReviewById/{id}")
    public ResponseEntity<List<Performance>> getReviewOfEmployee(
            @PathVariable Long id
    ){
        return performanceService.getEmployeeReviewById(id);
    }

    @GetMapping("/getReviewById/{id}")
    public ResponseEntity<Performance> getById(@PathVariable Long id){
        return performanceService.getReviewById(id);
    }
}
