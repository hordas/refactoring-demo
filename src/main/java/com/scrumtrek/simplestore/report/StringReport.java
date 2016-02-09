package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;

/**
 * Created by Admin on 09.02.2016.
 */
public class StringReport extends BaseReport {

    public StringReport(Customer customer) {
        super(customer);
        header =  "Rental record for " + customer.getName() + "\n";
        footer = "Amount owed is " + customer.getTotalAmount() + "\nYou earned " + customer.getFrequentRenterPoints() + " frequent renter points.";
    }
}
