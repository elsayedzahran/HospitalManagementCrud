package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper {
    Hospital toEntity(HospitalModel hospitalModel);
    HospitalModel toModel(Hospital hospital);
}
