package com.hospital.patientsv2.persistence.crud;


import com.hospital.patientsv2.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User,Long> {
}
