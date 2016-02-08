import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Admin on 08.02.2016.
 */

public class SimplestoreTest {

    final String MOVIE_TITLE = "movie_name";
    final PriceCodes MOVIE_PRICE_CODE = PriceCodes.Childrens;


    @org.junit.Test
    public void testMovieGetters() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        assertEquals("Movie price codes are not equal", MOVIE_PRICE_CODE, movie.getPriceCode());
        assertEquals("Movie titles are not equal", MOVIE_TITLE, movie.getTitle());
    }

    @org.junit.Test
    public void testMovieSetter() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        final PriceCodes NEW_PRICE_CODE = PriceCodes.NewRelease;
        movie.setPriceCode(NEW_PRICE_CODE);
        assertTrue(NEW_PRICE_CODE.equals(movie.getPriceCode()));
    }

    @org.junit.Test
    public void testRentalGetters() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        final int DAYS_RENTAL = 7;
        Rental rental = new Rental(movie, DAYS_RENTAL);
        assertEquals(DAYS_RENTAL, rental.getDaysRented());
        assertEquals("Movie price codes are not equal", MOVIE_PRICE_CODE, rental.getMovie().getPriceCode());
        assertEquals("Movie titles are not equal", MOVIE_TITLE, rental.getMovie().getTitle());
    }

    @org.junit.Test
    public void testCustomer() {
        final String CUSTOMER_NAME = "PIG";
        final int RENTAL_DAYS = 5;
        final String MOVIE_NAME = "Cinderella";
        Customer customer = new Customer(CUSTOMER_NAME);
        final PriceCodes CINDERELLA_CODE = PriceCodes.Childrens;
        Movie movCinderella = new Movie(MOVIE_NAME, CINDERELLA_CODE);
        Rental rental1 = new Rental(movCinderella, RENTAL_DAYS);
        customer.addRental(rental1);

        double expectedAmount = evaluateChildren(RENTAL_DAYS);

        String expectedResult = "Rental record for PIG\n" +
                "\t" + MOVIE_NAME + "\t" + expectedAmount + "\nAmount owed is " + expectedAmount + "\nYou earned "
                + eveluateFrequentRenterPoints(CINDERELLA_CODE, RENTAL_DAYS) + " frequent renter points.";
        assertEquals(expectedResult, customer.Statement());
    }

    private double evaluateChildren(int days) {
        double thisAmount = 0;
        thisAmount += 1.5;
        if (days > 3)
        {
            thisAmount = (days - 3) * 1.5;
        }
        return thisAmount;
    }


    private int eveluateFrequentRenterPoints(PriceCodes codes, int days) {
        // Add bonus for a two-day new-release rental
        int frequentRenterPoints = 1;
        if ((codes == PriceCodes.NewRelease) && (days > 1))
        {
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }
}
