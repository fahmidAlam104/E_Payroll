package com.epam.Controller;

import com.epam.DTO.DepartmentDTO;
import com.epam.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    private static final Logger logger= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService serviceCrudOperations;
    @GetMapping("/{id}")
    public DepartmentDTO get(@PathVariable Long id){
        logger.info("GET /api/departments/{} called for", id);
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody DepartmentDTO department){
        logger.info("Post /api/departments called for", department);
        serviceCrudOperations.add(department);
    }
    @DeleteMapping("/{departmentId}")
    public void delete(@NotNull(message = "Department Id to be deleted is Blank") @PathVariable Long departmentId){
        logger.info("Delete /api/departments/{} called for", departmentId);
        serviceCrudOperations.removeById(departmentId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody DepartmentDTO department,@PathVariable Long id){
        logger.info("Put /api/departments/{} called for", id);
        serviceCrudOperations.editById(department,id);
    }
}
