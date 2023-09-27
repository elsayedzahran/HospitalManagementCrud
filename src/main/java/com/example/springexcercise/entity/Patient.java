package com.example.springexcercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "DoctorID", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "drugpatient",
            joinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "id"))
    @JsonIgnoreProperties({"patients"})
    @JsonManagedReference
    private Set<Drug> drugs;
}
