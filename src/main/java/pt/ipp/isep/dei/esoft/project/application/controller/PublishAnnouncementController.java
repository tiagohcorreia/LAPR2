package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublishAnnouncementController {

    private List<Announcement> announcements;
    private List<TypeOfProperty> typesOfProperty;
    private List<City> cities;
    private List<SunExposure> sunExposures;
    private List<TypeOfBusiness> typesOfBusiness;

    private AnnouncementRepository announcementRepository;
    private AuthenticationController authenticationController;
    Repositories repositories = Repositories.getInstance();
    RegisterEmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    StateRepository stateRepository = repositories.getStateRepository();
    DistrictRepository districtRepository = repositories.getDistrictRepository();
    CityRepository cityRepository = repositories.getCityRepository();

    public PublishAnnouncementController(AnnouncementRepository announcementRepository, AuthenticationController authenticationController) {
        this.announcementRepository = announcementRepository;
        this.authenticationController = authenticationController;


    }




    public void createAnnouncement(TypeOfBusiness sellOrRent, int posTypeOfProperty, int bedrooms, int bathrooms, int parkingSpaces,
                                   ArrayList<String> equipmentList,boolean hasBasement, boolean hasLoft, SunExposure sunExposure,
                                   int area, City location, int cityCentreDistance, float commission, float price, ArrayList photographs, String agentName){
        RegisterEmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

        // get the employee corresponding to the agent email
        String emailAdress = null;
        Employee agent = employeeRepository.findByEmail(emailAdress);

        agentName = String.valueOf(authenticationController.getCurrentSession());

         agent = employeeRepository.getUserByEmail(agentName);

        if (posTypeOfProperty == 2) {
            Property property = new Apartment(area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList);
            Announcement announcement = new Announcement(true,  commission, price ,sellOrRent, property, agent);
            this.announcementRepository.createAnnouncement(announcement);
        } else if (posTypeOfProperty == 1) {
            Property property = new House(area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
            Announcement announcement = new Announcement(true,  commission, price, sellOrRent, property, agent);
            this.announcementRepository.createAnnouncement(announcement);
        } else {
            Property property = new Land(area, location, cityCentreDistance, photographs);
            Announcement announcement = new Announcement(true, commission, price, sellOrRent, property, agent);
            this.announcementRepository.createAnnouncement(announcement);
        }


    }




    public City getCity (String city){
        return cityRepository.findByName(city);
    }
    public List<SunExposure> getSunExposureAsList () {
        return Arrays.stream(SunExposure.values()).toList();
    }

    public List<TypeOfProperty> getTypeOfPropertyAsList () {
        return Arrays.stream(TypeOfProperty.values()).toList();
    }

    public List<TypeOfBusiness> getTypeOfBusinessAsList () {
        return Arrays.stream(TypeOfBusiness.values()).toList();
    }

   /* public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeRepository.getEmployeeList()) {

            if(employee.getRole().equals("Agent")) {
                agent.add(employee);
            }
        }
        return agent;

    }
    public Employee getEmployee(String name){
        return employeeRepository.getEmployee(name);
    }*/


}


