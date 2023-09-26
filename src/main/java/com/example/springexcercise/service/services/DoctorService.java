package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;

import java.awt.*;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    Doctor addDoctor(DoctorModel doctorModel);
    Doctor updateDoctor(int id, DoctorModel doctorModel);
    void deleteDoctor(int id);
}
