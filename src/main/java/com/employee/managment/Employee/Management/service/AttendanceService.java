package com.employee.managment.Employee.Management.service;

import com.employee.managment.Employee.Management.model.Attendance;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttendanceService {
    ResponseEntity<List<Attendance>> getAllAttendance();

    ResponseEntity<Attendance> addAttendance(Attendance attendance);

    ResponseEntity<Attendance> getAttendanceById(Long id);
}
