package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.debug("EmployeeService.getAllEmployees() called");
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public Employee getEmployeeById(int id) {
        LOGGER.debug("EmployeeService.getEmployeeById() called for id: {}", id);
        return employeeDao.getEmployeeById(id);
    }
}
