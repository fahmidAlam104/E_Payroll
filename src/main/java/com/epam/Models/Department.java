package com.epam.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Department implements Serializable {
    @Id
    String departmentName;
    String departmentHead;
    Long departmentId;
    Long employeeCount;

    public Department(){
    }
    public Department(String departmentName, String departmentHead, Long departmentId) {
        setDepartmentName(departmentName);
        setDepartmentHead(departmentHead);
        setDepartmentId(departmentId);
        setEmployeeCount(0L);
        System.err.println(departmentName+" "+departmentHead+" "+departmentId);

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if(departmentName==null) throw new IllegalArgumentException("Department Name");
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        if(departmentHead==null) throw new IllegalArgumentException("Department Head");
        this.departmentHead = departmentHead;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        if(departmentId==null) throw new IllegalArgumentException("Department Id");
        this.departmentId = departmentId;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Long employeeCount) {
        if(employeeCount==null) throw new IllegalArgumentException("Employee Count");
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                ", departmentId=" + departmentId +
                ", employeeCount=" + employeeCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getDepartmentName(), that.getDepartmentName()) && Objects.equals(getDepartmentHead(), that.getDepartmentHead()) && Objects.equals(getDepartmentId(), that.getDepartmentId()) && Objects.equals(getEmployeeCount(), that.getEmployeeCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentName(), getDepartmentHead(), getDepartmentId(), getEmployeeCount());
    }

}
