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

//v3
public class Repositories {

    private static final pt.ipp.isep.dei.esoft.project.domain.repository.Repositories instance = new pt.ipp.isep.dei.esoft.project.domain.repository.Repositories();
    AnnouncementRepository announcementRepository = new AnnouncementRepository();
    RegisterEmployeeRepository employeeRepository = new RegisterEmployeeRepository();
    StateRepository stateRepository = new StateRepository();
    DistrictRepository districtRepository = new DistrictRepository();
    CityRepository cityRepository = new CityRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    private Repositories() {
    }

    public static pt.ipp.isep.dei.esoft.project.domain.repository.Repositories getInstance() {
        return instance;
    }

    public AnnouncementRepository getAnnouncementRepository() {return announcementRepository;}

    public RegisterEmployeeRepository getEmployeeRepository() {return  employeeRepository;}
    public StateRepository getStateRepository() {return  stateRepository;}
    public DistrictRepository getDistrictRepository() {return  districtRepository;}
    public CityRepository getCityRepository() {return  cityRepository;}

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }
}