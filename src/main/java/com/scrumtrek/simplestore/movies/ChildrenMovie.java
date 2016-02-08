package com.scrumtrek.simplestore.movies;

import com.scrumtrek.simplestore.PricePolicy;
import com.scrumtrek.simplestore.Rental;

/**
 * Created by Admin on 08.02.2016.
 */
public class ChildrenMovie extends Movie {

    public static final double CHILDREN_PRICE = 1.5;
    public static final int CHILDREN_DAYS_LIMIT = 3;
    public static final double CHILDREN_COEFFICIENT = 1.5;

    public ChildrenMovie(String title) {
        super(title, new PricePolicy(CHILDREN_DAYS_LIMIT, CHILDREN_PRICE));
    }

    @Override
    public double evaluateAmount(Rental rental) {
        double thisAmount = getPrice();
        if (rental.getDaysRented() > getDaysLimit()) {
            thisAmount = (rental.getDaysRented() - getDaysLimit()) * CHILDREN_COEFFICIENT;
        }
        return thisAmount;
    }
}
