package com.employee.managment.Employee.Management.conf;

import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee emp = employeeRepo.findByUserName(username);
        try {

            emp = employeeRepo.findByUserName(username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (emp.getUserName().equals(username)) {
            return User.builder()
                    .username(emp.getUserName())
                    .password(new BCryptPasswordEncoder().encode(emp.getPassword()))
                    .roles(emp.getRole().toString())
                    .build();
        }
        throw new UsernameNotFoundException("Username: " + username + " not found!");
    }


}
