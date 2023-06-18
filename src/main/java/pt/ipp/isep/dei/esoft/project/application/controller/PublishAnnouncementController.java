package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.List;

import static pt.ipp.isep.dei.esoft.project.domain.model.Announcement.createProperty;

/**
 * The type Publish announcement controller.
 */
public class PublishAnnouncementController {

    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();

    private AuthenticationController authenticationController=new AuthenticationController();

    /**
     * The Employee repository.
     */
    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
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
    ClientRepository clientRepository = repositories.getInstance().getClientRepository();

    /**
     * Create announcement.
     *
     * @param date
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
    public void createAnnouncement(LocalDate date, TypeOfBusiness sellOrRent, int posTypeOfProperty, int bedrooms, int bathrooms, int parkingSpaces,
                                   ArrayList<String> equipmentList, boolean hasBasement, boolean hasLoft, SunExposure sunExposure,
                                   int area, Location location, int cityCentreDistance, float commission, float price, ArrayList photographs, Employee agentName, Client owner, int rentalMonths ) {


        // get the employee corresponding to the agent email
        //String emailAdress = null;
        // Branch branch = new Branch();
        //pt.ipp.isep.dei.esoft.project.domain.model.Employee agent = new pt.ipp.isep.dei.esoft.project.domain.model.Employee("john",123123123,123123123,"address","e@mail.address","1231231230",Role.AGENT,branch);


        if (sellOrRent == TypeOfBusiness.SELL) {
            Property property = createProperty(posTypeOfProperty, area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
            Announcement announcement = new Announcement(date, AnnouncementStatus.PUBLISHED, commission, price, sellOrRent, property, agentName, owner);
            this.announcementRepository.createAnnouncement(announcement);
            this.announcementRepository.writeObject();

        } else if (sellOrRent == TypeOfBusiness.RENT) {
            if (rentalMonths != 0 && rentalMonths > 0) {

                Property property = createProperty(posTypeOfProperty, area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
                Announcement announcement = new Announcement(date, AnnouncementStatus.PUBLISHED, commission, price, sellOrRent, property, agentName, owner, rentalMonths);
                this.announcementRepository.createAnnouncement(announcement);
                this.announcementRepository.writeObject();

            }
        }
    }

    private Property createProperty(int posTypeOfProperty, int area, Location location, int cityCentreDistance, ArrayList photographs, int bedrooms, int bathrooms,
                                    int parkingSpaces, ArrayList<String> equipmentList, boolean hasBasement, boolean hasLoft, SunExposure sunExposure) {
        Property property;
        if (posTypeOfProperty == 2) {
            property = new Apartment(area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList);
        } else if (posTypeOfProperty == 1) {
            property = new House(area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
        } else {
            property = new Land(area, location, cityCentreDistance, photographs);
        }
        return property;
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
    public List<City> getCityList() {

        List<City> cityList = cityRepository.findAll();
        return cityList;
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

  /*public String getAgentName(){
        return String.valueOf(authenticationRepository.getCurrentUserSession().getUserName());
   }

   public Employee getAgentName() {
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        String userEmail = userSession.getUserId().getEmail();
        if (userSession != null) {
            return employeeRepository.findByEmail(userEmail);
        }
        throw new IllegalStateException("Agente correspondente ao email não encontrado.");

    } */

   /* public String getCurrentAgent() {
        pt.isep.lei.esoft.auth.UserSession userSession = authenticationRepository.getCurrentUserSession();

        if (userSession != null && userSession.getUserRoles() != null) {
            List<UserRoleDTO> userRoles = userSession.getUserRoles();

            for (UserRoleDTO userRole : userRoles) {
                if ("AGENT".equals(userRole.getId())) {
                    return userSession.getUserName();
                }
            }
        }*/



    public Employee getCurrentAgent() {

        pt.ipp.isep.dei.esoft.project.application.session.UserSession userSession = authenticationController.getCurrentSession();
        String agentEmail= String.valueOf(userSession.getUserEmail());
        Employee agent= employeeRepository.findByEmail(agentEmail);

        return agent;
    }


    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


}


