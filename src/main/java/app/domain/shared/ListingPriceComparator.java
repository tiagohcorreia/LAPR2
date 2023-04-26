package app.domain.shared;

import app.domain.model.Listing;

import java.util.Comparator;

public class ListingPriceComparator implements Comparator<Listing> {
    @Override
    public int compare(Listing o1, Listing o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
