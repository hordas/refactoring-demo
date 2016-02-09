package com.scrumtrek.simplestore;

/**
 * Created by Admin on 09.02.2016.
 */
public class XXXRentalGetter implements RentalGetter {

    @Override
    public double getAmount(Rental r) {
        double thisAmount = 2;
        if (r.getDaysRented() > 5) {
            thisAmount += ((r.getDaysRented() - 5) * 0.8);
        }
        return thisAmount;
    }
}