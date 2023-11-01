package com.SpringBootProject.service;

import com.SpringBootProject.entity.Patient;

import java.util.List;

public interface PatientService {

     List<Patient> findAll();
    Patient findById(long contactNo);
    Patient save(Patient patient);

    void deleteById(long contactNo);
}
