package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.DrugModel;

import java.util.List;

public interface DrugService {
    List<Drug> getAllDrugs();
    Drug getDrugById(int id);
    Drug addDrug(DrugModel drugModel);
    Drug updateDrug(int id,DrugModel drugModel);
    void deleteDrug(int id);
}
