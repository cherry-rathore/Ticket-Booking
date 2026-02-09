package com.movie.validator;

import com.movie.dto.BookingRequest;
import com.movie.model.ShowSeat;

import java.util.List;

public class BookingValidationContext {
    private final BookingRequest request;
    private final List<ShowSeat> seats;

    public BookingValidationContext(BookingRequest request, List<ShowSeat> seats) {
        this.request = request;
        this.seats = seats;
    }

    public BookingRequest getRequest() {
        return request;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }
}