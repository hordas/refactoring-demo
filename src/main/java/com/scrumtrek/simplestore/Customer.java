package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	public static final int REGULAR_PRICE = 2;
	public static final int REGULAR_DAYS_LIMIT = 2;
	public static final double REGULAR_COEFFICIENT = 1.5;
	public static final int NEW_RELEASE_PRICE = 3;
	public static final double CHILDREN_PRICE = 1.5;
	public static final int CHILDREN_DAYS_LIMIT = 3;
	public static final double CHILDREN_COEFFICIENT = 1.5;

	private String customerName;
	private List<Rental> movieRentals = new ArrayList<>();
	private double totalAmount;
	private int frequentRenterPoints;


	public Customer(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}


	public void addRental(Rental arg){
		movieRentals.add(arg);
	}

	public void evaluateStatement() {
		totalAmount = 0;
		frequentRenterPoints = 0;

		for(Rental rental: movieRentals) {
			double thisAmount = evaluateRentalAmount(rental);

			frequentRenterPoints++;

			frequentRenterPoints = addBonusForTwoDayNewRelease(rental);

			totalAmount += thisAmount;
		}
	}

	public String printStatement() {
		String result = "Rental record for " + customerName + "\n";
		for (Rental rental : movieRentals) {
			result += printMovieDetails(rental, evaluateRentalAmount(rental));
		}
		evaluateStatement();
		result += addFooterLines(totalAmount, frequentRenterPoints);
		return result;
	}

	private double evaluateRentalAmount(Rental rental) {
		return rental.getMovie().evaluateAmount(rental);
	}

	private int addBonusForTwoDayNewRelease(Rental each) {
		//todo применить в new release movie
//		if ((each.getMovie().getPrice() == PriceCodes.NEW_RELEASE) && (each.getDaysRented() > 1)) {
//            frequentRenterPoints ++;
//        }
		return frequentRenterPoints;
	}

	private String printMovieDetails(Rental rental, double thisAmount) {
		return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
	}

	private String addFooterLines(double totalAmount, int frequentRenterPoints) {
		String result = "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}
}

