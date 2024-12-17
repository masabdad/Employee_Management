package com.employee.managment.Employee.Management.schedular;


import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@ConditionalOnProperty(name = "employeeDetails.scheduler.enabled", matchIfMissing = true)
public class EmployeeScheduler {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeScheduler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @SchedulerLock(name = "employeeServiceImplScehduler", lockAtLeastFor = "PT2M", lockAtMostFor = "PT10M")
    @Scheduled(fixedRate = 15000)
    public void employeeDetails()throws IOException{
        Employee employee = new Employee();
        employeeService.addEmployee(employee);
    }
}
