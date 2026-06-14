package com.ajay.airline.airline_reservation_system.service;

import com.ajay.airline.airline_reservation_system.dto.LoginRequest;
import com.ajay.airline.airline_reservation_system.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public String login(LoginRequest request){

        System.out.println("LOGIN TRY = " + request.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return jwtService.generateToken(request.getEmail());
    }

}