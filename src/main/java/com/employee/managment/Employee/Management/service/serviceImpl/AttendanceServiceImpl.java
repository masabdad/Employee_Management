package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.Attendance;
import com.employee.managment.Employee.Management.repository.AttendanceRepo;
import com.employee.managment.Employee.Management.repository.EmployeeRepo;
import com.employee.managment.Employee.Management.service.AttendanceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepo attendanceRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        try {
            List<Attendance> attendances = attendanceRepo.findAll();
            return new ResponseEntity<>(attendances, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Attendance> addAttendance(Attendance attendance) {
        try {
            Optional<Attendance> attendance1 = attendanceRepo.findById(attendance.getAttendanceId());
            if (!attendance1.isPresent()) {
                return new ResponseEntity<>(attendanceRepo.save(attendance), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Attendance> getAttendanceById(Long id) {
        try {
            Attendance attendance = attendanceRepo.getById(id);
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
