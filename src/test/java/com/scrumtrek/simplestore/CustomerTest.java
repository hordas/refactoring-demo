package com.scrumtrek.simplestore;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void emptyTest() throws Exception {
        String name = "empty";
        Customer empty = new Customer(name);

        double total = empty.getTotalAmount();
        assertEquals(0.0, total, 0.0);

        int points = empty.getFrequentRenterPoints();
        assertEquals(0, points);
    }

    @Test
    public void testWithRegularPrice() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.REGULAR), 10));

        double total = c1.getTotalAmount();
        assertEquals(14.0, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(1, points);
    }

    @Test
    public void testWithRegularPriceDaysRented2() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.REGULAR), 2));

        double total = c1.getTotalAmount();
        assertEquals(2.0, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(1, points);
    }

    @Test
    public void testWithNewReleaseWithBonus() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.NEW_RELEASE), 5));

        double total = c1.getTotalAmount();
        assertEquals(15.0, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(2, points);
    }

    @Test
    public void testWithNewReleaseWithoutBonus() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.NEW_RELEASE), 1));

        double total = c1.getTotalAmount();
        assertEquals(3.0, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(1, points);
    }

    @Test
    public void testWithChildrens() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 15));

        double total = c1.getTotalAmount();
        assertEquals(18.0, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(1, points);
    }

    @Test
    public void testWithChildrensDaysRented3() throws Exception {
        String name = "test1";
        Customer c1 = new Customer(name);

        c1.addRental(new Rental(new Movie("movie-name", PriceCodes.CHILDRENS), 3));

        double total = c1.getTotalAmount();
        assertEquals(1.5, total, 0.0);

        int points = c1.getFrequentRenterPoints();
        assertEquals(1, points);
    }
}
