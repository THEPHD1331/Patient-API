package com.SpringBootProject.service;

import com.SpringBootProject.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmp);
    void deleteById(int id);
}
