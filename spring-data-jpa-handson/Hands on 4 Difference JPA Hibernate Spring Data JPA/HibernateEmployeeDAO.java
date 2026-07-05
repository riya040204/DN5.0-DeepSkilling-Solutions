package com.cognizant.ormlearn.hibernate;

import com.cognizant.ormlearn.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * HIBERNATE APPROACH
 * Shows how much boilerplate code is needed
 * Manual session and transaction management required
 */
public class HibernateEmployeeDAO {

    private SessionFactory factory;

    // CREATE - Add employee
    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    // READ - Get employee by ID
    public Employee getEmployee(Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Employee employee = null;

        try {
            tx = session.beginTransaction();
            employee = session.get(Employee.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    // UPDATE - Update employee salary
    public void updateEmployee(Integer id, Double salary) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // DELETE - Delete employee
    public void deleteEmployee(Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
