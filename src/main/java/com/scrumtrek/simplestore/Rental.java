package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.movies.Movie;

public class Rental {
	private Movie m_Movie;//todo - code conventions
	private int m_DaysRented;

	public Rental(Movie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public Movie getMovie() {
		return m_Movie;
	}
}

