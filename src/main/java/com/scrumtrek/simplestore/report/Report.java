package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

public class Report {

    private String header = "";
    private String body = "";
    private String footer = "";

    public String generate(Customer c) {
        String result = "Rental record for " + c.getName() + "\n";

        for(Rental r : c.getRentals()) {
            result += "\t" + r.getMovie().getTitle() + "\t" + c.getAmount(r) + "\n";
        }

        result += "Amount owed is " + c.getTotalAmount() + "\n";
        result += "You earned " + c.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    public String generateHTML(Customer c) {
        String result = "<!DOCTYPE html>\n" +
                "<html>\n<body>Rental record for " + c.getName() + "<br/>";

        for(Rental r : c.getRentals()) {
            result += " " + r.getMovie().getTitle() + " <b>" + c.getAmount(r) + "</b><br/>";
        }

        result += "Amount owed is <b>" + c.getTotalAmount() + "</b><br/>";
        result += "You earned <b>" + c.getFrequentRenterPoints() + "</b> frequent renter points.</body></html>";
        return result;
    }
}

