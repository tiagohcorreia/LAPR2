package app.domain.repository;

import app.domain.model.Listing;

import java.util.ArrayList;
import java.util.List;

public class ListingRepository {
    private List<Listing> listings = new ArrayList<>();

    public boolean save(Listing listing) {
        return listings.add(listing);
    }

    public List<Listing> getAll() { return new ArrayList<>(listings); }


}
