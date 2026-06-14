package com.ajay.airline.airline_reservation_system.repository;

import com.ajay.airline.airline_reservation_system.entity.User;
import com.ajay.airline.airline_reservation_system.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
