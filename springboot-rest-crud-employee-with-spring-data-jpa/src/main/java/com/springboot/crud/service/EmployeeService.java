package com.springboot.crud.service;

import com.springboot.crud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theid);
}
