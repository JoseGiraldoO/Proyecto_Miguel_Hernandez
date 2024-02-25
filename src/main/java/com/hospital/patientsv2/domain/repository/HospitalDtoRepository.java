package com.hospital.patientsv2.domain.repository;

import com.hospital.patientsv2.domain.HospitalDto;

import java.util.List;
import java.util.Optional;

public interface HospitalDtoRepository {

    List<HospitalDto> getAll1();
    Optional<HospitalDto> getById(int hospitalId);
}
