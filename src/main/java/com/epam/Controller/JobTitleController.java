package com.epam.Controller;

import com.epam.DTO.JobTitleDTO;
import com.epam.service.JobTitleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/jobTitles")
public class JobTitleController {
    @Autowired
    JobTitleService serviceCrudOperations;
    @GetMapping("/{id}")
    public JobTitleDTO getJobTitle(@PathVariable Long id){
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody JobTitleDTO jobTitle){
        serviceCrudOperations.add(jobTitle);
    }
    @DeleteMapping("/{jobId}")
    public void delete(@NotNull(message = "Job Id to be deleted is Blank")@PathVariable Long jobId){
        serviceCrudOperations.removeById(jobId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody JobTitleDTO jobTitle,
                       @PathVariable Long id){
        serviceCrudOperations.editById(jobTitle,id);
    }
}
