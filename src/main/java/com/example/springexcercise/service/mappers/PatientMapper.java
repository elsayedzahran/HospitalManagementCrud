package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.model.PatientToPrintModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(source = "hospitalId", target = "hospital.id")
    @Mapping(source = "doctorId", target = "doctor.id")
    Patient toEntity(PatientModel patientModel);
    PatientModel toModel(Patient patient);
    PatientToPrintModel entityToPrintModel(Patient patient);
}
