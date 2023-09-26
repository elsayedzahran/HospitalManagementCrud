package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(int id);
    Hospital addHospital(HospitalModel hospitalModel);
    Hospital updateHospital(int hospitalId, HospitalModel hospitalModel);
    void deleteHospital(int id);
}
