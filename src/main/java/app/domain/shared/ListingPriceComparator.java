package app.domain.shared;

import app.domain.model.Announcement;

import java.util.Comparator;

public class ListingPriceComparator implements Comparator<Announcement> {
    @Override
    public int compare(Announcement o1, Announcement o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
