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
    String name;
    @Column(unique = true)
    String email;
    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "dep_id",referencedColumnName = "dep_id")
    Department department;
    @ManyToOne(targetEntity = JobTitle.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id",referencedColumnName = "job_id")
    JobTitle jobTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date joiningDate;
    Long salary;
}
