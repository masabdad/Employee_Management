package com.employee.managment.Employee.Management.service.serviceImpl;

import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.repository.ManagerRepo;
import com.employee.managment.Employee.Management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepo managerRepo;
    @Override
    public ResponseEntity<List<Employee>> getAllEmployeesByAdmin() {
        try {
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
