package com.ristanovica89.rest_api_crud.service;

import com.ristanovica89.rest_api_crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);
    String updateEmployee(Employee employee);
    String deleteEmployee(Integer employeeId);
    Employee getEmployee(Integer employeeId);
    List<Employee> getAllEmployees();
}
