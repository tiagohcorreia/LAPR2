package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Register property controller.
 */
public class RegisterPropertyController implements Serializable {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    /**
     * The Employee repository.
     */
    EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    /**
     * The State repository.
     */
    StateRepository stateRepository=repositories.getStateRepository();
    /**
     * The District repository.
     */
    DistrictRepository districtRepository=repositories.getDistrictRepository();
    /**
     * The City repository.
     */
    CityRepository cityRepository=repositories.getCityRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    ClientRepository clientRepository = repositories.getInstance().getClientRepository();
    AuthenticationController authenticationController;
    /**
     * Instantiates a new Register property controller.
     *
     * @param announcementRepository the announcement repository
     */
    public RegisterPropertyController(AnnouncementRepository announcementRepository) {
        this.employeeRepository.readObject();
    }

    /**
     * Create announcement.
     *
     * @param date
     * @param sellOrRent            the sell or rent
     * @param posTypeOfProperty     the pos type of property
     * @param numberOfBedrooms      the number of bedrooms
     * @param numberOfBathrooms     the number of bathrooms
     * @param numberOfParkingSpaces the number of parking spaces
     * @param equipmentList         the equipment list
     * @param hasBasement           the has basement
     * @param hasInhabitalLoft      the has inhabital loft
     * @param sunExposure           the sun exposure
     * @param area                  the area
     * @param location              the location
     * @param cityCentreDistance    the city centre distance
     * @param price                 the price
     * @param photographs           the photographs
     * @param agent                 the agent
     */
    public void createAnnouncement(LocalDate date, TypeOfBusiness sellOrRent, int posTypeOfProperty, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                                   ArrayList<String> equipmentList, boolean hasBasement, boolean hasInhabitalLoft, SunExposure sunExposure,
                                   int area, Location location, int cityCentreDistance, float price, ArrayList<String> photographs, Employee agent,Client owner, int rentalMonths) {
        try {
            Property property = createProperty(posTypeOfProperty, area, location, cityCentreDistance, photographs, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, equipmentList, hasBasement, hasInhabitalLoft, sunExposure);

            if (sellOrRent == TypeOfBusiness.SELL) {
                Announcement announcement = new Announcement(date,AnnouncementStatus.REQUESTED,price,0,sellOrRent,property,agent,owner);
                announcement.setAgent(agent);
                this.announcementRepository.createAnnouncement(announcement);
                this.announcementRepository.writeObject();

            } else if (sellOrRent == TypeOfBusiness.RENT) {
                if (rentalMonths != 0 && rentalMonths > 0) {
                    Announcement announcement = new Announcement(date,AnnouncementStatus.REQUESTED,price,0,sellOrRent,property,agent,owner, rentalMonths);
                    announcement.setAgent(agent);
                    this.announcementRepository.createAnnouncement(announcement);
                    this.announcementRepository.writeObject();

                }
            }
        }catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }

    private Property createProperty(int posTypeOfProperty,int area,Location location,int cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                                    ArrayList<String> equipmentList, boolean hasBasement, boolean hasInhabitalLoft, SunExposure sunExposure) {
        Property property;
        if (posTypeOfProperty==2){
             property= new Apartment(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList);

        } else if (posTypeOfProperty==1) {
            property= new House(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList,hasBasement,hasInhabitalLoft,sunExposure);

        }else {
            property= new Land(area,location,cityCentreDistance,photographs);

        }
        return property;
    }


    /**
     * Gets agent.
     *
     * @return the agent
     */
    public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeRepository.getEmployeeList()) {

            if(employee.getRole()==Role.AGENT) {
                agent.add(employee);
            }
        }
        return agent;
    }



    /**
     * Get employee employee.
     *
     * @param name the name
     * @return the employee
     */
    public Employee getEmployee(String name){
        return employeeRepository.getEmployee(name);
    }

    /**
     * Get city city.
     *
     * @param city the city
     * @return the city
     */
    public City getCity(String city){
        return cityRepository.findByName(city);
    }

    /**
     * Gets sun exposure as list.
     *
     * @return the sun exposure as list
     */
    public List<SunExposure> getSunExposureAsList() {

        return Arrays.stream(SunExposure.values()).toList();

    }

    /**
     * Gets type of property as list.
     *
     * @return the type of property as list
     */
    public List<TypeOfProperty> getTypeOfPropertyAsList() {

        return Arrays.stream(TypeOfProperty.values()).toList();

    }

    /**
     * Gets type of business as list.
     *
     * @return the type of business as list
     */
    public List<TypeOfBusiness> getTypeOfBusinessAsList() {

        return Arrays.stream(TypeOfBusiness.values()).toList();
    }

    public Client getCurrentOwner() {
        pt.isep.lei.esoft.auth.UserSession userSession = authenticationRepository.getCurrentUserSession();

            String ownerName=userSession.getUserName();
            return getOwnerByName(ownerName);

    }
    public Client getOwnerByName(String ownerName) {

        return clientRepository.findByEmail(ownerName);
    }
}
