package com.hospital.patientsv2.domain.repository;

import com.hospital.patientsv2.domain.PatientDto;

import java.util.List;
import java.util.Optional;

public interface PatientDtoRepository {

    List<PatientDto> getAll();
    Optional<List<PatientDto>> getByHospitalId(int hospitalId );
    Optional<PatientDto>getByPatientId(int patientId);
    PatientDto save(PatientDto patientDto);
    void delete (int patientId);
    PatientDto update (PatientDto patientDto, int patientId);


}

