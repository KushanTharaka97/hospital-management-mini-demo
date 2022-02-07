package com.hospital.management.web.service.impl;

import com.hospital.management.web.exception.ResourceNotFoundException;
import com.hospital.management.web.model.Patient;
import com.hospital.management.web.repository.PatientRepository;
import com.hospital.management.web.service.PatientsServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientsServices {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //save
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    //update
    @Override
    public Patient updatePatient(Patient patient, Long id) {
        Patient existingPatients = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patinet", "Id", id));
        existingPatients.setFirstName(patient.getFirstName());
        existingPatients.setLastName(patient.getLastName());
        existingPatients.setDob(patient.getDob());
        patientRepository.save(existingPatients);
        return existingPatients;
    }

    //delete
    @Override
    public void deletePatient(Long id) {
        patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", id));
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> listAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient showById(Long id) {

        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", id));
    }
}
