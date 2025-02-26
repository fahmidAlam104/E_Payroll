package com.epam.Controller;

import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.service.serviceCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JobTitle")
public class JobTitleController {
    @Autowired
    serviceCrudOperations serviceCrudOperations;
    @GetMapping
    public List<JobTitleDTO> getJobTitle(){
        return serviceCrudOperations.getAll("Job Title");
    }
    @PostMapping
    public void add(@RequestBody JobTitleDTO jobTitle){
        serviceCrudOperations.add(jobTitle);
    }
    @DeleteMapping("/{jobId}")
    public void delete(@PathVariable String jobId){
        serviceCrudOperations.remove(jobId,"Job Title");
    }
    @PutMapping
    public void update(@RequestBody JobTitleDTO jobTitle){
        serviceCrudOperations.add(jobTitle);
    }
}
