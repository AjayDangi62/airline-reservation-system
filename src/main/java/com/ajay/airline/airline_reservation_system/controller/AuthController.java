package com.ajay.airline.airline_reservation_system.controller;

import com.ajay.airline.airline_reservation_system.dto.LoginRequest;
import com.ajay.airline.airline_reservation_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request){

        return authService.login(request);
    }
}