package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.ProficiencyLevel;
import jakarta.persistence.JoinColumn;

public class Skills {
    private int skillId;

    @JoinColumn(name = "employeeId")
    private int employeeId;
    private String skillName;
    private ProficiencyLevel proficiencyLevel;

}
