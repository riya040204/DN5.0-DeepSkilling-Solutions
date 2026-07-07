package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    // Constructor loads employee list from XML config
    public EmployeeDao() {
        LOGGER.debug("Loading employee list from employee.xml");
        ApplicationContext context =
            new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
        LOGGER.debug("Employee list loaded. Size: {}", EMPLOYEE_LIST.size());
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.debug("getAllEmployees() called. Returning {} employees",
                     EMPLOYEE_LIST.size());
        return EMPLOYEE_LIST;
    }

    public Employee getEmployeeById(int id) {
        LOGGER.debug("getEmployeeById() called for id: {}", id);
        return EMPLOYEE_LIST.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
