package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.DTO.EmployeeDTO;
import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.DepartmentRepository;
import com.epam.RepositoryLayer.JobTitleRepository;
import com.epam.Utility.InvalidDataException;
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
       employee.setDepartment(departmentDbInstance.findById(emp.getDepId()).
                      orElseThrow(()-> new IllegalArgumentException("No such department")));

       employee.setJobTitle(jobTitleDbInstance.findById(emp.getJobId()).
                     orElseThrow(()->new IllegalArgumentException("No such job Title")));

       if(employee.getJobTitle().getSalaryLowerRange()> employee.getSalary()
                     || employee.getJobTitle().getSalaryUpperRange()<employee.getSalary()){
           throw new InvalidDataException("Employees Salary is not in his departments " +
                   "salary range -[" +employee.getJobTitle().getSalaryLowerRange()+" , "
                   +employee.getJobTitle().getSalaryUpperRange()+"]");
       }
       employee.setJoiningDate(new Date());
       departmentDbInstance.incrementEmployeeCount(emp.getDepId());
       return employee;
    }
    public Department toDepartment(DepartmentDTO dep){
        Department depp =objectMapper.convertValue(dep, Department.class);
        depp.setEmployeeCount(0L);
        return depp;
    }
    public JobTitle toJobTitle(JobTitleDTO job){
        System.out.println(job);
        JobTitle jb = objectMapper.convertValue(job, JobTitle.class);
        System.out.println(jb);
        return jb;
    }
}
