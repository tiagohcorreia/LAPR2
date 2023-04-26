package app.controller;

import app.domain.repository.ListingRepository;
import app.domain.repository.Repositories;
import app.domain.model.Listing;

import java.util.List;

public class DisplayListingsController {
    Repositories repositories = Repositories.getInstance();
    ListingRepository listingRepository = repositories.getListingRepository();

    public List<List<Object>> getAvailableFields(){
        return this.listingRepository.getAvailableFields();
    }

    public List<Listing> getListings(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        return listingRepository.getListings(typeOfBusiness, typeOfProperty, numberOfBedrooms);
    }

    public List<Listing> getAllVisibleListings(){
        return listingRepository.getAllVisibleListings();
    }

}
