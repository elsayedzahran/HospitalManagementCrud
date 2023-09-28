package com.example.springexcercise.rest;

import com.example.springexcercise.entity.Patient;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.model.PatientModel;
import com.example.springexcercise.model.PatientToPrintModel;
import com.example.springexcercise.service.services.HospitalService;
import com.example.springexcercise.service.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping()
    public List<PatientToPrintModel> getAll(){
        return patientService.getAllPatients();
    }
    @GetMapping("{id}")
    public PatientToPrintModel getPatientById(@PathVariable int id){
        return patientService.getPatientById(id);
    }

    @PostMapping()
    public PatientToPrintModel addPatient(@RequestBody PatientModel patientModel){
        return patientService.addPatient(patientModel);
    }
    @PutMapping("{id}")
    public PatientToPrintModel updatePatient(@PathVariable int id, @RequestBody PatientModel patientModel){
        return patientService.updatePatient(id, patientModel);
    }
    @DeleteMapping("{id}")
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }
}
