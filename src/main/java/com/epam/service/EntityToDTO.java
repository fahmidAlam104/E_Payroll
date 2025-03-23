package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.DTO.EmployeeDTO;
import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityToDTO {
    @Autowired
    ObjectMapper objectMapper;
    public EmployeeDTO toEmployeeDTO(Employee emp){
        EmployeeDTO employeeDTO=objectMapper.convertValue(emp, EmployeeDTO.class);
        employeeDTO.setDepId(emp.getDepartment().getId());
        employeeDTO.setJobId(emp.getJobTitle().getId());
        return employeeDTO;
    }
    public DepartmentDTO toDepartmentDTO(Department dep){
        return objectMapper.convertValue(dep, DepartmentDTO.class);
    }
    public JobTitleDTO toJobTitleDTO(JobTitle job){
        return objectMapper.convertValue(job, JobTitleDTO.class);
    }
}
