package com.example.springexcercise.model;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientToPrintModel {
    private String name;
    private String gender;
    private Hospital hospital;
    private Doctor doctor;
    private List<Drug> drugs;
}
