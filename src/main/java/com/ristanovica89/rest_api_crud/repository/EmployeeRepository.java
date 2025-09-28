package com.ristanovica89.rest_api_crud.repository;

import com.ristanovica89.rest_api_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
