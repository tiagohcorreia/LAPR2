package app.controller;

import app.domain.repository.ListingRepository;
import app.domain.repository.Repositories;
import app.domain.model.Listing;

import java.util.List;

public class DisplayListingsController {

    public DisplayListingsController() {
        Repositories repositories = Repositories.getInstance();
        ListingRepository listingRepository = repositories.getListingRepository();
    }

    public List<String> getAvailableFields(){

        return null;
    }


}
