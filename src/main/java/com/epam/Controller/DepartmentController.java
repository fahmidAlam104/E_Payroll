package com.epam.Controller;

import com.epam.DTO.DepartmentDTO;
import com.epam.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    @Autowired
    DepartmentService serviceCrudOperations;
    @GetMapping("/{id}")
    public DepartmentDTO get(@PathVariable Long id){
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody DepartmentDTO department){
        serviceCrudOperations.add(department);
    }
    @DeleteMapping("/{departmentId}")
    public void delete(@NotNull(message = "Department Id to be deleted is Blank") @PathVariable Long departmentId){
        serviceCrudOperations.removeById(departmentId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody DepartmentDTO department,@PathVariable Long id){
        serviceCrudOperations.editById(department,id);
    }
}
