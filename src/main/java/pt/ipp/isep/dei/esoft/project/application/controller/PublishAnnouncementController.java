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

/**
 * The type Publish announcement controller.
 */
public class PublishAnnouncementController {

    private AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    private AuthenticationController authenticationController=new AuthenticationController();
    /**
     * The Repositories.
     */
    //Repositories repositories = Repositories.getInstance();
    /**
     * The Employee repository.
     */
    RegisterEmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    /**
     * The State repository.
     */
    StateRepository stateRepository = Repositories.getInstance().getStateRepository();
    /**
     * The District repository.
     */
    DistrictRepository districtRepository = Repositories.getInstance().getDistrictRepository();
    /**
     * The City repository.
     */
    CityRepository cityRepository = Repositories.getInstance().getCityRepository();

    /**
     * Create announcement.
     *
     * @param sellOrRent         the sell or rent
     * @param posTypeOfProperty  the pos type of property
     * @param bedrooms           the bedrooms
     * @param bathrooms          the bathrooms
     * @param parkingSpaces      the parking spaces
     * @param equipmentList      the equipment list
     * @param hasBasement        the has basement
     * @param hasLoft            the has loft
     * @param sunExposure        the sun exposure
     * @param area               the area
     * @param location           the location
     * @param cityCentreDistance the city centre distance
     * @param commission         the commission
     * @param price              the price
     * @param photographs        the photographs
     * @param agentName          the agent name
     */
    public void createAnnouncement(TypeOfBusiness sellOrRent, int posTypeOfProperty, int bedrooms, int bathrooms, int parkingSpaces,
                                   ArrayList<String> equipmentList,boolean hasBasement, boolean hasLoft, SunExposure sunExposure,
                                   int area, City location, int cityCentreDistance, float commission, float price, ArrayList photographs, String agentName){
        RegisterEmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

        // get the employee corresponding to the agent email
        String emailAdress = null;
        pt.ipp.isep.dei.esoft.project.domain.model.Employee agent = new pt.ipp.isep.dei.esoft.project.domain.model.Employee("john",123123123,123123123,"address","e@mail.address",1231231230,Role.AGENT,Agency.AGENCY1);
        //Employee agent = employeeRepository.findByEmail(emailAdress);

        //agentName = String.valueOf(authenticationController.getCurrentSession().getUserName());

        // agent = employeeRepository.getUserByEmail(agentName);

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


    /**
     * Get city city.
     *
     * @param city the city
     * @return the city
     */
    public City getCity (String city){
        return cityRepository.findByName(city);
    }

    /**
     * Gets sun exposure as list.
     *
     * @return the sun exposure as list
     */
    public List<SunExposure> getSunExposureAsList () {
        return Arrays.stream(SunExposure.values()).toList();
    }

    /**
     * Gets type of property as list.
     *
     * @return the type of property as list
     */
    public List<TypeOfProperty> getTypeOfPropertyAsList () {
        return Arrays.stream(TypeOfProperty.values()).toList();
    }

    /**
     * Gets type of business as list.
     *
     * @return the type of business as list
     */
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


