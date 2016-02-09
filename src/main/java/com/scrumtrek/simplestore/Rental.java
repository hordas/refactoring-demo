package com.scrumtrek.simplestore;

public class Rental {

    private final Movie movie;
    private final int dyasRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        dyasRented = daysRented;
    }

    public int getDaysRented() {
        return dyasRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
