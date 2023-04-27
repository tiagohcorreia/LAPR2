package app.controller;

import app.domain.model.*;
import app.domain.repository.AnnouncementRepository;
import app.domain.repository.RegisterEmployeeRepository;
import app.domain.repository.Repositories;


import java.util.ArrayList;
import java.util.List;

public class RegisterPropertyController {
    private AnnouncementRepository announcementRepository;
    Repositories repositories = Repositories.getInstance();
    RegisterEmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    public RegisterPropertyController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public void createAnnouncement(String sellOrRent, String typeProperty, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                               ArrayList<String> equipmentList,boolean hasBasement, boolean hasInhabitalLoft, boolean sunExposure,
                               int area, City location, int cityCentreDistance, double price, ArrayList<String> photographs, Employee agent) {

        if (typeProperty.equals("A")){
            Property property= new Apartment(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList);
            Announcement announcement= new Announcement(false,price,null ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        } else if (typeProperty.equals("H")) {
            Property property= new House(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList,hasBasement,hasInhabitalLoft,sunExposure);
            Announcement announcement= new Announcement(false,price,null ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }else {
            Property property= new Land(area,location,cityCentreDistance,photographs);
            Announcement announcement= new Announcement(false,price,null ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }

    }
    public List<Employee> getAgent() {
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
    }
}
