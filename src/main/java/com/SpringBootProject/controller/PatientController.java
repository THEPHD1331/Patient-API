package com.SpringBootProject.controller;

import com.SpringBootProject.entity.Patient;
import com.SpringBootProject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

  PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients") // Get All the employees
    public List<Patient> findAllEmp(){
        return patientService.findAll();
    }

    @GetMapping("/patients/{contactNo}") // Get single employee by Id
    public Patient getEmployee(@PathVariable long contactNo){

        Patient empx= patientService.findById(contactNo);

        if(empx==null){
            throw new RuntimeException("Patient Id not Found - "+contactNo);
        }
        return empx;
    }

    @PostMapping("/patients")  // Post request to add a new employee
    public Patient addEmployee(@RequestBody Patient employeeNew){

        return patientService.save(employeeNew);
    }

    @PutMapping("/patients") // Put request to update  an employee
    public Patient updateEmp(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @DeleteMapping("patients/{contactNo}") // Delete request to delete an employee by Id
    public String deleteEmp(@PathVariable long contactNo){

        Patient temp= patientService.findById(contactNo);
        if(temp==null) {
            throw new RuntimeException("Patient Id not found - " + contactNo);
        }
        patientService.deleteById(contactNo);

        return "Deleted Patient Id: "+contactNo;
    }
}
