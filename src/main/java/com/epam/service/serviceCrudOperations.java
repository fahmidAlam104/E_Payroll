package com.epam.service;

import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.dbLayer.dbDepartmentCrud;
import com.epam.dbLayer.dbEmployeeCrud;
import com.epam.dbLayer.dbJobTitleCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class serviceCrudOperations {
    @Autowired
    dbEmployeeCrud employeeDbInstance;
    @Autowired
    dbDepartmentCrud departmentDbInstance;
    @Autowired
    dbJobTitleCrud jobTitleDbInstance;
      public  void add(Object obj){
          if(obj.getClass().equals(Employee.class)){
              Employee emp=(Employee)obj;
             employeeDbInstance.save(emp);
          } else if (obj.getClass().equals(Department.class)) {
              Department department=(Department) obj;
              departmentDbInstance.save(department);
          } else if (obj.getClass().equals(JobTitle.class)) {
              JobTitle jobTitle=(JobTitle) obj;
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
        if(obj.getClass().equals(Employee.class)){
            Employee emp=(Employee)obj;
            employeeDbInstance.save(emp);
        } else if (obj.getClass().equals(Department.class)) {
            Department department=(Department) obj;
            departmentDbInstance.save(department);
        } else if (obj.getClass().equals(JobTitle.class)) {
            JobTitle jobTitle=(JobTitle) obj;
            jobTitleDbInstance.save(jobTitle);
        }
    }
    public  <T> List<T> getAll(String choice){
          if("Employee".equals(choice)){
            return (List<T>)employeeDbInstance.findAll();
        }else if ("Department".equals(choice)){
            return (List<T>)departmentDbInstance.findAll();
        }
        else if("Job Title".equals(choice)){
            return (List<T>)jobTitleDbInstance.findAll();
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
