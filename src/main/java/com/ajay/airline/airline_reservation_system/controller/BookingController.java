package com.ajay.airline.airline_reservation_system.controller;

import com.ajay.airline.airline_reservation_system.dto.BookingRequest;
import com.ajay.airline.airline_reservation_system.dto.BookingResponse;
import com.ajay.airline.airline_reservation_system.entity.Booking;
import com.ajay.airline.airline_reservation_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingResponse bookFlight(
            @RequestBody BookingRequest request){

        Booking booking =
                bookingService.bookFlight(request);

        return bookingService
                .getBookingResponse(booking);
    }
    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(
            @PathVariable Long userId) {

        return bookingService.getUserBookings(userId);
    }
    @DeleteMapping("/{bookingId}")
    public Booking cancelBooking(
            @PathVariable Long bookingId){

        return bookingService.cancelBooking(bookingId);
    }
}