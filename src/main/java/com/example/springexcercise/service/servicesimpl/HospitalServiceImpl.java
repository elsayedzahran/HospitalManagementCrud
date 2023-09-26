package com.example.springexcercise.service.servicesimpl;


import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalMapper hospitalMapper;
    @Autowired
    HospitalRepo hospitalRepo;

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.findAll();
    }

    @Override
    public Hospital getHospitalById(int id) {
        return hospitalRepo.findById(id).orElseThrow();
    }

    @Override
    public Hospital addHospital(HospitalModel hospitalModel) {
        Hospital hospital = hospitalMapper.toEntity(hospitalModel);
        hospitalRepo.save(hospital);
        return hospital;
    }
    @Override
    public Hospital updateHospital(int hospitalId, HospitalModel hospitalModel) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow();
        hospital.setName(hospitalModel.getName());
        hospital.setAddress(hospitalModel.getAddress());
        hospitalRepo.save(hospital);
        return hospital;
    }

    @Override
    public void deleteHospital(int id) {
        Hospital hospital = hospitalRepo.findById(id).orElseThrow();
        hospitalRepo.delete(hospital);
    }
}
