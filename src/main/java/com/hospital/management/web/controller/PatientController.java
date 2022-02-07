package com.hospital.management.web.controller;

import com.hospital.management.web.service.PatientsServices;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    private PatientsServices patientsServices;

    public PatientController(PatientsServices patientsServices) {
        this.patientsServices = patientsServices;
    }

}
