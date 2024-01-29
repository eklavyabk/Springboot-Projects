package com.springboot.thymeleaf.crud.service;

import com.springboot.thymeleaf.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theid);
}
