package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    private final RentalCalculator priceCodeCalculator = new RentalCalculator();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }
        }

        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            double thisAmount = getAmount(each);
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    public double getAmount(Rental r) {
        return priceCodeCalculator.getAmount(r);
    }
}
