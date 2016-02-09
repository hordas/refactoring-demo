package com.scrumtrek.simplestore;

public class NewReleaseRentalGetter implements RentalGetter {

    @Override
    public double getAmount(Rental r) {
        return r.getDaysRented() * 3.0;
    }
}
