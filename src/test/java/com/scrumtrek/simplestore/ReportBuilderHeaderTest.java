package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.BaseReport;
import com.scrumtrek.simplestore.report.HtmlReport;
import com.scrumtrek.simplestore.report.StringReport;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Admin on 09.02.2016.
 */
public class ReportBuilderHeaderTest {

    @Test
    public void testHeader() {
        String name = "test1";
        Customer c1 = new Customer(name);
        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 3));

        String actual = new BaseReport.ReportBuilder(new StringReport(c1)).setHeader().printReport();
        String expected = "Rental record for " + name + "\n";
        assertEquals(expected, actual);

        actual = new BaseReport.ReportBuilder(new HtmlReport(c1)).setHeader().printReport();
        expected = "<!DOCTYPE html>\n" +
                "<html>\n<body>Rental record for " + c1.getName() + "<br/>";
        assertEquals(expected, actual);
    }
}
