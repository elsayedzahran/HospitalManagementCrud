package com.example.springexcercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "HospitalID", referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "DoctorID", referencedColumnName = "id")
    @JsonIgnore
    private Doctor doctor;

    @ManyToMany
    @JoinTable(name = "DrugPatient",
            joinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "id"))
    @JsonIgnore
    private List<Drug> drugs;
}
