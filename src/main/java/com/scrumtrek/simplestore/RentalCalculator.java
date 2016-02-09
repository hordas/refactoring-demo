package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

public class RentalCalculator {

    private Map<PriceCodes, RentalGetter> priceCodeGetters = createGetters();

    public double getAmount(Rental r) {
        PriceCodes pc = r.getMovie().getPriceCode();
        RentalGetter g = priceCodeGetters.get(pc);
        if (g == null) {
            throw new IllegalArgumentException("can't find price code getter for '" + pc + "'");
        }

        return g.getAmount(r);
    }

    public void setPriceCodeGetters(Map<PriceCodes, RentalGetter> priceCodeGetters) {
        this.priceCodeGetters = priceCodeGetters;
    }

    private static Map<PriceCodes, RentalGetter> createGetters() {
        Map<PriceCodes, RentalGetter> result = new HashMap<>();

        result.put(PriceCodes.CHILDRENS, new ChildrenRentalGetter());
        result.put(PriceCodes.NEW_RELEASE, new NewReleaseRentalGetter());
        result.put(PriceCodes.REGULAR, new RegularRentalGetter());
        result.put(PriceCodes.XXX, new XXXRentalGetter());

        return result;
    }
}

