package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DrugModel;
import com.example.springexcercise.model.HospitalModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    @InheritInverseConfiguration(name = "toModel")
    Drug toEntity(DrugModel drugModel);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "patients", target = "patients")
    DrugModel toModel(Drug drug);
}
