package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SPRING DATA JPA SERVICE
 * Much cleaner than Hibernate approach
 * No session/transaction management needed
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("Employee saved: " + employee.getName());
    }

    // READ ALL
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ BY ID
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // UPDATE
    @Transactional
    public void updateSalary(Integer id, Double salary) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setSalary(salary);
            employeeRepository.save(employee);
            System.out.println("Salary updated for: " + employee.getName());
        }
    }

    // DELETE
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        System.out.println("Employee deleted with id: " + id);
    }

    // FIND BY DEPARTMENT
    @Transactional
    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
