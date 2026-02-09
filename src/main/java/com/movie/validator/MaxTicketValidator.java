package com.movie.validator;

import org.springframework.stereotype.Component;

@Component
public class MaxTicketValidator implements BookingValidator {

    private static final int MAX_TICKETS = 6;

    @Override
    public void validate(BookingValidationContext context) {
        if (context.getRequest().seats.size() > MAX_TICKETS) {
            throw new RuntimeException("Maximum 6 tickets allowed");
        }
    }
}
