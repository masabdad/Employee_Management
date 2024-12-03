package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.Education;
import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.repository.EducationRepo;
import com.employee.managment.Employee.Management.repository.EmployeeRepo;
import com.employee.managment.Employee.Management.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    EducationRepo educationRepo;

    @Override
    public ResponseEntity<List<Education>> getEmployeesEducation(Long id) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employee.isPresent()) {
                List<Education> educations = employee.get().getEducation();
                return new ResponseEntity<>(educations, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Education>> getAllEducation() {
        try {
           List<Education> education= educationRepo.findAll();
            return new ResponseEntity<>(education,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Education> addEmployeeEducation(Education education) {
        try {
            educationRepo.save(education);
            return new ResponseEntity<>(education, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Education> updateEducationById(Education education,Long id) {
        try {
            Optional<Education> education1 = educationRepo.findById(id);
            if (!education1.isPresent()){
                educationRepo.save(education);
                return new ResponseEntity<>(education, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
