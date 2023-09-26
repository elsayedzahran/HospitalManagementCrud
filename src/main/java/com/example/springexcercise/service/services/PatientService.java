package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.PatientModel;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(int id);
    Patient addPatient(PatientModel patientModel);
    Patient updatePatient(int id, PatientModel patientModel);
    // Patient updatePatient2(PatientModel patientModel);
    void deletePatient(int id);
}
