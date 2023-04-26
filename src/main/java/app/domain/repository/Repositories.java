package app.domain.repository;

//import app.domain.repository.ListingRepository;

//v1
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

//v2
//public class Repositories
//{
//    private static Repositories obj;
//    private ListingRepository listingRepository;
//
//    // private constructor to force use of
//    // getInstance() to create Repositories object
//    private Repositories() {
//        this.listingRepository = new ListingRepository();
//    }
//
//    public static Repositories getInstance()
//    {
//        if (obj==null)
//            obj = new Repositories();
//        return obj;
//    }
//
//    public ListingRepository getListingRepository(){ return this.listingRepository; }
//}


//v3
public class Repositories {

    private static final app.domain.repository.Repositories instance = new app.domain.repository.Repositories();
    ListingRepository listingRepository = new ListingRepository();

    private Repositories() {
    }

    public static app.domain.repository.Repositories getInstance() {
        return instance;
    }

    public ListingRepository getListingRepository() {return  listingRepository;}


}