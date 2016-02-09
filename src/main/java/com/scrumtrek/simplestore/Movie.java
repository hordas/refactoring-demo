package com.scrumtrek.simplestore;

public class Movie {

    private final String title;
    private final PriceCodes priceCode;

    public Movie(String title, PriceCodes priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCodes getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}
