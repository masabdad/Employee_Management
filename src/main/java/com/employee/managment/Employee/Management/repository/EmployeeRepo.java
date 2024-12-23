package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByUserName(String username);

}
