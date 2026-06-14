package com.ajay.airline.airline_reservation_system.controller;

import com.ajay.airline.airline_reservation_system.entity.Flight;
import com.ajay.airline.airline_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Flight addFlight(@RequestBody Flight flight){
    return flightService.addFlight(flight);
    }
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String source,@RequestParam String destination){
        return flightService.searchFlights(
                source,
                destination
        );
    }
    @GetMapping("/test-role")
    public String testRole(Authentication authentication) {

        return authentication.getAuthorities().toString();
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
