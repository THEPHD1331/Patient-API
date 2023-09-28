package com.SpringBootProject.service;

import com.SpringBootProject.dao.EmployeeRepository;
import com.SpringBootProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository empRepo){
        employeeRepo=empRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);
        Employee theEmp=null;

        if(result.isPresent()){
            theEmp=result.get();
        }
        else{
            throw new RuntimeException("Did not find the Employee ID: "+ id);
        }

        return theEmp;
    }

    @Override
    public Employee save(Employee theEmp) {
        return employeeRepo.save(theEmp);
    }

    @Override
    public void deleteById(int id) {
    employeeRepo.deleteById(id);
    }
}
