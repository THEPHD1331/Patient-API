package com.SpringBootProject.service;

import com.SpringBootProject.dao.PatientRepository;
import com.SpringBootProject.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepo;

    @Autowired
    public PatientServiceImpl(PatientRepository empRepo){
        patientRepo=empRepo;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Override
    public Patient findById(long contactNo) {
        Optional<Patient> result = patientRepo.findById(contactNo);
        Patient theEmp=null;

        if(result.isPresent()){
            theEmp=result.get();
        }
        else{
            throw new RuntimeException("Did not find the Patient ID: "+ contactNo);
        }

        return theEmp;
    }

    @Override
    public Patient save(Patient theEmp) {
        return patientRepo.save(theEmp);
    }

    @Override
    public void deleteById(long contactNo) {
    patientRepo.deleteById(contactNo);
    }
}
