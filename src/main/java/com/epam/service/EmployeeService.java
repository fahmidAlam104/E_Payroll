package com.epam.service;

import com.epam.DTO.EmployeeDTO;
import com.epam.Models.Employee;
import com.epam.RepositoryLayer.EmployeeRepository;
import com.epam.Utility.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
    public  void add(EmployeeDTO obj){
            Employee emp=dtoToEntity.toEmployee(obj);
            employeeDbInstance.save(emp);
    }

    public void editById(EmployeeDTO employeeDTO,Long idd){
            Employee newEmp=dtoToEntity.toEmployee(employeeDTO);
            newEmp.setEmployeeId(idd);
            employeeDbInstance.save(newEmp);
    }
    public void removeById(Long empId){
            employeeDbInstance.deleteById(empId);
    }
    public EmployeeDTO getById(Long id){
            Optional<Employee> tmp= employeeDbInstance.findById(id);
            if(tmp.isPresent()){
                return entityToDTO.toEmployeeDTO(tmp.get());
            }
            else{
                throw new EmployeeNotFoundException("No such employee with the given id:-"+id);
            }
    }
}
