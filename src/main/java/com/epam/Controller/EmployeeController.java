package com.epam.Controller;
import com.epam.DTO.EmployeeDTO;
import com.epam.Models.Employee;
import com.epam.service.serviceCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    serviceCrudOperations serviceCrudOperations;
    @GetMapping
    public List<EmployeeDTO> get(){
        return serviceCrudOperations.getAll("Employee");
    }
    @PostMapping
    public void add(@RequestBody EmployeeDTO employee){
        serviceCrudOperations.add(employee);
    }
    @DeleteMapping("/{empId}")
    public void delete(@PathVariable int empId){
        serviceCrudOperations.remove((long) empId,"Employee");
    }
    @PutMapping
    public void update(@RequestBody EmployeeDTO employee){
        serviceCrudOperations.add(employee);
    }

}
