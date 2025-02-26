package com.epam.Controller;

import com.epam.DTO.JobTitleDTO;
import com.epam.service.JobTitleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/JobTitle")
public class JobTitleController {
    @Autowired
    JobTitleService serviceCrudOperations;
    @GetMapping("/{id}")
    public JobTitleDTO getJobTitle(@PathVariable String id){
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody JobTitleDTO jobTitle){
        serviceCrudOperations.add(jobTitle);
    }
    @DeleteMapping("/{jobId}")
    public void delete(@NotBlank(message = "Job Id to be deleted is Blank")@PathVariable String jobId){
        serviceCrudOperations.removeById(jobId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody JobTitleDTO jobTitle,String id){
        serviceCrudOperations.editById(jobTitle,id);
    }
}
