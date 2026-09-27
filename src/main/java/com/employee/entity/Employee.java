package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
    private String id;

    private String employeeName;

    private String employeeEmail;

    private Long employeePhone;

    private String employeeGender;

    private String employeeSalary;

    private String employeeRole;
    
}
