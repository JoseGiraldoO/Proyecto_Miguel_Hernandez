package com.hospital.patientsv2.web.controller;

import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.domain.PatientDto;
import com.hospital.patientsv2.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/all")
    public ResponseEntity<List<PatientDto>> getAll(){
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getById(@PathVariable int patientId){
        return patientService.getByPatientId(patientId)
                .map(hospitalDto -> new ResponseEntity<>(hospitalDto, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PatientDto> save(@RequestBody PatientDto patientDto){

        return new ResponseEntity<>(patientService.save(patientDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<PatientDto>delete(@PathVariable int patientId){
        if(patientService.delete(patientId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{patientId}")
    public ResponseEntity<PatientDto>update(@RequestBody PatientDto patientDto,@PathVariable int patientId ){

        return new ResponseEntity<>(patientService.update(patientDto,patientId), HttpStatus.OK);
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<PatientDto>> getByHospitalId(@PathVariable int hospitalId){

        return patientService.getByHospitalId(hospitalId)
                .map(patientDtos -> new ResponseEntity<>(patientDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}