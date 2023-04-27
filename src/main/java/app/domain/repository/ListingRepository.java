package app.domain.repository;

import app.domain.model.Listing;

import java.util.ArrayList;
import java.util.List;

public class ListingRepository {
    List<Listing> listings = new ArrayList<>();

    public boolean save(Listing listing) {
        return listings.add(listing.getListing());
    }

    public List<Listing> getAllVisibleListings() {
        List<Listing> allVisibleListings = new ArrayList<>();
        for(Listing listing: listings){
            if (listing.isVisible()){
                allVisibleListings.add(listing.getListing());
            }
        }
        return allVisibleListings;
    }

    public List<List<Object>> getAvailableFields(){
        List<List<Object>> availableFields = new ArrayList<>();
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());

        //TO-FIX
        for(Listing listing : listings){
            if ( listing != null && listing.isVisible()){
                if (!availableFields.get(0).contains(listing.getTypeOfBusiness())){
                    availableFields.get(0).add(listing.getTypeOfBusiness());
                }
                if (!availableFields.get(1).contains(listing.getProperty().getClass().getSimpleName())){
                    availableFields.get(1).add(listing.getProperty().getClass().getSimpleName());
                }
                if (listing.getProperty().getClass().getSimpleName().equals("Land") && true){
                //if (listing.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(listing.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(300);
                    //availableFields.get(2).add(listing.getProperty().getBedrooms());
                }
            }
        }
        return availableFields;
    }

    public List<Listing> getListings(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        List<Listing> matchingListings = new ArrayList<>();
        for(Listing listing: listings){
            Listing gotListing = listing.getListing(typeOfBusiness, typeOfProperty, numberOfBedrooms);
            if(gotListing != null){
                matchingListings.add(gotListing);
            }
        }
        return matchingListings;
    }

}
