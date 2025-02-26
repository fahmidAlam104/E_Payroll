package com.epam.Controller;
import com.epam.DTO.EmployeeDTO;
import com.epam.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService serviceCrudOperations;
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

}
