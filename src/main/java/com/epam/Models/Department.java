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
public class Department implements Serializable {
    @Id
    String departmentName;
    String departmentHead;
    Long departmentId;
    Long employeeCount;
    Double bonus;
}
