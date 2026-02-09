package com.movie.pricing;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PricingStrategyFactory {

    public PricingStrategy getStrategy(LocalDateTime showTime) {
        if (showTime.getHour() < 16) {
            return new AfternoonDiscountStrategy();
        }
        return (base, count) -> base * count;
    }
}