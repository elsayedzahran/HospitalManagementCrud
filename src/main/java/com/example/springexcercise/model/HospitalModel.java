package com.example.springexcercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalModel {
    private String name;
    private String address;
}
