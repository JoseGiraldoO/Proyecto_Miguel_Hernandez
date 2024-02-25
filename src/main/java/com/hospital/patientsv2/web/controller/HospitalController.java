package com.hospital.patientsv2.web.controller;


import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.domain.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {


    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/all")
    public ResponseEntity<List<HospitalDto>> getAll(){
        return new ResponseEntity<>(hospitalService.getAll1(), HttpStatus.OK);
    }

    @GetMapping("{hospitalId}")
    public ResponseEntity<HospitalDto> getById(@PathVariable int hospitalId){
        return hospitalService.getById(hospitalId)
                .map(hospitalDto -> new ResponseEntity<>(hospitalDto, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}