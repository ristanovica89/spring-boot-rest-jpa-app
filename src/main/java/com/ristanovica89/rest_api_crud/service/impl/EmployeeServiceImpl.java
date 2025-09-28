package com.ristanovica89.rest_api_crud.service.impl;

import com.ristanovica89.rest_api_crud.model.Employee;
import com.ristanovica89.rest_api_crud.repository.EmployeeRepository;
import com.ristanovica89.rest_api_crud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee successfully created.";
    }

    @Override
    public String updateEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getEmployeeId())){
            return "Employee with ID " + employee.getEmployeeId() + " does not exist.";
        }
        employeeRepository.save(employee);
        return "Employee successfully updated.";
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee (ID : " + employeeId + " is successfully deleted.";
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()->
                new RuntimeException("Employee ID: " + employeeId + " not found."));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
