package com.ajay.airline.airline_reservation_system.service;

import com.ajay.airline.airline_reservation_system.entity.Flight;
import com.ajay.airline.airline_reservation_system.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }
    public List<Flight> searchFlights(String source,String destination){
        return flightRepository.findBySourceAndDestination(source,destination);
    }

}
