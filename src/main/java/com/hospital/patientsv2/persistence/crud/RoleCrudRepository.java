package com.hospital.patientsv2.persistence.crud;

import com.hospital.patientsv2.persistence.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleCrudRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
