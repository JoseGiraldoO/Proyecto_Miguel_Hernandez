package com.hospital.patientsv2.domain.service;

import com.hospital.patientsv2.domain.PatientDto;
import com.hospital.patientsv2.domain.repository.PatientDtoRepository;
import com.hospital.patientsv2.persistence.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientDtoRepository patientDtoRepository;

    public List<PatientDto> getAll() {

        return patientDtoRepository.getAll();
    }
    public Optional<List<PatientDto>> getByHospitalId(int hospitalId) {

        return patientDtoRepository.getByHospitalId(hospitalId);
    }
    public Optional<PatientDto> getByPatientId(int patientId) {
        return patientDtoRepository.getByPatientId(patientId);
    }

    public PatientDto save(PatientDto patientDto) {
        return patientDtoRepository.save(patientDto);
    }

    public Boolean delete(int patientId) {
        if(getByPatientId(patientId).isPresent()){
            patientDtoRepository.delete(patientId);
            return true;
        }else {
            return false;
        }
    }

    public PatientDto update(PatientDto patientDto,int patientId) {
        return patientDtoRepository.update(patientDto, patientId);
    }

}