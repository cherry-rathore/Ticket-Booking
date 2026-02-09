package com.movie.pricing;

public interface PricingStrategy {
    int calculatePrice(int basePrice, int ticketCount);
}
