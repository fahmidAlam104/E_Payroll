package com.epam.service;

import com.epam.DTO.EmployeeDTO;
import com.epam.Models.Employee;
import com.epam.RepositoryLayer.DepartmentRepository;
import com.epam.RepositoryLayer.EmployeeRepository;
import com.epam.RepositoryLayer.JobTitleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {
    private static final Logger logger= LoggerFactory.getLogger(PayrollService.class);
    @Autowired
    EmployeeRepository employeeDbInstance;
    @Autowired
    DepartmentRepository departmentDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    public List<EmployeeDTO> processPayroll(){
        logger.info("Starting payroll processing...");
        List<EmployeeDTO> payroll=new ArrayList<>();
        Iterable<Employee> employeeList=employeeDbInstance.findAll();
        employeeList.forEach((emp)->{
            Double bonus=departmentDbInstance.findById(emp.getDepartment().getId()).get().getBonus();
            Long finalSalary = (long) ((emp.getSalary()*(100.0+bonus))/100);
            emp.setSalary(finalSalary);
            payroll.add(entityToDTO.toEmployeeDTO(emp));
        });
        logger.debug("Final salary is", payroll);
        return payroll;
    }
}
