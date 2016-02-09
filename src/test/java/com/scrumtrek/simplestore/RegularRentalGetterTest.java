package com.scrumtrek.simplestore;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class RegularRentalGetterTest {

    private RegularRentalGetter regularRentalGetter;

    @Before
    public void init() {
        regularRentalGetter = new RegularRentalGetter();
    }

    @Test
    public void test0Days() throws Exception {
        int days = 0;

        double amount = regularRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.REGULAR), days));

        assertEquals(2.0, amount, 0.0);
    }

    @Test
    public void test1Days() throws Exception {
        int days = 1;

        double amount = regularRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.REGULAR), days));

        assertEquals(2.0, amount, 0.0);
    }

    @Test
    public void test2Days() throws Exception {
        int days = 2;

        double amount = regularRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.REGULAR), days));

        assertEquals(2.0, amount, 0.0);
    }

    @Test
    public void test3Days() throws Exception {
        int days = 3;

        double amount = regularRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.REGULAR), days));

        assertEquals(3.5, amount, 0.0);
    }
}
