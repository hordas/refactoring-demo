package test.com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Admin on 08.02.2016.
 */

public class TestRD {

    final String MOVIE_TITLE = "movie_name";
    final PriceCodes MOVIE_PRICE_CODE = PriceCodes.Childrens;


    @Test
    public void testMovieGetters() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        assertEquals("Movie price codes are not equal", MOVIE_PRICE_CODE, movie.getPriceCode());
        assertEquals("Movie titles are not equal", MOVIE_TITLE, movie.getTitle());
    }

    @Test
    public void testMovieSetter() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        final PriceCodes NEW_PRICE_CODE = PriceCodes.NewRelease;
        movie.setPriceCode(NEW_PRICE_CODE);
        assertTrue(NEW_PRICE_CODE.equals(movie.getPriceCode()));
    }

    @Test
    public void testRentalGetters() {
        Movie movie = new Movie(MOVIE_TITLE, MOVIE_PRICE_CODE);
        final int DAYS_RENTAL = 7;
        Rental rental = new Rental(movie, DAYS_RENTAL);
        assertEquals(DAYS_RENTAL, rental.getDaysRented());
        assertEquals("Movie price codes are not equal", MOVIE_PRICE_CODE, rental.getMovie().getPriceCode());
        assertEquals("Movie titles are not equal", MOVIE_TITLE, rental.getMovie().getTitle());
    }
}
