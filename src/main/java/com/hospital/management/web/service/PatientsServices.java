package com.hospital.management.web.service;

import com.hospital.management.web.model.Patient;

import java.util.List;

public interface PatientsServices {
    //save patients
    public Patient savePatient(Patient patient);
    //update
    public Patient updatePatient(Patient patient, Long id);
    //delete
    public void  deletePatient(Long id);
    //listAll
    public List<Patient> listAll();
    //show detail about one by id
    public Patient showById(Long id);

}
