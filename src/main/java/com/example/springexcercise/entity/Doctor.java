package com.example.springexcercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "HospitalID", referencedColumnName = "id")
    private Hospital hospital;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Patient> patients;

}