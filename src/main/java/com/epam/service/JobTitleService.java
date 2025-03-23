package com.epam.service;

import com.epam.DTO.JobTitleDTO;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.JobTitleRepository;
import com.epam.Utility.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTitleService {
    private static final Logger logger= LoggerFactory.getLogger(JobTitleService.class);
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(JobTitleDTO obj){
        logger.info("Starting JobTitleService add...");
        JobTitle emp=dtoToEntity.toJobTitle(obj);
        jobTitleRepository.save(emp);
        logger.info("Done JobTitleService add...");
    }

    public void editById(JobTitleDTO JobTitleDTO, Long idd){
        logger.info("Starting JobTitleService editById...");
        JobTitle newEmp=dtoToEntity.toJobTitle(JobTitleDTO);
        newEmp.setId(idd);
        jobTitleRepository.save(newEmp);
        logger.info("Done JobTitleService add...");
    }
    public void removeById(Long depId){
        logger.info("Starting JobTitleService removeById...");
        jobTitleRepository.deleteById(depId);
        logger.info("Done JobTitleService removeById...");
    }
    public JobTitleDTO getById(Long id){
        logger.info("Starting JobTitleService getById...");
        return entityToDTO.toJobTitleDTO(jobTitleRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("No such Job with the given id")));
    }
}
