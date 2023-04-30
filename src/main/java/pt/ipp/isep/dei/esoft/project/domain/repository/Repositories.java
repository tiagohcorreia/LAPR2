package pt.ipp.isep.dei.esoft.project.domain.repository;

//import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;

//v1
//public class Repositories {
//
//    private AnnouncementRepository announcementRepository;
//
//    private Repositories() {
//        this.announcementRepository = new AnnouncementRepository();
//    }
//
//
//    public static Repositories getInstance(){ return new Repositories(); }
//    public AnnouncementRepository getListingRepository(){ return this.announcementRepository; }
//
//
//}

//v2
//public class Repositories
//{
//    private static Repositories obj;
//    private AnnouncementRepository announcementRepository;
//
//    // private constructor to force use of
//    // getInstance() to create Repositories object
//    private Repositories() {
//        this.announcementRepository = new AnnouncementRepository();
//    }
//
//    public static Repositories getInstance()
//    {
//        if (obj==null)
//            obj = new Repositories();
//        return obj;
//    }
//
//    public AnnouncementRepository getListingRepository(){ return this.announcementRepository; }
//}


import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

/**
 * The type Repositories.
 */
//v3
public class Repositories {

    private static final pt.ipp.isep.dei.esoft.project.domain.repository.Repositories instance = new pt.ipp.isep.dei.esoft.project.domain.repository.Repositories();
    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = new AnnouncementRepository();
    /**
     * The Employee repository.
     */
    RegisterEmployeeRepository employeeRepository = new RegisterEmployeeRepository();
    /**
     * The State repository.
     */
    StateRepository stateRepository = new StateRepository();
    /**
     * The District repository.
     */
    DistrictRepository districtRepository = new DistrictRepository();
    /**
     * The City repository.
     */
    CityRepository cityRepository = new CityRepository();
    /**
     * The Authentication repository.
     */
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    private Repositories() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static pt.ipp.isep.dei.esoft.project.domain.repository.Repositories getInstance() {
        return instance;
    }

    /**
     * Gets announcement repository.
     *
     * @return the announcement repository
     */
    public AnnouncementRepository getAnnouncementRepository() {return announcementRepository;}

    /**
     * Gets employee repository.
     *
     * @return the employee repository
     */
    public RegisterEmployeeRepository getEmployeeRepository() {return  employeeRepository;}

    /**
     * Gets state repository.
     *
     * @return the state repository
     */
    public StateRepository getStateRepository() {return  stateRepository;}

    /**
     * Gets district repository.
     *
     * @return the district repository
     */
    public DistrictRepository getDistrictRepository() {return  districtRepository;}

    /**
     * Gets city repository.
     *
     * @return the city repository
     */
    public CityRepository getCityRepository() {return  cityRepository;}

    /**
     * Gets authentication repository.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }
}