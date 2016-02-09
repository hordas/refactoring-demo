package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChildrenRentalGetterTest {

    private ChildrenRentalGetter childrenRentalGetter;

    @Before
    public void init() {
        childrenRentalGetter = new ChildrenRentalGetter();
    }

    @Test
    public void test0Days() throws Exception {
        int days = 0;

        double amount = childrenRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.CHILDRENS), days));

        assertEquals(1.5, amount, 0.0);
    }

    @Test
    public void test3Days() throws Exception {
        int days = 3;

        double amount = childrenRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.CHILDRENS), days));

        assertEquals(1.5, amount, 0.0);
    }

    @Test
    public void test4Days() throws Exception {
        int days = 4;

        double amount = childrenRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.CHILDRENS), days));

        assertEquals(1.5, amount, 0.0);
    }

    @Test
    public void test5Days() throws Exception {
        int days = 5;

        double amount = childrenRentalGetter.getAmount(new Rental(new Movie("m1", PriceCodes.CHILDRENS), days));

        assertEquals(3.0, amount, 0.0);
    }
}
