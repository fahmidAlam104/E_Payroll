package com.epam.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee implements Serializable {
    String name,email;
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    Department department;
    @ManyToOne(targetEntity = JobTitle.class)
    @JoinColumn(name = "job_designation_id")
    JobTitle jobTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;
    Date joiningDate;
    Long salary;
    private static Long employeeIdGenerator=0L;
}
