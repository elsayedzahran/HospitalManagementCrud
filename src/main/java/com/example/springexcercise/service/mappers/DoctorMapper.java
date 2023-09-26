package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorModel doctorModel);
    DoctorModel toModel(Doctor doctor);
}
