package com.scrumtrek.simplestore;

public class RegularRentalGetter implements RentalGetter {

    @Override
    public double getAmount(Rental r) {
        double thisAmount = 2;
        if (r.getDaysRented() > 2) {
            thisAmount += (r.getDaysRented() - 2) * 1.5;
        }

        return thisAmount;
    }

}
