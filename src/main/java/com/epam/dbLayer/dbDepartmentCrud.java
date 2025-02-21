package com.epam.dbLayer;

import com.epam.Models.Department;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("DepartmentCrud")
public class dbDepartmentCrud implements DbInterface<Department> {
    public  void add(Department department){
        dbInstance.getDepartmentDbInstance().put(department.getDepartmentName(), department);
    }
    public  void remove(Department department){
        dbInstance.getDepartmentDbInstance().remove(department.getDepartmentName(), department);
    }
    public  void edit(Department department){
        add(department);
    }
    public  Department getByName(String departmentName){
        return dbInstance.getDepartmentDbInstance().getOrDefault(departmentName, null);
    }
    public HashMap<String,Department> getAll(){
        return dbInstance.getDepartmentDbInstance();
    }
    public Department hasKey(Object key){
        return dbInstance.getDepartmentDbInstance().get(((String)key));
    }
}
