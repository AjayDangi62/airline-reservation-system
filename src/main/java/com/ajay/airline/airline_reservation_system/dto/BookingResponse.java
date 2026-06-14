package com.ajay.airline.airline_reservation_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private String userName;
    private String flightNumber;
    private String source;
    private String destination;
    private String status;
}