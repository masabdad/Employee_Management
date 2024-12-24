package com.employee.managment.Employee.Management.controller;

import com.employee.managment.Employee.Management.model.Attendance;
import com.employee.managment.Employee.Management.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/getAllAttendance")
    public ResponseEntity<List<Attendance>> getAttendance(){
        return attendanceService.getAllAttendance();
    }

    @PostMapping("/addAttendance")
    public ResponseEntity<Attendance> add(@RequestBody Attendance attendance){
        return attendanceService.addAttendance(attendance);
    }

    @GetMapping("/getAttendanceById/{id}")
    public ResponseEntity<Attendance> attendanceById(@PathVariable Long id){
        return attendanceService.getAttendanceById(id);
    }

   /* @PostMapping("/asdf")
    @Operation(
            parameters = {},
            description = "",

    )*/


}
