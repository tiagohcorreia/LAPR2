package app.controller;

import app.domain.model.Employee;
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
    public void createProperty(String sellOrRent, String typeProperty, int bedrooms, int bathrooms, int parking,
                               ArrayList<String> equipmentList, String basement, String inhabitalLoft, String sunExposure,
                               int area, String location, int centreDistance, double price, ArrayList<String> photographs, Employee agent) {


    }
    public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeRepository.getEmployeeList()) {

            if(employee.getRole().equals("AGENT")) {
                agent.add(employee);
            }
        }
        return agent;

    }
    public Employee getEmployee(String name){
        return employeeRepository.getEmployee(name);
    }
}
