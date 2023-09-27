package com.example.springexcercise.service.servicesimpl;


import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.repository.DoctorRepo;
import com.example.springexcercise.service.mappers.DoctorMapper;
import com.example.springexcercise.service.services.DoctorService;
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
    public List<DoctorModel> getAllDoctors() {
        return doctorRepo.findAll()
                .stream().map(doctor -> doctorMapper.toModel(doctor))
                .collect(Collectors.toList());
    }
    @Override
    public DoctorModel getDoctorById(int id) {
        return doctorMapper.toModel(doctorRepo.findById(id).orElseThrow());
    }

    @Override
    public DoctorModel addDoctor(DoctorModel doctorModel) {
        Doctor doctor = doctorMapper.toEntity(doctorModel);
        doctorRepo.save(doctor);
        return doctorModel;
    }
    @Override
    public DoctorModel updateDoctor(int id, DoctorModel doctorModel) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow();
        doctorRepo.save(doctor);
        return doctorModel;
    }
    @Override
    public void deleteDoctor(int id) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow();
        doctorRepo.delete(doctor);
    }
}
