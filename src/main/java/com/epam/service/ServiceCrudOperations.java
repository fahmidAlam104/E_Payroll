//package com.epam.service;
//
//import com.epam.DTO.DepartmentDTO;
//import com.epam.DTO.EmployeeDTO;
//import com.epam.DTO.JobTitleDTO;
//import com.epam.Models.Department;
//import com.epam.Models.Employee;
//import com.epam.Models.JobTitle;
//import com.epam.RepositoryLayer.DepartmentRepository;
//import com.epam.RepositoryLayer.EmployeeRepository;
//import com.epam.RepositoryLayer.JobTitleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.OptionalPract;
//
//@Service
//public class ServiceCrudOperations {
//    @Autowired
//    EmployeeRepository employeeDbInstance;
//    @Autowired
//    DepartmentRepository departmentDbInstance;
//    @Autowired
//    JobTitleRepository jobTitleDbInstance;
//    @Autowired
//    EntityToDTO entityToDTO;
//    @Autowired
//    DTOToEntity dtoToEntity;
//      public  void add(Object obj){
//          if(obj.getClass().equals(EmployeeDTO.class)){
//              Employee emp=dtoToEntity.toEmployee((EmployeeDTO)obj);
//             employeeDbInstance.save(emp);
//          } else if (obj.getClass().equals(DepartmentDTO.class)) {
//              Department department=dtoToEntity.toDepartment((DepartmentDTO) obj);
//              departmentDbInstance.save(department);
//          } else if (obj.getClass().equals(JobTitleDTO.class)) {
//              JobTitle jobTitle=dtoToEntity.toJobTitle((JobTitleDTO) obj);
//              jobTitleDbInstance.save(jobTitle);
//          }
//      }
//
//    public void editById(Object obj,Long idd){
//        if(obj.getClass().equals(EmployeeDTO.class)){
//            EmployeeDTO employeeDTO=(EmployeeDTO)obj;
//            Employee newEmp=dtoToEntity.toEmployee(employeeDTO);
//            newEmp.setEmployeeId(idd);
//            employeeDbInstance.save(newEmp);
//        } else if (obj.getClass().equals(DepartmentDTO.class)) {
//            DepartmentDTO departmentDTO=(DepartmentDTO) obj;
//            Department newDep=dtoToEntity.toDepartment(departmentDTO);
//            newDep.setDepartmentId(idd);
//            departmentDbInstance.save(newDep);
//        } else if (obj.getClass().equals(JobTitleDTO.class)) {
//            JobTitle jobTitle=dtoToEntity.toJobTitle((JobTitleDTO) obj);
//            jobTitleDbInstance.save(jobTitle);
//            JobTitleDTO jobTitleDTO=(JobTitleDTO) obj;
//            JobTitle newJob=dtoToEntity.toJobTitle(jobTitleDTO);
//            newJob.setJobId(idd);
//            jobTitleDbInstance.save(newJob);
//        }
//    }
//    public <T> void remove(T id,String type){
//        if("Employee".equals(type)){
//            Long empId=(Long)id;
//            employeeDbInstance.deleteById(empId);
//        }else if ("Department".equals(type)){
//            String departmentId=(String) id;
//            departmentDbInstance.deleteById(departmentId);
//        }
//        else if("Job Title".equals(type)){
//            String jobTitle=(String) id;
//            jobTitleDbInstance.deleteById(jobTitle);
//        }
//    }
//
//    public  void edit(Object obj){
//        if(obj.getClass().equals(EmployeeDTO.class)){
//            Employee emp=dtoToEntity.toEmployee((EmployeeDTO)obj);
//            employeeDbInstance.save(emp);
//        } else if (obj.getClass().equals(DepartmentDTO.class)) {
//            Department department=dtoToEntity.toDepartment((DepartmentDTO) obj);
//            departmentDbInstance.save(department);
//        } else if (obj.getClass().equals(JobTitleDTO.class)) {
//            JobTitle jobTitle=dtoToEntity.toJobTitle((JobTitleDTO) obj);
//            jobTitleDbInstance.save(jobTitle);
//        }
//    }
//    public  <T> List<T> getAll(String choice){
//          if("Employee".equals(choice)){
//            Iterable<Employee> tmp= employeeDbInstance.findAll();
//            List<T> fans = new ArrayList<>();
//            tmp.forEach((o1)->{
//                fans.add((T)entityToDTO.toEmployeeDTO(o1));
//            });
//            return fans;
//        }else if ("Department".equals(choice)){
//              Iterable<Department> tmp=departmentDbInstance.findAll();
//              List<T> fans = new ArrayList<>();
//              tmp.forEach((o1)->{
//                  fans.add((T)entityToDTO.toDepartmentDTO(o1));
//              });
//              return fans;
//        }
//        else if("Job Title".equals(choice)){
//              Iterable<JobTitle> tmp= jobTitleDbInstance.findAll();
//              List<T> fans = new ArrayList<>();
//              tmp.forEach((o1)->{
//                  fans.add((T)entityToDTO.toJobTitleDTO(o1));
//              });
//            return fans;
//        }
//        return null;
//    }
//    public  <T> T getById(String choice,Object id){
//        if("Employee".equals(choice)){
//            OptionalPract<Employee> tmp= employeeDbInstance.findById((Long)id);
//            if(tmp.isPresent()){
//                return (T)entityToDTO.toEmployeeDTO(tmp.get());
//            }
//            else{
//             throw new IllegalArgumentException("No such employee with the given id");
//            }
//        }else if ("Department".equals(choice)){
//            OptionalPract<Department> tmp= departmentDbInstance.findById((String) id);
//            if(tmp.isPresent()){
//                return (T)entityToDTO.toDepartmentDTO(tmp.get());
//            }
//            else{
//                throw new IllegalArgumentException("No such department with the given id");
//            }
//        }
//        else if("Job Title".equals(choice)){
//            OptionalPract<JobTitle> tmp= jobTitleDbInstance.findById((String)id);
//            if(tmp.isPresent()){
//                return (T)entityToDTO.toJobTitleDTO(tmp.get());
//            }
//            else{
//                throw new IllegalArgumentException("No such Job with the given id");
//            }
//        }
//        return null;
//    }
//    public <T> List<T> payRoll(){
//       return (List<T>) employeeDbInstance.findAll();
//    }
//    public Object hasKey(String type,Object Key){
//          Object ans=null;
//        if("Employee".equals(type)){
//            if(employeeDbInstance.findById((Long)Key).isPresent()) {
//                ans = employeeDbInstance.findById((Long) Key).get();
//            }
//        }else if ("Department".equals(type)){
//            if(departmentDbInstance.findById((String)Key).isPresent()){
//            ans=departmentDbInstance.findById((String)Key).get();
//            }
//        }
//        else if("Job Title".equals(type)){
//            if(jobTitleDbInstance.findById((String)Key).isPresent()) {
//                ans = jobTitleDbInstance.findById((String) Key).get();
//            }
//        }
//        return ans;
//    }
//}
