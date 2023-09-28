package com.example.springexcercise.rest;

import com.example.springexcercise.entity.Drug;
import com.example.springexcercise.model.DrugModel;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.service.services.DrugService;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drugs")
public class DrugController {
    @Autowired
    DrugService drugService;

    @GetMapping()
    public List<DrugModel> getAll(){
        return drugService.getAllDrugs();
    }
    @GetMapping("{id}")
    public DrugModel getDrugById(@PathVariable int id){
        return drugService.getDrugById(id);
    }

    @PostMapping()
    public DrugModel addDrug(@RequestBody DrugModel drugModel){
        return drugService.addDrug(drugModel);
    }
    @PutMapping("{id}")
    public DrugModel updateDrug(@PathVariable int id,@RequestBody DrugModel drugModel){
        return drugService.updateDrug(id, drugModel);
    }
    @DeleteMapping("{id}")
    public void deleteDrug(@PathVariable int id){
        drugService.deleteDrug(id);
    }
}
