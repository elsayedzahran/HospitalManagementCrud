package com.example.springexcercise.model;

import com.example.springexcercise.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugModel {
    private int id;
    private String name;
    private String description;
    private List<Patient> patients;
}
