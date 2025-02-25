package com.epam.Controller;

import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.service.serviceCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    serviceCrudOperations serviceCrudOperations;
    @GetMapping
    public List<Department> get(){
        return serviceCrudOperations.getAll("Department");
    }
    @PostMapping
    public void add(@RequestBody Department department){
        serviceCrudOperations.add(department);
    }
    @DeleteMapping("/{departmentId}")
    public void delete(@PathVariable int departmentId){
        serviceCrudOperations.remove(departmentId,"Department");
    }
    @PutMapping
    public void update(@RequestBody Department department){
        serviceCrudOperations.add(department);
    }
}
