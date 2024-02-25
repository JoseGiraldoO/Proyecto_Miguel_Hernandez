package com.hospital.patientsv2.persistence;


import com.hospital.patientsv2.domain.HospitalDto;
import com.hospital.patientsv2.domain.repository.HospitalDtoRepository;
import com.hospital.patientsv2.persistence.crud.HospitalCrudRepository;
import com.hospital.patientsv2.persistence.entity.Hospital;
import com.hospital.patientsv2.persistence.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HospitalRepository  implements HospitalDtoRepository {

    @Autowired
    private HospitalCrudRepository hospitalCrudRepository;
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public List<HospitalDto> getAll1() {
        List<Hospital> hospitals = (List<Hospital>) hospitalCrudRepository.findAll();
        return hospitalMapper.toHospitalDto(hospitals);
    }

    @Override
    public Optional<HospitalDto> getById(int hospitalId) {
        return hospitalCrudRepository.findById(hospitalId).map(hospital -> hospitalMapper.toHospitalDto(hospital));
    }
}