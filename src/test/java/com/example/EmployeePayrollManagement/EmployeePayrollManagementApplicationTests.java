package com.example.EmployeePayrollManagement;

import com.epam.service.DTOToEntity;
import com.epam.service.EmployeeService;
import com.epam.service.EntityToDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import com.epam.DTO.EmployeeDTO;
import com.epam.Models.Department;
import com.epam.Models.Employee;
import com.epam.Models.JobTitle;
import com.epam.RepositoryLayer.EmployeeRepository;
import com.epam.Utility.EntityNotFoundException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeePayrollManagementApplicationTests {
	@Mock
	EmployeeRepository employeeRepository;

	@Mock
	DTOToEntity dtoToEntity;

	@Mock
	EntityToDTO entityToDTO;

	@InjectMocks
	EmployeeService employeeService;

	Employee employee;
	EmployeeDTO employeeDTO;

	Department itDept;
	Department hrDept;
	JobTitle developer;

	@BeforeEach
	void setUp() {
		Department department = new Department("IT", "John", 1L, 5L, 10.0);
		JobTitle jobTitle = new JobTitle("Developer", 1L, 50000L, 100000L);
		itDept = new Department("IT", "John", 1L, 5L, 10.0);
		hrDept = new Department("HR", "Jane", 2L, 3L, 5.0);
		developer = new JobTitle("Developer", 1L, 50000L, 100000L);
		employee = new Employee("Alice", "alice@example.com", itDept, developer, 1L,
				Date.from(LocalDate.now().minusMonths(2).atStartOfDay(ZoneId.systemDefault()).toInstant()), 60000L);
		employeeDTO = new EmployeeDTO("Alice", "alice@example.com", 1L, 1L, 60000L);
	}
 // act assert verfy
	@Test
	@DisplayName("Check for employee addition")
	void shouldAddEmployeeSuccessfully() {
		when(dtoToEntity.toEmployee(employeeDTO)).thenReturn(employee);

		employeeService.add(employeeDTO);

		verify(employeeRepository, times(1)).save(employee);
	}

	@Nested
	class B{

	}

	@Disabled
	@Test
	@Timeout(value = 2,unit = TimeUnit.MILLISECONDS)
	void dummyAsserts(){
		int result=100;
		boolean check=false;
		assertEquals(100,result);
		assertTrue(()->check);
		assertTrue(check);
		assertFalse(check);
		Object obj=new Object();
		assertNotNull(obj);
		assertNull(obj);
		assertThrows(RuntimeException.class,()-> {throw new RuntimeException();});


	}


	@Test
	void shouldGetEmployeeById() {
		when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
		when(entityToDTO.toEmployeeDTO(employee)).thenReturn(employeeDTO);

		EmployeeDTO result = employeeService.getById(1L);

		assertEquals(employeeDTO.getEmail(), result.getEmail());
		verify(employeeRepository).findById(1L);
	}

	@Test
	void shouldThrowExceptionIfEmployeeNotFound() {
		when(employeeRepository.findById(99L)).thenReturn(Optional.empty());

		assertThrows(EntityNotFoundException.class, () -> employeeService.getById(99L));
	}

	@Test
	void shouldDeleteEmployeeById() {
		employeeService.removeById(1L);
		verify(employeeRepository).deleteById(1L);
	}

	@Test
	void shouldEditEmployeeById() {
		doNothing().when(employeeRepository).deleteById(1L);

		employeeService.removeById(1L);

		verify(employeeRepository, times(1)).deleteById(1L);
	}

	@Test
	void shouldFilterEmployeesByDepartmentName() {
		Employee emp2 = new Employee("Bob", "bob@example.com", hrDept, developer, 2L,
				new Date(), 70000L);
		when(employeeRepository.findAll()).thenReturn(List.of(employee, emp2));
		List<Employee> filtered = ( employeeRepository.findAll()).stream()
				.filter(emp -> emp.getDepartment().getName().equals("IT")).collect(Collectors.toList());
		assertEquals(1, filtered.size());
		assertEquals("Alice", filtered.get(0).getName());
	}

	@Test
	void shouldReturnEmptyListWhenDepartmentDoesNotExist() {
		Employee emp2 = new Employee("Bob", "bob@example.com", hrDept, developer, 2L,
				new Date(), 70000L);
		when(employeeRepository.findAll()).thenReturn(List.of(emp2));
		List<Employee> filtered = (employeeRepository.findAll()).stream()
				.filter(emp -> emp.getDepartment().getName().equals("NonExistent")).collect(Collectors.toList());
		assertTrue(filtered.isEmpty());
	}

	@Test
	void shouldReturnEmptyListWhenNoEmployeesPresent() {
		when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
		List<Employee> filtered = ( employeeRepository.findAll()).stream()
				.filter(emp -> emp.getDepartment().getName().equals("IT")).collect(Collectors.toList());
		assertTrue(filtered.isEmpty());
	}

}
