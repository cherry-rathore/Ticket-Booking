package com.movie.validator;

import org.springframework.stereotype.Component;

@Component
public class SeatSelectionValidator implements BookingValidator {

    @Override
    public void validate(BookingValidationContext context) {
        if (context.getRequest().seats == null ||
                context.getRequest().seats.isEmpty()) {
            throw new RuntimeException("No seats selected");
        }
    }
}
