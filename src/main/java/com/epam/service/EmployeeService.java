package com.epam.service;

import com.epam.DTO.EmployeeDTO;
import com.epam.Models.Employee;
import com.epam.RepositoryLayer.EmployeeRepository;
import com.epam.Utility.EntityNotFoundException;
import com.epam.Utility.InvalidDataException;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    EmployeeRepository employeeDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(EmployeeDTO obj){
        logger.info("Starting EmployeeService add...");
        employeeDbInstance.save(dtoToEntity.toEmployee(obj));
        logger.info("Done EmployeeService add...");
    }

    public void editById(EmployeeDTO employeeDTO,Long idd){
        logger.info("Starting EmployeeService editById...");
            Employee newEmp=dtoToEntity.toEmployee(employeeDTO);
            newEmp.setId(idd);
            employeeDbInstance.save(newEmp);
        logger.info("Done EmployeeService editById...");
    }
    public void removeById(Long empId){
        logger.info("Starting EmployeeService removeById...");
            employeeDbInstance.deleteById(empId);
        logger.info("Done EmployeeService removeById...");

    }
    public EmployeeDTO getById(Long id){
        logger.info("Starting EmployeeService getById...");


        Sort sort= Sort.by(Sort.Order.asc("name"),Sort.Order.desc("age"));
        Pageable pg= PageRequest.of(2,2);


       return entityToDTO.toEmployeeDTO(employeeDbInstance.findById(id).
                    orElseThrow(()->new EntityNotFoundException
                            ("No such employee with the given id:-"+id)));
    }

    public Double calculateAverageSalaryByDepartment(String departmentName){
        logger.info("Starting EmployeeService calculateAverageSalaryByDepartment...");
        List<Employee> emp=(List<Employee>) employeeDbInstance.findAll();
        return emp.stream()
                .filter(employee -> employee.getDepartment().getName().equals(departmentName))
                .mapToDouble(Employee::getSalary).average().orElseGet(()->0.0);
    }
    public Map<String,List<EmployeeDTO>> getEmployeesGroupedByDepartment(){
        logger.info("Starting EmployeeService getEmployeesGroupedByDepartment...");
        List<Employee> emp=(List<Employee>) employeeDbInstance.findAll();
       return emp.stream().collect(Collectors.groupingBy(e->e.getDepartment().getName(),
                           Collectors.mapping(x->entityToDTO.toEmployeeDTO(x),Collectors.toList())));
    }
    public List<EmployeeDTO> getTopNHighestPaidEmployees(Integer n){
        logger.info("Starting EmployeeService getTopNHighestPaidEmployees...");
        @NotNull
        List<Employee> emp=(List<Employee>) employeeDbInstance.findAll();
        if(n> emp.size()){
            throw new InvalidDataException(" N is greater than List size");
        }
        return emp.stream().sorted((Comparator.comparingLong(Employee::getSalary)))
                     .limit(n).map(x->entityToDTO.toEmployeeDTO(x)).toList();
    }

    public Integer calculatePayrollByJobTitle(String jobTitle){
        logger.info("Starting EmployeeService calculatePayrollByJobTitle...");
        @NotNull
        List<Employee> emp=(List<Employee>) employeeDbInstance.findAll();
        return emp.stream().
                filter(employee -> employee.getJobTitle().getDesignation().equals(jobTitle))
                .mapToInt(o1-> Math.toIntExact(o1.getSalary())).sum();
    }

    public List<EmployeeDTO> findEmployeesHiredInLastNMonths(Integer months){
        logger.info("Starting EmployeeService findEmployeesHiredInLastNMonths...");
        List<Employee> emp=(List<Employee>) employeeDbInstance.findAll();
        Date startDate= new Date();
        Predicate<Employee> check=(employee)->{
            LocalDate startLocalDate = startDate.toInstant().
                    atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endLocalDate = employee.getJoiningDate().toInstant().
                    atZone(ZoneId.systemDefault()).toLocalDate();
            return ChronoUnit.MONTHS.between(startLocalDate, endLocalDate)<=months;
        };

        return emp.stream().filter(employee -> check.test(employee))
                  .map(x->entityToDTO.toEmployeeDTO(x)).toList();
    }
}
