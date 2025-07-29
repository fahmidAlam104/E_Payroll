package com.example.EmployeePayrollManagement;

import com.epam.service.EmployeeService;
import com.epam.service.PayrollService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public EmployeeService employeeService() {
        return Mockito.mock(EmployeeService.class);
    }

    @Bean
    @Primary
    public PayrollService payrollService() {
        return Mockito.mock(PayrollService.class);
    }
}