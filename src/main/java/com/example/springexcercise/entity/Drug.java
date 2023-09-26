package com.example.springexcercise.entity;

import com.example.springexcercise.model.PatientModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Drug")
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @ManyToMany
    @JoinTable(name = "DrugPatient",
            joinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "ID"))
    @JsonIgnore
    private List<Patient> patients;
}
