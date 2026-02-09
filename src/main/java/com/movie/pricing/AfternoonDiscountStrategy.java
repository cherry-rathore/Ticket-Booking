package com.movie.pricing;

public class AfternoonDiscountStrategy implements PricingStrategy {

    @Override
    public int calculatePrice(int basePrice, int ticketCount) {
        return (int)(basePrice * ticketCount * 0.8);
    }
}
