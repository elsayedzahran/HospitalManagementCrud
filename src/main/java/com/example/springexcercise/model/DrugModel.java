package com.example.springexcercise.model;

import com.example.springexcercise.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugModel {
    private String name;
    private String description;
    @JsonIgnoreProperties({"drugs"})
    private Set<Patient> patients;
}
