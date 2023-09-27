package com.example.springexcercise.model;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalModel {
    private String name;
    private String address;
}
