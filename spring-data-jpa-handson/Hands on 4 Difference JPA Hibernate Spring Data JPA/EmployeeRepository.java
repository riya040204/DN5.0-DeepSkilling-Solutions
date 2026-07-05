package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SPRING DATA JPA APPROACH
 * No boilerplate code needed!
 * JpaRepository provides all CRUD operations automatically
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Spring Data JPA auto-generates queries from method names!
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> findByNameContaining(String keyword);
}
