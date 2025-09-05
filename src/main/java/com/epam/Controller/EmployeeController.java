package com.epam.Controller;
import com.epam.DTO.EmployeeDTO;
import com.epam.service.EmployeeService;
import com.epam.service.PayrollService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService serviceCrudOperations;
    @Autowired
    PayrollService payrollService;
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable @NotNull Long id){
        logger.info("GET /api/employees/{} called for", id);
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public HttpStatusCode add(@Valid @RequestBody EmployeeDTO employee){
        //Map<Integer,Integer> cnt2=new HashMap<Integer,Integer>();
       // List<Integer> l=new ArrayList<>();
       // l.reversed();
        logger.info("Post /api/employees/{} called for", employee);
        serviceCrudOperations.add(employee);
        return HttpStatus.CREATED;
    }
    @DeleteMapping("/{id}")
    public HttpStatusCode delete(@PathVariable Long id){
        logger.info("Delete /api/employees/{} called for", id);
        serviceCrudOperations.removeById(id);
        return HttpStatus.NO_CONTENT;
    }
    @PutMapping("/{id}")
    public HttpStatus updateById(@Valid @RequestBody EmployeeDTO employee,@PathVariable Long id){
        logger.info("Put /api/employees/{} called for", id);
        serviceCrudOperations.editById(employee,id);
        return HttpStatus.OK;
    }
    @GetMapping("/payroll")
    public List<EmployeeDTO> generatePayroll(){
        logger.info("GET /api/employees/payroll called");
        return payrollService.processPayroll();
    }
    @GetMapping("/department/{departmentName}/average-salary")
    public Double getAverageSalaryByDepartment(@PathVariable String departmentName){
        logger.info("GET /api/employees//department/{departmentName}/average-salary called for", departmentName);
        return serviceCrudOperations.calculateAverageSalaryByDepartment(departmentName);
    }

    @GetMapping("/grouped-by-department")
    public Map<String,List<EmployeeDTO>> groupByDep(){
        logger.info("Get /api/employees/grouped-by-department called");
        return serviceCrudOperations.getEmployeesGroupedByDepartment();
    }

    @GetMapping("/top-salaries/{n}")
    public List<EmployeeDTO> topN(@PathVariable @NotNull Integer n){
        logger.info("Get /api/employees/grouped-by-department called");
        return serviceCrudOperations.getTopNHighestPaidEmployees(n);
    }

    @GetMapping("/payroll/job-title/{jobTitle}")
    public Integer salarySumByTitle(@PathVariable @NotNull String jobTitle){
        logger.info("Get /api/employees/payroll/job-title/{jobTitle} called for"+ jobTitle);
        return serviceCrudOperations.calculatePayrollByJobTitle(jobTitle);
    }

    @GetMapping("/hired-in-last/{months}")
    public List<EmployeeDTO> monthDifference(@PathVariable @NotNull Integer months){
        logger.info("Get /api/employees/hired-in-last/{months} called for"+ months);
        return serviceCrudOperations.findEmployeesHiredInLastNMonths(months);
    }
}
