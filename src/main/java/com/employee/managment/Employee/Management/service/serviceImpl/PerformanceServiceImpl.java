package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.model.Performance;
import com.employee.managment.Employee.Management.repository.EmployeeRepo;
import com.employee.managment.Employee.Management.repository.PerformanceRepo;
import com.employee.managment.Employee.Management.service.EmployeeService;
import com.employee.managment.Employee.Management.service.PerformanceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    PerformanceRepo performanceRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public ResponseEntity<List<Performance>> getAllReviews(Performance performance) {
        try {
            List<Performance> performance1 = performanceRepo.findAll();
            return new ResponseEntity<>(performance1,HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Performance> addFeedback(Performance performance) {
        try {
            Performance performance1 = performanceRepo.save(performance);
            return new ResponseEntity<>(performance1, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Performance>> getEmployeeReviewById(Long id) {
        try {
          Optional<Employee> employee = employeeRepo.findById(id);
          List<Performance> performance = employee.get().getPerformance();
          return new ResponseEntity<>(performance, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Performance> getReviewById(Long id) {
        try {
            if (performanceRepo.existsById(id)) {
                Optional<Performance> performance = performanceRepo.findById(id);
                return new ResponseEntity(performance, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
