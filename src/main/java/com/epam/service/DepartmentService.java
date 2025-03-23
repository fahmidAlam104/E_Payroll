package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.Models.Department;
import com.epam.RepositoryLayer.DepartmentRepository;
import com.epam.Utility.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(DepartmentDTO obj){
        departmentDbInstance.save(dtoToEntity.toDepartment(obj));
    }

    public void editById(DepartmentDTO DepartmentDTO, Long idd){
        Department newEmp=dtoToEntity.toDepartment(DepartmentDTO);
        newEmp.setId(idd);
        System.out.println(newEmp);
        departmentDbInstance.save(newEmp);
    }
    public void removeById(Long depId){
        departmentDbInstance.deleteById(depId);
    }

    public DepartmentDTO getById(Long id){
       return entityToDTO.toDepartmentDTO(departmentDbInstance.findById(id).
               orElseThrow(()->new EntityNotFoundException("No such Department with the given id")));
    }
}
