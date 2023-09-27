package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "hospitalId", target = "hospital.id")
    Doctor toEntity(DoctorModel doctorModel);
    @InheritInverseConfiguration(name = "toEntity")
    DoctorModel toModel(Doctor doctor);
}
