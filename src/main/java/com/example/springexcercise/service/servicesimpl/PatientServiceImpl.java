package com.example.springexcercise.service.servicesimpl;



import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.model.PatientToPrintModel;
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
    public List<PatientToPrintModel> getAllPatients() {
        return patientRepo.findAll()
                .stream()
                .map(patient -> patientMapper.entityToPrintModel(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientToPrintModel getPatientById(int id) {
        return patientMapper.entityToPrintModel(patientRepo.findById(id).orElseThrow());
    }
    @Override
    public PatientToPrintModel addPatient(PatientModel patientModel) {
        Patient patient = patientMapper.toEntity(patientModel);
        patientRepo.save(patient);
        return patientMapper.entityToPrintModel(patient);
    }
    @Override
    public PatientToPrintModel updatePatient(int id, PatientModel patientModel) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        Patient patientUpdate = patientMapper.toEntity(patientModel);

        patient.setName(patientUpdate.getName());
        patient.setGender(patientUpdate.getGender());
        patient.setHospital(patientUpdate.getHospital());
        patient.setDoctor(patientUpdate.getDoctor());

        patientRepo.save(patient);
        return patientMapper.entityToPrintModel(patient);
    }
    @Override
    public void deletePatient(int id) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        patientRepo.delete(patient);
    }
}
