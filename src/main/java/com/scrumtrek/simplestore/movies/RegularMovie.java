package com.scrumtrek.simplestore.movies;

import com.scrumtrek.simplestore.PricePolicy;
import com.scrumtrek.simplestore.Rental;

/**
 * Created by Admin on 08.02.2016.
 */
public class RegularMovie extends Movie {

    public static final double REGULAR_COEFFICIENT = 1.5;
    public static final double REGULAR_PRICE = 2;
    public static final int REGULAR_DAYS_LIMIT = 2;

    public RegularMovie(String title) {
        super(title, new PricePolicy(REGULAR_DAYS_LIMIT, REGULAR_PRICE));
    }

    @Override
    public double evaluateAmount(Rental rental) {
        double thisAmount = policy.getPrice();
        if (rental.getDaysRented() > policy.getDays()) {
            thisAmount += (rental.getDaysRented() - policy.getDays()) * REGULAR_COEFFICIENT;
        }
        return thisAmount;
    }
}
