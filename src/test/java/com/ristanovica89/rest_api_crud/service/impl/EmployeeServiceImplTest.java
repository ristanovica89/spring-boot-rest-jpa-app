package com.ristanovica89.rest_api_crud.service.impl;

import com.ristanovica89.rest_api_crud.model.Employee;
import com.ristanovica89.rest_api_crud.repository.EmployeeRepository;
import com.ristanovica89.rest_api_crud.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee();
        employee.setName("Name");
        employee.setEmail("email");
        employee.setPhoneNumber("xxx-xxxx-xxx");
    }

    @AfterEach
    void tearDown() {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testCreateEmployee() {
        mock(EmployeeRepository.class);
        mock(Employee.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.createEmployee(employee)).isEqualTo("Employee successfully created.");
    }

    @Test
    void testUpdateEmployee() {
        mock(EmployeeRepository.class);
        mock(Employee.class);

        employee.setEmployeeId(1);

        when(employeeRepository.existsById(1)).thenReturn(true);
        when(employeeRepository.save(employee)).thenReturn(employee);

        assertThat(employeeService.updateEmployee(employee)).isEqualTo("Employee successfully updated.");
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);

        when(employeeRepository.existsById(1)).thenReturn(true);
        doNothing().when(employeeRepository).deleteById(1);

         assertThat(employeeService.deleteEmployee(1)).isEqualTo("Employee ID : " + employee.getEmployeeId() + " is successfully deleted.");
    }

    @Test
    void testGetEmployee() {
        mock(EmployeeRepository.class);
        mock(Employee.class);

        when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(employee));
        assertThat(employeeService.getEmployee(1).getName()).isEqualTo(employee.getName());
    }

    @Test
    void testGetAllEmployees() {
        mock(EmployeeRepository.class);
        mock(Employee.class);

        when(employeeRepository.findAll()).thenReturn(new ArrayList<>(Collections.singleton(employee)));
        assertThat(employeeService.getAllEmployees().get(0).getName()).isEqualTo(employee.getName());
    }
}