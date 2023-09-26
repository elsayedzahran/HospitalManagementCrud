package com.example.springexcercise.service.servicesimpl;


import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.DrugModel;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.repository.DrugRepo;
import com.example.springexcercise.repository.HospitalRepo;
import com.example.springexcercise.service.mappers.DoctorMapper;
import com.example.springexcercise.service.mappers.DrugMapper;
import com.example.springexcercise.service.mappers.HospitalMapper;
import com.example.springexcercise.service.services.DrugService;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugMapper drugMapper;
    @Autowired
    DrugRepo drugRepo;
    @Override
    public List<Drug> getAllDrugs() {
        return drugRepo.findAll();
    }

    @Override
    public Drug getDrugById(int id) {
        return drugRepo.findById(id).orElseThrow();
    }

    @Override
    public Drug addDrug(DrugModel drugModel) {
        Drug drug = drugMapper.toEntity(drugModel);
        drugRepo.save(drug);
        return drug;
    }

    @Override
    public Drug updateDrug(int id, DrugModel drugModel) {
        Drug drug = drugRepo.findById(id).orElseThrow();
        drug.setName(drugModel.getName());
        drug.setDescription(drugModel.getDescription());
        drugRepo.save(drug);
        return drug;
    }

    @Override
    public void deleteDrug(int id) {
        Drug drug = drugRepo.findById(id).orElseThrow();
        drugRepo.delete(drug);
    }
}
