package com.example.springexcercise.service.servicesimpl;



import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.repository.DoctorRepo;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.repository.PatientRepo;
import com.example.springexcercise.service.mappers.PatientMapper;
import com.example.springexcercise.service.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    HospitalRepo hospitalRepo;
    @Autowired
    DoctorRepo doctorRepo;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepo.findById(id).orElseThrow();
    }

    @Override
    public Patient addPatient(PatientModel patientModel) {
        Patient patient =new Patient();
        patient.setName(patientModel.getName());
        patient.setGender(patient.getGender());
        Doctor doctor = doctorRepo.findById(patientModel.getDoctorID()).orElseThrow();
        Hospital hospital = hospitalRepo.findById(patientModel.getHospitalID()).orElseThrow();
        patient.setDoctor(doctor);
        patient.setHospital(hospital);
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(int id, PatientModel patientModel) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        patient.setName(patientModel.getName());
        patient.setGender(patient.getGender());
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(int id) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        patientRepo.delete(patient);
    }
}
