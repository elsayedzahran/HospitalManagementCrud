package com.example.springexcercise.repository.config;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.repository.DoctorRepo;
import com.example.springexcercise.repository.DrugRepo;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.repository.PatientRepo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {Doctor.class, Drug.class, Hospital.class, Patient.class})
@EnableJpaRepositories(basePackageClasses = {DoctorRepo.class, DrugRepo.class, HospitalRepo.class, PatientRepo.class})
public class RepositoryConfig {
}
