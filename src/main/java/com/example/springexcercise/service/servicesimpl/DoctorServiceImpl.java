package com.example.springexcercise.service.servicesimpl;


import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.repository.DoctorRepo;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.service.mappers.DoctorMapper;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.services.DoctorService;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DoctorRepo doctorRepo;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public Doctor addDoctor(DoctorModel doctorModel) {
        Doctor doctor = doctorMapper.toEntity(doctorModel);
        doctorRepo.save(doctor);
        return doctor;
    }
    @Override
    public Doctor updateDoctor(int id, DoctorModel doctorModel) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow();
        doctor.setName(doctorModel.getName());
        doctorRepo.save(doctor);
        return doctor;
    }

    @Override
    public void deleteDoctor(int id) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow();
        doctorRepo.delete(doctor);
    }
}
