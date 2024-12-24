package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.LeaveManagement;
import com.employee.managment.Employee.Management.repository.LeaveRepo;
import com.employee.managment.Employee.Management.service.LeaveService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveRepo leaveRepo;

    @Override
    public ResponseEntity<List<LeaveManagement>> getAllLeaveRequests() {
        try {
            List<LeaveManagement> leaveManagements = leaveRepo.findAll();
            return new ResponseEntity<>(leaveManagements, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<LeaveManagement> addLeaveRequest(LeaveManagement leaveManagement) {
        try {
            Optional<LeaveManagement> leaveRequest=leaveRepo.findById(leaveManagement.getLeaveId());
            if (!leaveRequest.isPresent()){
                return new ResponseEntity<>(leaveRepo.save(leaveManagement), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
