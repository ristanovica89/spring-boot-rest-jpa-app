package com.ristanovica89.rest_api_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(@org.jetbrains.annotations.NotNull EmployeeNotFoundException employeeNotFoundException){
        EmployeeException employeeException = new EmployeeException(
                employeeNotFoundException.getMessage(),
                employeeNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(employeeException, HttpStatus.NOT_FOUND);
    }
}
