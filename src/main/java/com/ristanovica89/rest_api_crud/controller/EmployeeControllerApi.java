package com.ristanovica89.rest_api_crud.controller;

import com.ristanovica89.rest_api_crud.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllerApi {

    Employee employee;

    @GetMapping("{employeeId}")
    public Employee getEmployeeDetails(Integer employeeId){
        return employee;
    }
}
