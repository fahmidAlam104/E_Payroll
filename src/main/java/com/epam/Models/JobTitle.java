package com.epam.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobTitle implements Serializable {
    @Id
    String jobDesignation;
    Long jobId;
    Long salaryLowerRange,salaryUpperRange;
}
