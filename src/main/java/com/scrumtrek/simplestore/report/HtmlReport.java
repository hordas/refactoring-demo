package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;

/**
 * Created by Admin on 09.02.2016.
 */
public class HtmlReport extends BaseReport {

    public HtmlReport(Customer customer) {
        super(customer);
        this.header = "<!DOCTYPE html>\n" +
                "<html>\n<body>Rental record for " + customer.getName() + "<br/>";
    }


}
