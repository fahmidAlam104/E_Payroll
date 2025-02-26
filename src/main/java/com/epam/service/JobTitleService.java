package com.epam.service;

import com.epam.DTO.JobTitleDTO;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void editById(JobTitleDTO JobTitleDTO, String idd){
        JobTitle newEmp=dtoToEntity.toJobTitle(JobTitleDTO);
        newEmp.setJobDesignation(idd);
        jobTitleRepository.save(newEmp);
    }
    public void removeById(String depId){
        jobTitleRepository.deleteById(depId);
    }
    public JobTitleDTO getById(String id){
        Optional<JobTitle> tmp= jobTitleRepository.findById(id);
        if(tmp.isPresent()){
            return entityToDTO.toJobTitleDTO(tmp.get());
        }
        else{
            throw new IllegalArgumentException("No such Job with the given id");
        }
    }
}
