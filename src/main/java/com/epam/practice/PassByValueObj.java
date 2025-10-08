package com.epam.practice;

import com.epam.Models.Employee;

public class PassByValueObj {
    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.setName("Fahmid");

        Employee employee1=employee;
        System.out.println(employee+" "+employee1);

        employee.setId(1L);
        System.out.println(employee+" "+employee1);

        employee1.setEmail("abc");
        System.out.println(employee+" "+employee1);
    }
}
