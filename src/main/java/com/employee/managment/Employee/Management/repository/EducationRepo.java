package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, Long> {
}
