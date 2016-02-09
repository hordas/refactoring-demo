package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReportTest {

    @Test
    public void emptyTest() throws Exception {
        String name = "empty";
        Customer empty = new Customer(name);

        String statement = new Report().generate(empty);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points.", statement);
    }

    @Test
    public void testWithRegularPrice() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.REGULAR), 10));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	14.0\n"
                + "Amount owed is 14.0\n"
                + "You earned 1 frequent renter points.", statement);
    }

    @Test
    public void testWithRegularPriceDaysRented2() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.REGULAR), 2));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points.", statement);
    }

    @Test
    public void testWithNewReleaseWithBonus() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.NEW_RELEASE), 5));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	15.0\n"
                + "Amount owed is 15.0\n"
                + "You earned 2 frequent renter points.", statement);
    }

    @Test
    public void testWithNewReleaseWithoutBonus() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.NEW_RELEASE), 1));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points.", statement);
    }

    @Test
    public void testWithChildrens() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 15));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	18.0\n"
                + "Amount owed is 18.0\n"
                + "You earned 1 frequent renter points.", statement);
    }

    @Test
    public void testWithChildrensDaysRented3() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 3));

        String statement = new Report().generate(c1);
        assertNotNull(statement);

        assertEquals(
                "Rental record for " + name + "\n"
                + "	movie-name	1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points.", statement);
    }

    @Test
    public void testHTMLWithChildrensDaysRented3() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 3));

        String statement = new Report().generateHTML(c1);
        assertNotNull(statement);

        assertEquals(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<body>Rental record for test1<br/> movie-name <b>1.5</b><br/>Amount owed is <b>1.5</b>" +
                        "<br/>You earned <b>1</b> frequent renter points.</body></html>", statement);
    }
}
