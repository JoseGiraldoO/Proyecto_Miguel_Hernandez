package com.hospital.patientsv2.persistence.crud;

import com.hospital.patientsv2.persistence.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalCrudRepository extends CrudRepository<Hospital, Integer> {
}

