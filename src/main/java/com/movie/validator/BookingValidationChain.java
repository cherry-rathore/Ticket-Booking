package com.movie.validator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingValidationChain {

    private final List<BookingValidator> validators;

    public BookingValidationChain(List<BookingValidator> validators) {
        this.validators = validators;
    }

    public void validate(BookingValidationContext context) {
        for (BookingValidator validator : validators) {
            validator.validate(context);
        }
    }
}