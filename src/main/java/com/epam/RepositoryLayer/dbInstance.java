//package com.epam.RepositoryLayer;
//
//import com.epam.Models.Department;
//import com.epam.Models.Employee;
//import com.epam.Models.JobTitle;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//
//@Component
//public class dbInstance {
//    private static HashMap<Long, Employee> employeeDb=null;
//    private static HashMap<String, Department> departmentDb=null;
//    private static HashMap<String, JobTitle> jobTitleDb=null;
//
//    private dbInstance(){
//    }
//
//    public static HashMap<Long,Employee> getEmployeeDbInstance(){
//        if(employeeDb==null){
//            employeeDb=new HashMap<>();
//            try {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                Date date=simpleDateFormat.parse("22-01-2020");
//             //   employeeDb.put(1L, new Employee("XYZ", "XYZ@gmail.com",departmentDb.get("Testing"), jobTitleDb.get("Intern"),date));
//            }
//            catch(Exception e){
//                throw new IllegalArgumentException("Date is invalid");
//            }
//        }
//        return employeeDb;
//    }
//    public static HashMap<String,Department> getDepartmentDbInstance(){
//        if(departmentDb==null){
//            departmentDb=new HashMap<>();
//         //   departmentDb.put("Testing",new Department("Testing","Srikala",1L));
//        }
//        return departmentDb;
//    }
//    public static HashMap<String,JobTitle> getJobTitleDbInstance(){
//        if(jobTitleDb==null){
//            jobTitleDb=new HashMap<>();
//           // jobTitleDb.put("Intern",new JobTitle("Intern",1L,20000L,25000L));
//        }
//        return jobTitleDb;
//    }
//}