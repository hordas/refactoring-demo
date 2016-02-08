package com.scrumtrek.simplestore;

class MainClass {
	public static void main(String[] args) { //todo - psvm - 1 - невозможно запустить программу
		// Create movies
		Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
		Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
		Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck"); //todo - неиспользуемые строки
		Customer custMinnieMouse = new Customer("Minnie Mouse");//todo - неиспользуемые строки

		// Create rentals
		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		// Generate invoice
		String statement = custMickeyMouse.Statement();

		// Print the statement
		System.out.println(statement);		
	}
}

