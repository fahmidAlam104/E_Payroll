package com.epam.service;

import com.epam.DTO.JobTitleDTO;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.JobTitleRepository;
import com.epam.Utility.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTitleService {
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(JobTitleDTO obj){
        JobTitle emp=dtoToEntity.toJobTitle(obj);
        jobTitleRepository.save(emp);
    }

    public void editById(JobTitleDTO JobTitleDTO, Long idd){
        JobTitle newEmp=dtoToEntity.toJobTitle(JobTitleDTO);
        newEmp.setId(idd);
        jobTitleRepository.save(newEmp);
    }
    public void removeById(Long depId){
        jobTitleRepository.deleteById(depId);
    }
    public JobTitleDTO getById(Long id){
        return entityToDTO.toJobTitleDTO(jobTitleRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("No such Job with the given id")));
    }
}
