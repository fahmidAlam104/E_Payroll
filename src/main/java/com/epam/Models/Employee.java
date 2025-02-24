package com.epam.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Employee implements Serializable {
    String name,email;
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    Department department;
    @ManyToOne(targetEntity = JobTitle.class)
    @JoinColumn(name = "job_designation_id")
    JobTitle jobTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;
    Date joiningDate;
    private static Long employeeIdGenerator=0L;

    public Employee(){
    }
    public Employee(String name, String email, Department department, JobTitle jobTitle, Date joiningDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        department.setEmployeeCount(department.getEmployeeCount()+1);
        this.jobTitle = jobTitle;
//         employeeIdGenerator++;
        this.joiningDate = joiningDate;
        System.err.println(employeeId+" "+name+" "+email+" "+department+" "+jobTitle+" "+joiningDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null) throw new IllegalArgumentException("Name");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email==null) throw new IllegalArgumentException("Email");
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if(department==null) throw new IllegalArgumentException("Department");
        this.department = department;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        if(jobTitle==null) throw new IllegalArgumentException("Job Title");
        this.jobTitle = jobTitle;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        if(employeeId==null) throw new IllegalArgumentException("Employee ID");
        this.employeeId = employeeId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        if(joiningDate==null) throw new IllegalArgumentException("joiningDate");
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employeeId=" + employeeId +
                ", joiningDate=" + joiningDate +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getJobTitle(), employee.getJobTitle()) && Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(getJoiningDate(), employee.getJoiningDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getDepartment(), getJobTitle(), getEmployeeId(), getJoiningDate());
    }
}
