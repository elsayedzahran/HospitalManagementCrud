package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.model.PatientToPrintModel;

import java.util.List;

public interface PatientService {
    List<PatientToPrintModel> getAllPatients();
    PatientToPrintModel getPatientById(int id);
    PatientToPrintModel addPatient(PatientModel patientModel);
    PatientToPrintModel updatePatient(int id, PatientModel patientModel);
    void deletePatient(int id);
}
