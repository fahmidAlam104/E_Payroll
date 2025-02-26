package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.DTO.EmployeeDTO;
import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.dbLayer.dbDepartmentCrud;
import com.epam.dbLayer.dbJobTitleCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DTOToEntity {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    dbDepartmentCrud departmentDbInstance;
    @Autowired
    dbJobTitleCrud jobTitleDbInstance;

    public Employee toEmployee(EmployeeDTO emp){
       Employee employee=objectMapper.convertValue(emp, Employee.class);
       Optional<Department> dep = departmentDbInstance.findById(emp.getDepartmentName());
       if(dep.isPresent()){
           employee.setDepartment(dep.get());
       }
       else{
           throw new IllegalArgumentException("No such department");
       }
       Optional<JobTitle> job=jobTitleDbInstance.findById(emp.getJobName());
       if(job.isPresent()){
           employee.setJobTitle(job.get());
       }
       else{
           throw new IllegalArgumentException("No such job Title");
       }
       employee.setJoiningDate(new Date());
       /// ////////////////////////////////   how to fix this?? (crud<dep,str> injection)
        departmentDbInstance.incrementEmployeeCount(emp.getDepartmentName());
        /// ///////////////
       return employee;
    }
    public Department toDepartment(DepartmentDTO dep){
        return objectMapper.convertValue(dep, Department.class);
    }
    public JobTitle toJobTitle(JobTitleDTO job){
        return objectMapper.convertValue(job, JobTitle.class);
    }
}
