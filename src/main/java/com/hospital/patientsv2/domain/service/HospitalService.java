package com.hospital.patientsv2.domain.service;

import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.domain.repository.HospitalDtoRepository;
import com.hospital.patientsv2.persistence.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalDtoRepository hospitalDtoRepository;
    public List<HospitalDto> getAll1() {

        return hospitalDtoRepository.getAll1();
    }

    public Optional<HospitalDto> getById(int hospitalId) {
        return hospitalDtoRepository.getById(hospitalId);
    }

}