package com.epam.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Employee Name cannot be Blank")
    String name;
    @Email(message = "Email does not match the standard email pattern")
    @NotBlank(message = "Email cannot be Blank")
    String email;
    @NotBlank(message = "Department Name cannot be Blank")
    String departmentName;
    @NotBlank(message = "Job Name cannot be Blank")
    String jobName;
}
