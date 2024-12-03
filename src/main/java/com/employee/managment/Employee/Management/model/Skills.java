package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.ProficiencyLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private String skillName;

    @Enumerated(EnumType.STRING)
    private ProficiencyLevel proficiencyLevel;

    // Getters and Setters


    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public ProficiencyLevel getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
}
