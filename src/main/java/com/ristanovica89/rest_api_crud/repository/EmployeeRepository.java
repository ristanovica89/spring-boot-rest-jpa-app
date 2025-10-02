package com.ristanovica89.rest_api_crud.repository;

import com.ristanovica89.rest_api_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);
}
