package com.scrumtrek.simplestore.movies;

import com.scrumtrek.simplestore.PricePolicy;

public abstract class Movie implements PriceEvaluator {
	private String m_Title;
	protected PricePolicy policy;

	public Movie(String title, PricePolicy policy) {
		m_Title = title;
		this.policy = policy;
	}

	public double getPrice() {
		return policy.getPrice();
	}

	public int getDaysLimit() {
		return policy.getDays();
	}

	public String getTitle() {
		return m_Title;
	}
}

