package com.epam.Controller;

import com.epam.DTO.DepartmentDTO;
import com.epam.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    DepartmentService serviceCrudOperations;
    @GetMapping("/{id}")
    public DepartmentDTO get(@PathVariable String id){
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody DepartmentDTO department){
        serviceCrudOperations.add(department);
    }
    @DeleteMapping("/{departmentId}")
    public void delete(@NotBlank(message = "Department Id to be deleted is Blank") @PathVariable String departmentId){
        serviceCrudOperations.removeById(departmentId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody DepartmentDTO department,String id){
        serviceCrudOperations.editById(department,id);
    }
}
