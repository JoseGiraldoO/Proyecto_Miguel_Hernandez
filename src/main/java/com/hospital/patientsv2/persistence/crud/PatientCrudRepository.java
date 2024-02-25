package com.hospital.patientsv2.persistence.crud;

import com.hospital.patientsv2.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientCrudRepository extends CrudRepository<Patient, Integer> {

    Optional<List<Patient>> findByHospitalId(int hospitalId);

}
