package com.scrumtrek.simplestore;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RentalCalculatorTest {

    @Test
    public void testNotFound() throws Exception {
        RentalCalculator c = new RentalCalculator();
        c.setPriceCodeGetters(new HashMap<>());

        try {
            c.getAmount(new Rental(new Movie("m2", PriceCodes.REGULAR), 102));
            fail("exception expected");
        } catch(IllegalArgumentException e) {
            assertEquals("can't find price code getter for '" + PriceCodes.REGULAR + "'", e.getMessage());
        }
    }

    @Test
    public void testFoundRegular() throws Exception {
        RentalCalculator c = new RentalCalculator();

        double amount = c.getAmount(new Rental(new Movie("m2", PriceCodes.REGULAR), 102));
        assertEquals(152.0, amount, 0.0);
    }

    @Test
    public void testFoundNewRelease() throws Exception {
        RentalCalculator c = new RentalCalculator();

        double amount = c.getAmount(new Rental(new Movie("m2", PriceCodes.NEW_RELEASE), 100));
        assertEquals(300.0, amount, 0.0);
    }

    @Test
    public void testFoundChildrens() throws Exception {
        RentalCalculator c = new RentalCalculator();

        double amount = c.getAmount(new Rental(new Movie("m2", PriceCodes.CHILDRENS), 100));
        assertEquals(145.5, amount, 0.0);
    }
}
