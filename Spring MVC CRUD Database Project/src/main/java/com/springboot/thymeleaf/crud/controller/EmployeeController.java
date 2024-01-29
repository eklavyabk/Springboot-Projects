package com.springboot.thymeleaf.crud.controller;

import com.springboot.thymeleaf.crud.entity.Employee;
import com.springboot.thymeleaf.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/list")
    public String listEmployee(Model theModel){

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add that to spring model
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

        // send over to our form

        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId){
        // delete the employee
        employeeService.deleteById(theId);
        // redirect to the /employees/list
        return "redirect:/employees/list";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        // save the employee
        employeeService.save(theEmployee);
        return "redirect:/employees/list";


    }

}
