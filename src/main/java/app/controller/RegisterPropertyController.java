package app.controller;

import app.domain.model.*;
import app.domain.repository.*;
import app.domain.shared.SunExposure;
import app.domain.shared.TypeOfBusiness;
import app.domain.shared.TypeOfProperty;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterPropertyController {
    private AnnouncementRepository announcementRepository;
    Repositories repositories = Repositories.getInstance();
    RegisterEmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    StateRepository stateRepository=repositories.getStateRepository();
    DistrictRepository districtRepository=repositories.getDistrictRepository();
    CityRepository cityRepository=repositories.getCityRepository();
    public RegisterPropertyController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public void createAnnouncement(TypeOfBusiness sellOrRent, int posTypeOfProperty, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                               ArrayList<String> equipmentList,boolean hasBasement, boolean hasInhabitalLoft, SunExposure sunExposure,
                               int area, City location, int cityCentreDistance, float price, ArrayList<String> photographs, Employee agent) {

        if (posTypeOfProperty==2){
            Apartment property= new Apartment(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        } else if (posTypeOfProperty==1) {
            House property= new House(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList,hasBasement,hasInhabitalLoft,sunExposure);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }else {
            Land property= new Land(area,location,cityCentreDistance,photographs);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }

    }
    public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeRepository.getEmployeeList()) {

            if(employee.getRole().equals(Role.AGENT)) {
                agent.add(employee);
            }
        }
        return agent;

    }
    public Employee getEmployee(String name){
        return employeeRepository.getEmployee(name);
    }

    public City getCity(String city){
        return cityRepository.findByName(city);
    }

    public List<SunExposure> getSunExposureAsList() {
        return Arrays.stream(SunExposure.values()).toList();
    }

    public List<TypeOfProperty> getTypeOfPropertyAsList() {
        return Arrays.stream(TypeOfProperty.values()).toList();
    }

    public List<TypeOfBusiness> getTypeOfBusinessAsList() {
        return Arrays.stream(TypeOfBusiness.values()).toList();
    }
}
