package com.scrumtrek.simplestore.movies;

import com.scrumtrek.simplestore.Rental;

/**
 * Created by Admin on 08.02.2016.
 */
public interface PriceEvaluator {
    double evaluateAmount(Rental rental);
}
