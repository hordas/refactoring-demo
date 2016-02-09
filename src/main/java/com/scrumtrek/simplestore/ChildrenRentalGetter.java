package com.scrumtrek.simplestore;

public class ChildrenRentalGetter implements RentalGetter {

    @Override
    public double getAmount(Rental r) {
        if (r.getDaysRented() > 4) {
            return (r.getDaysRented() - 3) * 1.5;
        }

        return 1.5;
    }
}
