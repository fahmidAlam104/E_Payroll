package com.epam.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobTitle implements Serializable {
    @Column(unique = true)
    String designation;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    Long id;
    Long salaryLowerRange,salaryUpperRange;
}
