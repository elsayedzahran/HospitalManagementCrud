package com.example.springexcercise.model;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorModel {
    private int id;
    private String name;
    private Hospital hospital;
    private int HospitalID;
    private List<Patient> patients;
}