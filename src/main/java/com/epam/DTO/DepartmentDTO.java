package com.epam.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Department Name cannot be Blank")
    String name;
    @NotBlank(message = "Department Head Name cannot be Blank")
    String head;
    @NotNull(message = "bonus cannot be NULL")
    Double bonus;
}
