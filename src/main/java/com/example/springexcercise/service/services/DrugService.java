package com.example.springexcercise.service.services;

import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.DrugModel;

import java.util.List;

public interface DrugService {
    List<DrugModel> getAllDrugs();
    DrugModel getDrugById(int id);
    DrugModel addDrug(DrugModel drugModel);
    DrugModel updateDrug(int id,DrugModel drugModel);
    void deleteDrug(int id);
}
