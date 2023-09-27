package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.model.DoctorModel;
import java.util.List;

public interface DoctorService {
    List<DoctorModel> getAllDoctors();
    DoctorModel getDoctorById(int id);
    DoctorModel addDoctor(DoctorModel doctorModel);
    DoctorModel updateDoctor(int id, DoctorModel doctorModel);
    void deleteDoctor(int id);
}
