package com.example.springexcercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Hospital")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Patient> patients;

}