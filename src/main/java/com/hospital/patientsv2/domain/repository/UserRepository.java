package com.hospital.patientsv2.domain.repository;

import com.hospital.patientsv2.persistence.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User save(User user);
}
