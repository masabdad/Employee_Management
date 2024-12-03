package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
