package app.domain.repository;

//import app.domain.repository.ListingRepository;

public class Repositories {

    private ListingRepository listingRepository;

private Repositories() {
    ListingRepository listingRepository = new ListingRepository();
}

public Repositories getInstance(){ return this; }
public ListingRepository getListingRepository(){ return this.listingRepository; }


}
