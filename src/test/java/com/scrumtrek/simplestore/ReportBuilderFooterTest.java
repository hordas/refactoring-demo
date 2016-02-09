package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.BaseReport;
import com.scrumtrek.simplestore.report.HtmlReport;
import com.scrumtrek.simplestore.report.StringReport;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Admin on 09.02.2016.
 */
public class ReportBuilderFooterTest {

    @Test
    public void testFooter() {
        String name = "test1";
        Customer c1 = new Customer(name);
        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 3));

        String actual = new BaseReport.ReportBuilder(new StringReport(c1)).setFooter().printReport();
        String expected = "Amount owed is " + c1.getTotalAmount() + "\nYou earned " + c1.getFrequentRenterPoints() + " frequent renter points.";
        assertEquals(expected, actual);

        actual = new BaseReport.ReportBuilder(new HtmlReport(c1)).setFooter().printReport();
        expected =  "Amount owed is <b>" + c1.getTotalAmount() + "</b><br/>" + "You earned <b>" + c1.getFrequentRenterPoints() + "</b> frequent renter points.</body></html>";
        assertEquals(expected, actual);
    }
}
