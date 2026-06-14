package com.ajay.airline.airline_reservation_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequest {
    private Long userId;
    private Long flightId;
}
