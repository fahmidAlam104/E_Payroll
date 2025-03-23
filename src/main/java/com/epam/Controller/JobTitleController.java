package com.epam.Controller;

import com.epam.DTO.JobTitleDTO;
import com.epam.service.JobTitleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/jobTitles")
public class JobTitleController {
    private static final Logger logger= LoggerFactory.getLogger(JobTitleController.class);
    @Autowired
    JobTitleService serviceCrudOperations;
    @GetMapping("/{id}")
    public JobTitleDTO getJobTitle(@PathVariable Long id){
        logger.info("Get /api/jobTitles/{id} called for"+ id);
        return serviceCrudOperations.getById(id);
    }
    @PostMapping
    public void add(@Valid @RequestBody JobTitleDTO jobTitle){
        logger.info("Post /api/jobTitles called for"+ jobTitle);
        serviceCrudOperations.add(jobTitle);
    }
    @DeleteMapping("/{jobId}")
    public void delete(@NotNull(message = "Job Id to be deleted is Blank")@PathVariable Long jobId){
        logger.info("Delete /api/jobTitles/{} called for"+ jobId);
        serviceCrudOperations.removeById(jobId);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody JobTitleDTO jobTitle,
                       @PathVariable Long id){
        logger.info("Put /api/jobTitles/{id} called for"+ id);
        serviceCrudOperations.editById(jobTitle,id);
    }
}
