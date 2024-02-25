package com.hospital.patientsv2.persistence;


import com.hospital.patientsv2.domain.PatientDto;
import com.hospital.patientsv2.domain.repository.PatientDtoRepository;
import com.hospital.patientsv2.persistence.crud.PatientCrudRepository;
import com.hospital.patientsv2.persistence.entity.Patient;
import com.hospital.patientsv2.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository implements PatientDtoRepository {
    @Autowired
    private PatientCrudRepository patientCrudRepository;
    @Autowired
    private PatientMapper patientMapper;
    @Override
    public List<PatientDto> getAll() {
        List<Patient> patients = (List<Patient>) patientCrudRepository.findAll();
        return patientMapper.toPatientDto(patients);
    }
    @Override
    public Optional<List<PatientDto>> getByHospitalId(int hospitalId) {
        Optional<List<Patient>> patients = patientCrudRepository.findByHospitalId(hospitalId);
        return patients.map(patients1 -> patientMapper.toPatientDto(patients1));
    }
    @Override
    public Optional<PatientDto> getByPatientId(int patientId) {

        return patientCrudRepository.findById(patientId).map(patient -> patientMapper.toPatientDto(patient));
    }
    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = (Patient) patientMapper.toPatient(patientDto);
        return patientMapper.toPatientDto(patientCrudRepository.save(patient));
    }
    @Override
    public void delete(int patientId) {
        patientCrudRepository.deleteById(patientId);
    }
    @Override
    public PatientDto update(PatientDto patientDto,int patientId) {

        return patientCrudRepository.findById(patientId).map(patient -> {

            patientDto.setFirstNameDto(patientDto.getFirstNameDto());
            patientDto.setLastNameDto(patientDto.getLastNameDto());
            patientDto.setAdressDto(patientDto.getAdressDto());
            patientDto.setHospitalIdDto(patientDto.getHospitalIdDto());
            patientDto.setCityDto(patientDto.getCityDto());
            patient = patientMapper.toPatient(patientDto);
            return patientMapper.toPatientDto(patientCrudRepository.save(patient));
        }).get();
    }
}
