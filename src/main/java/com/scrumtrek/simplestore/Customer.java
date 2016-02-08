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
		double thisAmount = 0;

		// Determine amounts for rental line
		switch(rental.getMovie().getPriceCode()) {
            case REGULAR:
				thisAmount = evaluateRegularAmount(rental, thisAmount);
                break;

            case NEW_RELEASE:
				thisAmount = evaluateNewReleaseAmount(rental, thisAmount);
				break;

            case CHILDRENS:
				thisAmount = evaluateChildrenAmount(rental, thisAmount);
                break;

			default:
				throw new IllegalArgumentException("Not supported Price Code: " + rental.getMovie().getPriceCode());
        }
		return thisAmount;
	}

	private double evaluateChildrenAmount(Rental rental, double thisAmount) {
		thisAmount += CHILDREN_PRICE;
		if (rental.getDaysRented() > CHILDREN_DAYS_LIMIT) {
            thisAmount = (rental.getDaysRented() - CHILDREN_DAYS_LIMIT) * CHILDREN_COEFFICIENT;
        }
		return thisAmount;
	}

	private double evaluateNewReleaseAmount(Rental rental, double thisAmount) {
		thisAmount += rental.getDaysRented() * NEW_RELEASE_PRICE;
		return thisAmount;
	}

	private double evaluateRegularAmount(Rental rental, double thisAmount) {
		thisAmount += REGULAR_PRICE;
		if (rental.getDaysRented() > REGULAR_DAYS_LIMIT) {
            thisAmount += (rental.getDaysRented() - REGULAR_DAYS_LIMIT) * REGULAR_COEFFICIENT;
        }
		return thisAmount;
	}

	private int addBonusForTwoDayNewRelease(Rental each) {
		if ((each.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (each.getDaysRented() > 1)) {
            frequentRenterPoints ++;
        }
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

