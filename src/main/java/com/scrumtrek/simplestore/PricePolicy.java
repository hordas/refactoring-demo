package com.scrumtrek.simplestore;

/**
 * Created by Admin on 08.02.2016.
 */
public class PricePolicy {
    private int days;
    private double price;

    public PricePolicy(int days, double price) {
        this.days = days;
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public double getPrice() {
        return price;
    }
}
