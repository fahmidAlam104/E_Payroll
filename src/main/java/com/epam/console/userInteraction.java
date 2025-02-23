package com.epam.console;

import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.service.serviceCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class userInteraction {
    @Autowired
    serviceCrudOperations serviceCrudOperations;

    public JobTitle createJob(Scanner scanner){
        System.out.print("Enter Job ID : ");
        Long jobId = scanner.nextLong();
        scanner.nextLine();  // Consume the newline character left after nextLong()

        System.out.print("Enter Job Designation: ");
        String jobDesignation = scanner.nextLine();

        System.out.print("Enter Salary Lower Range : ");
        Long salaryLowerRange = scanner.nextLong();

        System.out.print("Enter Salary Upper Range : ");
        Long salaryUpperRange = scanner.nextLong();

        scanner.nextLine();

        // Creating a JobTitle object (Assuming you have a JobTitle class)
        return new JobTitle(jobDesignation,jobId, salaryLowerRange, salaryUpperRange);

    }
    public Department createDepartment(Scanner scanner){
        System.out.print("Enter Department ID : ");
        Long departmentId = scanner.nextLong();
        scanner.nextLine();  // Consume the newline character left after nextLong()

        System.out.print("Enter Department Name: ");
        String departmentName = scanner.nextLine();

        System.out.print("Enter Department Head: ");
        String departmentHead = scanner.nextLine();

      return new Department( departmentName, departmentHead, departmentId);
    }
    public Employee createEmployee(Scanner scanner){

        System.out.print("Enter Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Department dep=null;
        while(dep==null) {
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            dep = (Department) serviceCrudOperations.hasKey("Department", department);
            if(dep!=null) break;
            System.err.println("The department does not exist, please re-enter correct department");
        }

        JobTitle job=null;
        while(job==null) {
            System.out.print("Enter Job Title: ");
            String jobTitle = scanner.nextLine();
            job = (JobTitle) serviceCrudOperations.hasKey("Job Title",jobTitle);
            if(job!=null) break;
            System.err.println("The Job Title does not exist, please re-enter correct department");
        }

        Date joiningDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while(joiningDate==null) {
            System.out.print("Enter Joining Date (dd-MM-yyyy): ");
            String joiningDateStr = scanner.nextLine();
            try {
                joiningDate = dateFormat.parse(joiningDateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
                e.printStackTrace();
            }
        }
        return new Employee( name, email, dep,job,joiningDate);
    }
    @Autowired
    Scanner scanner;
    public void userInteractionStart(){

        while(true) {
            System.out.println("Please select an option from the following:");
            System.out.println("1. Employee");
            System.out.println("2. Department");
            System.out.println("3. Job Title");
            System.out.println("4. Exit");
            System.out.print("Enter the number corresponding to your choice: ");

            int firstChoice = scanner.nextInt();

            if (firstChoice < 1 || firstChoice > 3) {
                System.out.println("Invalid choice. Please select a valid option (1-3).");
               break;
            }

            System.out.println("\nPlease select an action to perform:");
            System.out.println("1. Create");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Read All");
            if(firstChoice==1) {
                System.out.println("5. Generate Payroll");
            }
            System.out.println("6. Exit");
            System.out.print("Enter the number corresponding to your action choice: ");

            int actionChoice = scanner.nextInt();

            if (actionChoice < 1 || actionChoice > (5-(firstChoice==1?0:1))) {
                System.out.println("Invalid action choice. Please select a valid option.");
                break;
            }
          if(firstChoice==1){
             if(actionChoice==1){
                 serviceCrudOperations.add(createEmployee(scanner));
             }
             else if(actionChoice==2){
                 serviceCrudOperations.edit(createEmployee(scanner));
             } else if (actionChoice==3) {
                 serviceCrudOperations.remove(createEmployee(scanner));
             } else if (actionChoice==4) {
                 HashMap<Long,Employee> map= (HashMap<Long, Employee>) serviceCrudOperations.getAll("Employee");
                 System.out.println(map);
             }
             else if(actionChoice==5){
                 serviceCrudOperations.payRoll();
             }
          } else if (firstChoice==2) {
              if(actionChoice==1){
                  serviceCrudOperations.add(createDepartment(scanner));
              }
              else if(actionChoice==2){
                  serviceCrudOperations.edit(createDepartment(scanner));
              } else if (actionChoice==3) {
                  serviceCrudOperations.remove(createDepartment(scanner));
              } else if (actionChoice==4) {
                  HashMap<String,Department> dep=(HashMap<String, Department>) serviceCrudOperations.getAll("Department");
                  System.out.println(dep);
              }
          }
          else if(firstChoice==3){
              if(actionChoice==1){
                  serviceCrudOperations.add(createJob(scanner));
              }
              else if(actionChoice==2){
                  serviceCrudOperations.edit(createJob(scanner));
              } else if (actionChoice==3) {
                  serviceCrudOperations.remove(createJob(scanner));
              } else if (actionChoice==4) {
                 HashMap<String,JobTitle> job=(HashMap<String, JobTitle>) serviceCrudOperations.getAll("Job Title");
                  System.out.println(job);
              }
          }
        }
        scanner.close();
    }
}
