package com.hospital.patientsv2.web.controller;

import com.hospital.patientsv2.domain.repository.UserRepository;
import com.hospital.patientsv2.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> list(){

        return userRepository.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<User> save( @RequestBody User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }


}