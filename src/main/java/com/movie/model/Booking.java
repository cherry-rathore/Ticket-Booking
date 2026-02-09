package com.movie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
    private Long id;

    private Long showId;
    private int totalAmount;
    private BookingStatus status; // CREATED, CONFIRMED
}