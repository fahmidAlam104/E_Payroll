package com.epam.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Department Name cannot be Blank")
    String departmentName;
    @NotBlank(message = "Department Head Name cannot be Blank")
    String departmentHead;
}
