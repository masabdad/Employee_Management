package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.LeaveManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<LeaveManagement, Long> {
}
