package com.epam.dbLayer;

import com.epam.Models.JobTitle;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("JobTitleCrud")
public class dbJobTitleCrud implements DbInterface<JobTitle>{
    public void add(JobTitle jobTitle){
        dbInstance.getJobTitleDbInstance().put(jobTitle.getJobDesignation(), jobTitle);
    }
    public void remove(JobTitle employee){
        dbInstance.getJobTitleDbInstance().remove(employee.getJobDesignation(), employee);
    }
    public  void edit(JobTitle employee){
        add(employee);
    }
    public JobTitle getByDesignation(String jobDesignation){
        return dbInstance.getJobTitleDbInstance().getOrDefault(jobDesignation, null);
    }
    public HashMap<String,JobTitle> getAll(){
        return dbInstance.getJobTitleDbInstance();
    }

    public JobTitle hasKey(Object key) {
        return dbInstance.getJobTitleDbInstance().get((String)key);
    }
}
