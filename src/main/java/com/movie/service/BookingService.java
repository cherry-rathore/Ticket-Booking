package com.movie.service;

import com.movie.dto.BookingRequest;
import com.movie.dto.BookingResponse;
import com.movie.model.SeatStatus;
import com.movie.model.ShowSeat;
import com.movie.pricing.PricingStrategy;
import com.movie.pricing.PricingStrategyFactory;
import com.movie.repo.ShowSeatRepository;
import com.movie.validator.BookingValidationChain;
import com.movie.validator.BookingValidationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final ShowSeatRepository seatRepo;
    private final PricingStrategyFactory pricingFactory;

    private final BookingValidationChain validationChain;


    public BookingService(ShowSeatRepository seatRepo,
                          PricingStrategyFactory pricingFactory, BookingValidationChain validationChain) {
        this.seatRepo = seatRepo;
        this.pricingFactory = pricingFactory;
        this.validationChain = validationChain;
    }

    public BookingResponse bookTickets(BookingRequest request) {

        List<ShowSeat> seats = seatRepo
                .findByShowIdAndSeatNumberIn(request.showId, request.seats);

        BookingValidationContext context =
                new BookingValidationContext(request, seats);

        validationChain.validate(context);

        boolean unavailable = seats.stream()
                .anyMatch(s -> s.getStatus() == SeatStatus.BOOKED);

        if (unavailable) {
            throw new RuntimeException("Seat already booked");
        }

        seats.forEach(s -> s.setStatus(SeatStatus.BOOKED));
        //seatRepo.saveAll(seats);

        int basePrice = 200; // will configure in application.properties
        PricingStrategy strategy =
                pricingFactory.getStrategy(LocalDateTime.now());

        int amount = strategy.calculatePrice(basePrice, seats.size());

        BookingResponse response = new BookingResponse();
        response.bookingId = System.currentTimeMillis();
        response.amount = amount;
        response.status = "CONFIRMED";

        return response;
    }
}

