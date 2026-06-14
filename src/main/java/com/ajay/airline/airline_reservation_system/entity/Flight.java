package com.ajay.airline.airline_reservation_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private String flightNumber;
    @NotBlank
    private String source;
    @NotBlank
    private String destination;
    @Positive
    private Double price;
    @Positive
    private int totalSeats;
    @PositiveOrZero
    private int availableSeats;
    @NotNull
    private LocalDateTime arrivalTime;
    @NotNull
    private LocalDateTime departureTime;
}
