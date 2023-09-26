package com.example.springexcercise.rest;

import com.example.springexcercise.entity.Doctor;
import com.example.springexcercise.model.DoctorModel;
import com.example.springexcercise.model.HospitalModel;
import com.example.springexcercise.service.services.DoctorService;
import com.example.springexcercise.service.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping()
    public List<Doctor> getAll(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("{id}")
    public Doctor getDoctorById(@PathVariable int id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping()
    public Doctor addDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.addDoctor(doctorModel);
    }
    @PutMapping("{id}")
    public Doctor updateDoctor(@PathVariable int id ,@RequestBody DoctorModel doctorModel){
        return doctorService.updateDoctor(id, doctorModel);
    }
    @DeleteMapping("{id}")
    public void deleteDoctor(@PathVariable int id){
        doctorService.deleteDoctor(id);
    }
}
