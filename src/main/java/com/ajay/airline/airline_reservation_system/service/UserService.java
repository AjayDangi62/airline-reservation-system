package com.ajay.airline.airline_reservation_system.service;

import com.ajay.airline.airline_reservation_system.entity.User;
import com.ajay.airline.airline_reservation_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){

        User existingUser =
                userRepository.findByEmail(user.getEmail());

        if(existingUser != null){
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        // Default role USER
        if(user.getRole() == null ||
                user.getRole().isBlank()) {

            user.setRole("USER");
        }

        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}