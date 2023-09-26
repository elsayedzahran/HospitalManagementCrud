package com.example.springexcercise.model;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientModel {
    private int id;
    private String name;
    private String gender;
    private int HospitalID;
    private Hospital hospital;
    private int DoctorID;
    private Doctor doctor;
    private List<Drug> drugs;
}
