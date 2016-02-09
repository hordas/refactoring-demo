package com.scrumtrek.simplestore;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Admin on 09.02.2016.
 */
public class XXXRentalGetterTest {

    @Test
    public void testXXXRental(){
        int days = 1;
        int days2 = 6;
        XXXRentalGetter rental = new XXXRentalGetter();
        assertEquals(2.0, rental.getAmount(new Rental(new Movie("m1", PriceCodes.XXX), days)));
        assertEquals(2.8, rental.getAmount(new Rental(new Movie("m1", PriceCodes.XXX), days2)));
    }
}
