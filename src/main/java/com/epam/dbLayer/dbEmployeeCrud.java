package com.epam.dbLayer;

import com.epam.Models.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("EmployeeCrud")
public class dbEmployeeCrud implements DbInterface<Employee>{
    public void add(Employee employee){
      dbInstance.getEmployeeDbInstance().put(employee.getEmployeeId(), employee);
    }
    public void remove(Employee employee){
        dbInstance.getEmployeeDbInstance().remove(employee.getEmployeeId(), employee);
    }
    public void edit(Employee employee){
        add(employee);
    }
    public Employee getById(Long employeeId){
        return dbInstance.getEmployeeDbInstance().getOrDefault(employeeId, null);
    }
    public HashMap<Long,Employee> getAll(){
      return dbInstance.getEmployeeDbInstance();
    }
    public void generatePayroll(){
//        for(Map.Entry<Long,Employee> entry:dbInstance.getEmployeeDbInstance().entrySet()){
//            String jobTitle=entry.getValue().getJobTitle();
//            Long low=dbInstance.getJobTitleDbInstance().get(jobTitle).getSalaryLowerRange();
//            Long high=dbInstance.getJobTitleDbInstance().get(jobTitle).getSalaryUpperRange();
//            System.out.println(entry.getValue()+"having Salary in range ["+low+" "+high+"]");
//        }
    }
    public Employee hasKey(Object key){
        return dbInstance.getEmployeeDbInstance().get((Long)key);
    }
}
