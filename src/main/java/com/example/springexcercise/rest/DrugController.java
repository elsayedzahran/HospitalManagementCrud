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
    public List<Drug> getAll(){
        return drugService.getAllDrugs();
    }
    @GetMapping("{id}")
    public Drug getDrugById(@PathVariable int id){
        return drugService.getDrugById(id);
    }

    @PostMapping()
    public Drug addDrug(@RequestBody DrugModel drugModel){
        return drugService.addDrug(drugModel);
    }
    @PutMapping("{id}")
    public Drug updateDrug(@PathVariable int id,@RequestBody DrugModel drugModel){
        return drugService.updateDrug(id, drugModel);
    }
    @DeleteMapping("{id}")
    public void deleteDrug(@PathVariable int id){
        drugService.deleteDrug(id);
    }
}
