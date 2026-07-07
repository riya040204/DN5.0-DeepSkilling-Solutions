package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    // GET all departments
    // URL: http://localhost:8080/departments
    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {
        LOGGER.debug("DepartmentController.getAllDepartments() called");
        return departmentService.getAllDepartments();
    }
}
