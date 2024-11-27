package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {
}
