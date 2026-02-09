package com.movie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat {

    private Long id;

    private Long showId;
    private String seatNumber;

    private SeatStatus status; // AVAILABLE, BOOKED
}