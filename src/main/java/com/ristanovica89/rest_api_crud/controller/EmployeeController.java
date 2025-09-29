package com.ristanovica89.rest_api_crud.controller;

import com.ristanovica89.rest_api_crud.model.Employee;
import com.ristanovica89.rest_api_crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployeesDetails(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployeeDetails(@PathVariable("employeeId") Integer employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping()
    public String createNewEmployeeDetails(@RequestBody Employee employee){
        employeeService.createEmployee(employee);

        return "New employee successfully created.";
    }

    @PutMapping()
    public String updateEmployeeDetails(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);

        return "Employee successfully updated.";
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployeeDetails(@PathVariable("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);

        return "Employee successfully deleted.";
    }

}
