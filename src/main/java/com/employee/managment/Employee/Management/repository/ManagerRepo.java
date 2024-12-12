package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Employee, Long> {
}
