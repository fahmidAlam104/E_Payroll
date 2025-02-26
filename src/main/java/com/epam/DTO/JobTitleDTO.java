package com.epam.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTitleDTO {
    String jobDesignation;
    Long salaryLowerRange,salaryUpperRange;
}
