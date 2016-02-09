package com.scrumtrek.simplestore;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class NewReleaseRentalGetterTest {

    private NewReleaseRentalGetter newReleaseRentalGetter;

    @Before
    public void init() {
        newReleaseRentalGetter = new NewReleaseRentalGetter();
    }

    @Test
    public void test0Days() throws Exception {
        int days = 0;

        double amount = newReleaseRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.NEW_RELEASE), days));

        assertEquals(0.0, amount, 0.0);
    }

    @Test
    public void test10Days() throws Exception {
        int days = 10;

        double amount = newReleaseRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.NEW_RELEASE), days));

        assertEquals(30.0, amount, 0.0);
    }
}
