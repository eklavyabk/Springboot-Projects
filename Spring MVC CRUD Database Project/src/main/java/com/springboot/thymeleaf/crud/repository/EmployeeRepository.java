package com.springboot.thymeleaf.crud.repository;

import com.springboot.thymeleaf.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
