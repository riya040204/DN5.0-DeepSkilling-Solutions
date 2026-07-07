package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    // URL: http://localhost:8080/employees
    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.debug("EmployeeController.getAllEmployees() called");
        return employeeService.getAllEmployees();
    }

    // GET employee by ID
    // URL: http://localhost:8080/employees/1
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        LOGGER.debug("EmployeeController.getEmployeeById() called for id: {}", id);
        return employeeService.getEmployeeById(id);
    }
}
