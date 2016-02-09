package com.scrumtrek.simplestore;

public class Report {

    public String generate(Customer c) {
        String result = "Rental record for " + c.getName() + "\n";

        for(Rental r : c.getRentals()) {
            result += "\t" + r.getMovie().getTitle() + "\t" + c.getAmount(r) + "\n";
        }

        result += "Amount owed is " + c.getTotalAmount() + "\n";
        result += "You earned " + c.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }
}
