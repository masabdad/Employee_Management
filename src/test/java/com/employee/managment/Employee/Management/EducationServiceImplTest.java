package com.employee.managment.Employee.Management;

import com.employee.managment.Employee.Management.model.Education;
import com.employee.managment.Employee.Management.model.Employee;
import com.employee.managment.Employee.Management.repository.EducationRepo;
import com.employee.managment.Employee.Management.service.EducationService;
import com.employee.managment.Employee.Management.service.serviceImpl.EducationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)

public class EducationServiceImplTest {

    @Mock
    EducationRepo educationRepo;
    @Mock
    EducationService educationService;
    @InjectMocks
    EducationServiceImpl educationServiceImpl;

    @Test
    public void testEmployeeServiceImpl_GetAllEmployee() {
        Date date = Date.from(Instant.ofEpochSecond(2020-12-12));
        Education education = Education.builder().educationId(12l).employee(Employee.builder().employeeId(12l).build())
                .degree("bs")
                .institution("ws")
                .yearOfCompletion(2019)
                .build();
        when(educationRepo.save(education)).thenReturn(education);
        verify(educationServiceImpl, times(1)).addEmployeeEducation(education);

    }

}