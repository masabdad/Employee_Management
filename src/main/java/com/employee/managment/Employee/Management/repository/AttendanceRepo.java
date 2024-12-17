package com.employee.managment.Employee.Management.repository;

import com.employee.managment.Employee.Management.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
