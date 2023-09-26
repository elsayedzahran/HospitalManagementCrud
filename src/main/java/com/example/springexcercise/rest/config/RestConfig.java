package com.example.springexcercise.rest.config;

import com.example.springexcercise.rest.DoctorController;
import com.example.springexcercise.rest.DrugController;
import com.example.springexcercise.rest.HospitalController;
import com.example.springexcercise.rest.PatientController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {HospitalController.class, DoctorController.class, DrugController.class, PatientController.class})
public class RestConfig {
}
