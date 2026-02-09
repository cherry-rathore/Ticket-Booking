package com.movie.controller;

import com.movie.dto.BookingRequest;
import com.movie.dto.BookingResponse;
import com.movie.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse book(@RequestBody BookingRequest request) {
        return bookingService.bookTickets(request);
    }
}

