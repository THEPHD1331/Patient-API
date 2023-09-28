package com.SpringBootProject.controller;

import com.SpringBootProject.entity.Employee;
import com.SpringBootProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpRestController {

  EmployeeService employeeService;

    @Autowired
    public EmpRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees") // Get All the employees
    public List<Employee> findAllEmp(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}") // Get single employee by Id
    public Employee getEmployee(@PathVariable int employeeId){

        Employee empx= employeeService.findById(employeeId);

        if(empx==null){
            throw new RuntimeException("Employee Id not Found - "+employeeId);
        }
        return empx;
    }

    @PostMapping("/employees")  // Post request to add a new employee
    public Employee addEmployee(@RequestBody Employee employeeNew){

        employeeNew.setId(0);
        return employeeService.save(employeeNew);
    }

    @PutMapping("/employees") // Put request to update (overwrite) an employee
    public Employee updateEmp(@RequestBody Employee yoEmp){
        return employeeService.save(yoEmp);
    }

    @DeleteMapping("employees/{empId}") // Delete request to delete an employee by Id
    public String deleteEmp(@PathVariable int empId){

        Employee temp= employeeService.findById(empId);
        if(temp==null) {
            throw new RuntimeException("Employee Id not found - " + empId);
        }
        employeeService.deleteById(empId);

        return "Deleted Employee Id: "+empId;
    }
}
