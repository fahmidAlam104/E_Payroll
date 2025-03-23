package com.epam.DTO;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTitleDTO {
    @NotBlank(message = "Job Designation cannot be Blank")
    String designation;
    @Min(value = 10L,message = "Salary Lower Range is too low")
    @Max(value = 1000000L,message = "Salary lower range is too high")
    Long salaryLowerRange;
    @Min(value = 10L,message = "Salary Upper Range is too low")
    @Max(value = 100000000L,message = "Salary Upper range is too high")
    Long salaryUpperRange;
}
