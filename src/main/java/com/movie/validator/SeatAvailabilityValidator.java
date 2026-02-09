package com.movie.validator;

import com.movie.model.SeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SeatAvailabilityValidator implements BookingValidator {

    @Override
    public void validate(BookingValidationContext context) {

        boolean unavailable = context.getSeats().stream()
                .anyMatch(seat -> seat.getStatus() == SeatStatus.BOOKED);

        if (unavailable) {
            throw new RuntimeException("One or more seats already booked");
        }
    }
}
