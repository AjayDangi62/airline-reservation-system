package com.ajay.airline.airline_reservation_system.service;

import com.ajay.airline.airline_reservation_system.dto.BookingRequest;
import com.ajay.airline.airline_reservation_system.dto.BookingResponse;
import com.ajay.airline.airline_reservation_system.entity.Booking;
import com.ajay.airline.airline_reservation_system.entity.Flight;
import com.ajay.airline.airline_reservation_system.entity.User;
import com.ajay.airline.airline_reservation_system.repository.BookingRepository;
import com.ajay.airline.airline_reservation_system.repository.FlightRepository;
import com.ajay.airline.airline_reservation_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Booking bookFlight(BookingRequest request) {

        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Flight flight = flightRepository
                .findById(request.getFlightId())
                .orElseThrow(() ->
                        new RuntimeException("Flight not found"));

        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available");
        }

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        booking.setPaymentConfirmed(true);

        flight.setAvailableSeats(
                flight.getAvailableSeats() - 1
        );

        flightRepository.save(flight);

        return bookingRepository.save(booking);
    }
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    public Booking cancelBooking(Long bookingId){

        Booking booking = bookingRepository
                .findById(bookingId)
                .orElseThrow(
                        () -> new RuntimeException("Booking not found")
                );

        Flight flight = booking.getFlight();

        flight.setAvailableSeats(
                flight.getAvailableSeats() + 1
        );

        booking.setStatus("CANCELLED");

        flightRepository.save(flight);

        return bookingRepository.save(booking);
    }
    public BookingResponse getBookingResponse(
            Booking booking){

        return new BookingResponse(
                booking.getId(),
                booking.getUser().getFullName(),
                booking.getFlight().getFlightNumber(),
                booking.getFlight().getSource(),
                booking.getFlight().getDestination(),
                booking.getStatus()
        );
    }
}