package com.ristanovica89.rest_api_crud.repository;

import com.ristanovica89.rest_api_crud.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();
        employee = new Employee();
        employee.setName("Name");
        employee.setEmail("email");
        employee.setPhoneNumber("xxx-xxxx-xxx");
        employee = employeeRepository.save(employee);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
        employee = null;
    }

    // Test case SUCCESS
    @Test
    public void findByEmployeeName_found() {
        List<Employee> employeeList = employeeRepository.findByName("Name");

        assertThat(employeeList.get(0).getEmployeeId()).isEqualTo(employee.getEmployeeId());
        assertThat(employeeList.get(0).getPhoneNumber()).isEqualTo(employee.getPhoneNumber());
    }

    // Test case FAILURE
    @Test
    public void findByEmployeeName_notFound() {
        List<Employee> employeeList = employeeRepository.findByName("emaN");

        assertThat(employeeList.isEmpty()).isTrue();

    }
}
