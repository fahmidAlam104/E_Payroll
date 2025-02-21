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

@Component
public class serviceCrudOperations {
    @Autowired @Qualifier("EmployeeCrud")
    dbEmployeeCrud employeeDbInstance;
    @Autowired @Qualifier("DepartmentCrud")
    dbDepartmentCrud departmentDbInstance;
    @Autowired @Qualifier("JobTitleCrud")
    dbJobTitleCrud jobTitleDbInstance;
      public  void add(Object obj){
          if(obj.getClass().equals(Employee.class)){
              Employee emp=(Employee)obj;
             employeeDbInstance.add(emp);
          } else if (obj.getClass().equals(Department.class)) {
              Department department=(Department) obj;
              departmentDbInstance.add(department);
          } else if (obj.getClass().equals(JobTitle.class)) {
              JobTitle jobTitle=(JobTitle) obj;
              jobTitleDbInstance.add(jobTitle);
          }
      }
    public  void remove(Object obj){
        if(obj.getClass().equals(Employee.class)){
            Employee emp=(Employee)obj;
            employeeDbInstance.remove(emp);
        } else if (obj.getClass().equals(Department.class)) {
            Department department=(Department) obj;
            departmentDbInstance.remove(department);
        } else if (obj.getClass().equals(JobTitle.class)) {
            JobTitle jobTitle=(JobTitle) obj;
            jobTitleDbInstance.remove(jobTitle);
        }
    }
    public  void edit(Object obj){
        if(obj.getClass().equals(Employee.class)){
            Employee emp=(Employee)obj;
            employeeDbInstance.edit(emp);
        } else if (obj.getClass().equals(Department.class)) {
            Department department=(Department) obj;
            departmentDbInstance.edit(department);
        } else if (obj.getClass().equals(JobTitle.class)) {
            JobTitle jobTitle=(JobTitle) obj;
            jobTitleDbInstance.edit(jobTitle);
        }
    }
    public  HashMap<?,?> getAll(String choice){
          if("Employee".equals(choice)){
            return employeeDbInstance.getAll();
        }else if ("Department".equals(choice)){
            return departmentDbInstance.getAll();
        }
        else if("Job Title".equals(choice)){
            return jobTitleDbInstance.getAll();
        }
        return null;
    }
    public HashMap<Long,Employee> payRoll(){
       return employeeDbInstance.getAll();
    }
    public Object hasKey(String type,Object Key){
          Object ans=null;
        if("Employee".equals(type)){
            ans=employeeDbInstance.hasKey(Key);
        }else if ("Department".equals(type)){
            ans=departmentDbInstance.hasKey(Key);
        }
        else if("Job Title".equals(type)){
            ans=jobTitleDbInstance.hasKey(Key);
        }
        return ans;
    }
}
