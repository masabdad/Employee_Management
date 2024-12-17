package com.employee.managment.Employee.Management.model;

import com.employee.managment.Employee.Management.model.enums.ProficiencyLevel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
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



}
