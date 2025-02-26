package com.epam.service;

import com.epam.DTO.DepartmentDTO;
import com.epam.DTO.EmployeeDTO;
import com.epam.DTO.JobTitleDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.dbLayer.dbDepartmentCrud;
import com.epam.dbLayer.dbEmployeeCrud;
import com.epam.dbLayer.dbJobTitleCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceCrudOperations {
    @Autowired
    dbEmployeeCrud employeeDbInstance;
    @Autowired
    dbDepartmentCrud departmentDbInstance;
    @Autowired
    dbJobTitleCrud jobTitleDbInstance;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    DTOToEntity dtoToEntity;
      public  void add(Object obj){
          if(obj.getClass().equals(EmployeeDTO.class)){
              Employee emp=dtoToEntity.toEmployee((EmployeeDTO)obj);
             employeeDbInstance.save(emp);
          } else if (obj.getClass().equals(DepartmentDTO.class)) {
              Department department=dtoToEntity.toDepartment((DepartmentDTO) obj);
              departmentDbInstance.save(department);
          } else if (obj.getClass().equals(JobTitleDTO.class)) {
              JobTitle jobTitle=dtoToEntity.toJobTitle((JobTitleDTO) obj);
              jobTitleDbInstance.save(jobTitle);
          }
      }
    public <T> void remove(T id,String type){
        if("Employee".equals(type)){
            Long empId=(Long)id;
            employeeDbInstance.deleteById(empId);
        }else if ("Department".equals(type)){
            String departmentId=(String) id;
            departmentDbInstance.deleteById(departmentId);
        }
        else if("Job Title".equals(type)){
            String jobTitle=(String) id;
            jobTitleDbInstance.deleteById(jobTitle);
        }
    }

    public  void edit(Object obj){
        if(obj.getClass().equals(EmployeeDTO.class)){
            Employee emp=dtoToEntity.toEmployee((EmployeeDTO)obj);
            employeeDbInstance.save(emp);
        } else if (obj.getClass().equals(DepartmentDTO.class)) {
            Department department=dtoToEntity.toDepartment((DepartmentDTO) obj);
            departmentDbInstance.save(department);
        } else if (obj.getClass().equals(JobTitleDTO.class)) {
            JobTitle jobTitle=dtoToEntity.toJobTitle((JobTitleDTO) obj);
            jobTitleDbInstance.save(jobTitle);
        }
    }
    public  <T> List<T> getAll(String choice){
          if("Employee".equals(choice)){
            List<Employee> tmp=(List<Employee>) employeeDbInstance.findAll();
            List<T> fans = new ArrayList<>();
            tmp.forEach((o1)->{

                fans.add((T)entityToDTO.toEmployeeDTO(o1));
            });
            return fans;
        }else if ("Department".equals(choice)){
              List<Department> tmp=(List<Department>) departmentDbInstance.findAll();
              List<T> fans = new ArrayList<>();
              tmp.forEach((o1)->{
                  fans.add((T)entityToDTO.toDepartmentDTO(o1));
              });
              return fans;
        }
        else if("Job Title".equals(choice)){
              List<JobTitle> tmp=(List<JobTitle>) jobTitleDbInstance.findAll();
              List<T> fans = new ArrayList<>();
              tmp.forEach((o1)->{
                  fans.add((T)entityToDTO.toJobTitleDTO(o1));
              });
            return fans;
        }
        return null;
    }
    public <T> List<T> payRoll(){
       return (List<T>) employeeDbInstance.findAll();
    }
    public Object hasKey(String type,Object Key){
          Object ans=null;
        if("Employee".equals(type)){
            if(employeeDbInstance.findById((Long)Key).isPresent()) {
                ans = employeeDbInstance.findById((Long) Key).get();
            }
        }else if ("Department".equals(type)){
            if(departmentDbInstance.findById((String)Key).isPresent()){
            ans=departmentDbInstance.findById((String)Key).get();
            }
        }
        else if("Job Title".equals(type)){
            if(jobTitleDbInstance.findById((String)Key).isPresent()) {
                ans = jobTitleDbInstance.findById((String) Key).get();
            }
        }
        System.out.println(type+" "+ans);
        return ans;
    }
}
