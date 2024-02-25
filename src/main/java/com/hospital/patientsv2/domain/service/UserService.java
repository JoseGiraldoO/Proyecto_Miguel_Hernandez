package com.hospital.patientsv2.domain.service;


import com.hospital.patientsv2.domain.repository.UserRepository;
import com.hospital.patientsv2.persistence.crud.RoleCrudRepository;
import com.hospital.patientsv2.persistence.crud.UserCrudRepository;
import com.hospital.patientsv2.persistence.entity.Role;
import com.hospital.patientsv2.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private RoleCrudRepository roleCrudRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        return (List<User>) userCrudRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

        Optional<Role> optionalRoleUser = roleCrudRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        optionalRoleUser.ifPresent(role -> roles.add(role));
        if(user.isAdmin()){

            Optional<Role> optionalRoleAdmin = roleCrudRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(role -> roles.add(role));
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userCrudRepository.save(user);
    }
}