package com.epam.Controller;
import com.epam.DTO.EmployeeDTO;
import com.epam.service.EmployeeService;
import com.epam.service.PayrollService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService serviceCrudOperations;
    @Autowired
    PayrollService payrollService;
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Long id){
       return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody EmployeeDTO employee){
        serviceCrudOperations.add(employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceCrudOperations.removeById(id);
    }
    @PutMapping("/{id}")
    public void updateById(@Valid @RequestBody EmployeeDTO employee,@PathVariable Long id){
        serviceCrudOperations.editById(employee,id);
    }
    @GetMapping("/payroll")
    public List<EmployeeDTO> generatePayroll(){
        return payrollService.processPayroll();
    }
    @GetMapping("/department/{departmentName}/average-salary")
    public Double getAverageSalaryByDepartment(@PathVariable String departmentName){
        return serviceCrudOperations.calculateAverageSalaryByDepartment(departmentName);
    }

    @GetMapping("/grouped-by-department")
    public Map<String,List<EmployeeDTO>> groupByDep(){
        return serviceCrudOperations.getEmployeesGroupedByDepartment();
    }

    @GetMapping("/top-salaries/{n}")
    public List<EmployeeDTO> topN(@PathVariable @NotNull Integer n){
        return serviceCrudOperations.getTopNHighestPaidEmployees(n);
    }

    @GetMapping("/payroll/job-title/{jobTitle}")
    public Integer salarySumByTitle(@PathVariable @NotNull String jobTitle){
        return serviceCrudOperations.calculatePayrollByJobTitle(jobTitle);
    }

    @GetMapping("/hired-in-last/{months}")
    public List<EmployeeDTO> monthDifference(@PathVariable @NotNull Integer months){
        return serviceCrudOperations.findEmployeesHiredInLastNMonths(months);
    }
}
