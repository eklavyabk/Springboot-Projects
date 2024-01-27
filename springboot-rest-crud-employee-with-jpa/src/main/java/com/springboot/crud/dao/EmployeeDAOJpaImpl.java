package com.springboot.crud.dao;

import com.springboot.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute query and get a result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // Get the employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // remove employee
        entityManager.remove(theEmployee);

    }
}
