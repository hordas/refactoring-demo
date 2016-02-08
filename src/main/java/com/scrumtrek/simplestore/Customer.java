package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	//todo - код конвеншены в названиях - 5
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

	public Customer(String name) {
		m_Name = name;
	}

	//todo - не используется - 2
	public String getName() {
		return m_Name;
	}


	public void addRental(Rental arg){
		m_Rentals.add(arg);
	}

	//todo - неинформативное название метода - 3, метод написан с большой буквы - 4.
	public String Statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + m_Name + "\n";

		//todo - название each
		for(Rental each: m_Rentals) {
			double thisAmount = 0; //todo -  использование слова this в названии
			
			// Determine amounts for each line
			switch(each.getMovie().getPriceCode()) {
				case Regular:
					thisAmount += 2; //todo - magic numbers 1
					if (each.getDaysRented() > 2)
					{
						thisAmount += (each.getDaysRented() - 2) * 1.5; //todo - magic numbers 1
					}
					break;
	
				case NewRelease:
					thisAmount += each.getDaysRented() * 3;
					break;
	
				case Childrens:
					thisAmount += 1.5;
					if (each.getDaysRented() > 3)
					{
						thisAmount = (each.getDaysRented() - 3) * 1.5;
					}
					break;

				//todo - отсутствует обработка варианта по умолчанию - 1
			}

			// Add frequent renter points
			frequentRenterPoints++;//todo - комментарии дублируют название переменной

			// Add bonus for a two-day new-release rental
			if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) //todo - сложное выражение в условном операторе
			{
				frequentRenterPoints ++;
			}

			// Show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}
}

