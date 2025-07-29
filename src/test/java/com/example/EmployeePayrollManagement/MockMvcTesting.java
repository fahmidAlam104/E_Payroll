package com.example.EmployeePayrollManagement;

import com.epam.Controller.EmployeeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.epam.DTO.EmployeeDTO;
import com.epam.service.EmployeeService;
import com.epam.service.PayrollService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)          // loads spring mvc components not the full application context. Limits the test to userController. Other beans (service)are not loaded.
public class MockMvcTesting {
    @Autowired
    private MockMvc mockMvc;

   @MockBean                                           // mocks the userService and injects in into the spring context, replacing real service bean.
    private EmployeeService employeeService;

    @MockBean
    private PayrollService payrollService;

    @Autowired
    private ObjectMapper objectMapper;

    EmployeeDTO sampleEmployee = new EmployeeDTO("Alice", "alice@example.com", 1L, 1L, 60000L);

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Disabled
    @Test
    @Timeout(value = 2,unit = TimeUnit.MILLISECONDS)
    void dummyMockMvc() {

    }







    @Test
    void shouldReturnEmployeeById() throws Exception {
        when(employeeService.getById(1L)).thenReturn(sampleEmployee);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("alice@example.com"));
    }

    @Test
    void shouldAddEmployee() throws Exception {
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleEmployee)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateEmployee() throws Exception {
        mockMvc.perform(put("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleEmployee)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGeneratePayroll() throws Exception {
        when(payrollService.processPayroll()).thenReturn(List.of(sampleEmployee));

        mockMvc.perform(get("/api/employees/payroll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void shouldReturnGroupedByDepartment() throws Exception {
        Map<String, List<EmployeeDTO>> grouped = new HashMap<>();
        grouped.put("IT", List.of(sampleEmployee));
        when(employeeService.getEmployeesGroupedByDepartment()).thenReturn(grouped);

        mockMvc.perform(get("/api/employees/grouped-by-department"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.IT[0].email").value("alice@example.com"));
    }


    @Test
    void shouldReturnPayrollSumByJobTitle() throws Exception {
        when(employeeService.calculatePayrollByJobTitle("Developer")).thenReturn(60000);

        mockMvc.perform(get("/api/employees/payroll/job-title/Developer"))
                .andExpect(status().isOk())
                .andExpect(content().string("60000"));
    }

}
