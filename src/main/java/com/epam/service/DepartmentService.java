package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.Models.Department;
import com.epam.RepositoryLayer.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(DepartmentDTO obj){
        Department emp=dtoToEntity.toDepartment(obj);
        departmentDbInstance.save(emp);
    }

    public void editById(DepartmentDTO DepartmentDTO, String idd){
        Department newEmp=dtoToEntity.toDepartment(DepartmentDTO);
        newEmp.setDepartmentName(idd);
        departmentDbInstance.save(newEmp);
    }
    public void removeById(String depId){
        departmentDbInstance.deleteById(depId);
    }
    public DepartmentDTO getById(String id){
        Optional<Department> tmp= departmentDbInstance.findById(id);
        if(tmp.isPresent()){
            return entityToDTO.toDepartmentDTO(tmp.get());
        }
        else{
            throw new IllegalArgumentException("No such Department with the given id");
        }
    }
}
