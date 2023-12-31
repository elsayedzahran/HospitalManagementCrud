package com.example.springexcercise.rest;

import com.example.springexcercise.entity.Hospital;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping()
    public List<HospitalModel> getAll(){
        return hospitalService.getAllHospitals();
    }
    @GetMapping("{id}")
    public HospitalModel getHospitalById(@PathVariable int id){
        return hospitalService.getHospitalById(id);
    }

    @PostMapping()
    public HospitalModel addHospital(@RequestBody HospitalModel hospitalModel){
        return hospitalService.addHospital(hospitalModel);
    }
    @PutMapping("{id}")
    public HospitalModel updateHospital(@PathVariable int id,@RequestBody HospitalModel hospitalModel){
        return hospitalService.updateHospital(id, hospitalModel);
    }
    @DeleteMapping("{id}")
    public void deleteHospital(@PathVariable int id){
        hospitalService.deleteHospital(id);
    }
}
