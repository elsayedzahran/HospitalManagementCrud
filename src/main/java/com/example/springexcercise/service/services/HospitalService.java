package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;

import java.util.List;

public interface HospitalService {
    List<HospitalModel> getAllHospitals();
    HospitalModel getHospitalById(int id);
    HospitalModel addHospital(HospitalModel hospitalModel);
    HospitalModel updateHospital(int hospitalId, HospitalModel hospitalModel);
    void deleteHospital(int id);
}
