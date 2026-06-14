package com.ajay.airline.airline_reservation_system.repository;

import com.ajay.airline.airline_reservation_system.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findBySourceAndDestination(String source,String destination);


}
