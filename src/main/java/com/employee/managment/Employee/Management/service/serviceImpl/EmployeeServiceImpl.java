package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.model.Performance;
import com.employee.managment.Employee.Management.model.enums.Status;
import com.employee.managment.Employee.Management.repository.EmployeeRepo;
import com.employee.managment.Employee.Management.repository.PerformanceRepo;
import com.employee.managment.Employee.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    PerformanceRepo performanceRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepo.findAll();
            if (employees != null && !employees.isEmpty()) {
                return new ResponseEntity<>(employees, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Employee> getById(Long id) {
        try {
            if (employeeRepo.existsById(id)) {
                Optional<Employee> employee = employeeRepo.findById(id);
                return new ResponseEntity(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> deleteEmployeeById(Long id) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employeeRepo.findById(id).isPresent()) {
                employeeRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Employee employee, Long id) {
        try {
            Optional<Employee> employee1 = employeeRepo.findById(id);
            if (employee1.isPresent()) {
                employeeRepo.save(employee);
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByAge() {
        List<Employee> employees = employeeRepo.findAll();
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            Date date = emp.getDateOfBirth();

            if (date != null) {
                LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int age = Period.between(birthDate, LocalDate.now()).getYears();
                if (age > 40) {
                    filteredEmployees.add(emp);
                }
            }
        }

        return new ResponseEntity<>(filteredEmployees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByNationality() {
        List<Employee> employees = employeeRepo.findAll();
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            String nationality = emp.getNationality();
            if (nationality != null && nationality.equals("American")) {
                filteredEmployees.add(emp);
            }
        }
        return new ResponseEntity<>(filteredEmployees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> getNewestEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.size() > 0 && !employees.isEmpty()) {
            employees.stream().sorted(Comparator.comparing(e -> e.getDateOfJoining()));
            Employee employee = employees.get(0);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {


            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Employee> updateEmployeeStatus(Long activeEmployeeId, String newStatus) {
        Optional<Employee> activeEmployeeOptional = employeeRepo.findById(activeEmployeeId);
        if (activeEmployeeOptional == null && activeEmployeeOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = activeEmployeeOptional.get();
        employee.setStatus(Status.valueOf(newStatus));
        employeeRepo.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

}
