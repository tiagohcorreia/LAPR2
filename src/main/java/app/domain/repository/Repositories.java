package app.domain.repository;

//import app.domain.repository.ListingRepository;

//public class Repositories {
//
//    private ListingRepository listingRepository;
//
//    private Repositories() {
//        this.listingRepository = new ListingRepository();
//    }
//
//
//    public static Repositories getInstance(){ return new Repositories(); }
//    public ListingRepository getListingRepository(){ return this.listingRepository; }
//
//
//}

public class Repositories
{
    private static Repositories obj;
    private ListingRepository listingRepository;

    // private constructor to force use of
    // getInstance() to create Repositories object
    private Repositories() {
        this.listingRepository = new ListingRepository();
    }

    public static Repositories getInstance()
    {
        if (obj==null)
            obj = new Repositories();
        return obj;
    }

    public ListingRepository getListingRepository(){ return this.listingRepository; }
}