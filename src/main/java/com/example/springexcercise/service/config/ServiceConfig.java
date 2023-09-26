package com.example.springexcercise.service.config;

import com.example.springexcercise.service.mappers.DoctorMapper;
import com.example.springexcercise.service.mappers.DrugMapper;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.mappers.PatientMapper;
import com.example.springexcercise.service.services.DoctorService;
import com.example.springexcercise.service.services.DrugService;
import com.example.springexcercise.service.services.HospitalService;
import com.example.springexcercise.service.services.PatientService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses =
        {DoctorMapper.class, DrugMapper.class, HospitalMapper.class, PatientMapper.class,
        DoctorService.class, DrugService.class, HospitalService.class, PatientService.class})
public class ServiceConfig {
}
