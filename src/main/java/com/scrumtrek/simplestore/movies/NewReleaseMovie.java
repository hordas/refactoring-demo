package com.scrumtrek.simplestore.movies;

import com.scrumtrek.simplestore.PricePolicy;
import com.scrumtrek.simplestore.Rental;

/**
 * Created by Admin on 08.02.2016.
 */
public class NewReleaseMovie extends Movie {

    public static final int NEW_RELEASE_PRICE = 3;

    public NewReleaseMovie(String title) {
        super(title, new PricePolicy(0, NEW_RELEASE_PRICE));
    }

    @Override
    public double evaluateAmount(Rental rental) {
        double thisAmount = rental.getDaysRented() * NEW_RELEASE_PRICE;
        return thisAmount;
    }
}
