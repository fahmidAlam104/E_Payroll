package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.DTO.EmployeeDTO;
import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.DepartmentRepository;
import com.epam.RepositoryLayer.JobTitleRepository;
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
    DepartmentRepository departmentDbInstance;
    @Autowired
    JobTitleRepository jobTitleDbInstance;

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
       if(job.get().getSalaryLowerRange()> employee.getSalary() || job.get().getSalaryUpperRange()<employee.getSalary()){
           throw new IllegalArgumentException("Employees Salary is not in his departments salary range -["+job.get().getSalaryLowerRange()+" , "+job.get().getSalaryUpperRange()+"]");
       }
       employee.setJoiningDate(new Date());
       /// ////////////////////////////////   how to fix this?? (crud<dep,str> injection)
        departmentDbInstance.incrementEmployeeCount(emp.getDepartmentName());
        /// ///////////////
       return employee;
    }
    public Department toDepartment(DepartmentDTO dep){
        Department depp =objectMapper.convertValue(dep, Department.class);
        depp.setDepartmentId(0L);
        depp.setEmployeeCount(0l);
        return depp;
    }
    public JobTitle toJobTitle(JobTitleDTO job){
        JobTitle jb = objectMapper.convertValue(job, JobTitle.class);
        jb.setJobId(0L);
        return jb;
    }
}
