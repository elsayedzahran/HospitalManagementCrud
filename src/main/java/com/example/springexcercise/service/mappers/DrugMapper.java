package com.example.springexcercise.service.mappers;

import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DrugModel;
import com.example.springexcercise.model.HospitalModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    Drug toEntity(DrugModel drugModel);
    DrugModel toModel(Drug drug);
}
