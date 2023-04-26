package app.controller;

import app.domain.model.Employee;
import app.domain.repository.RegisterEmployeeRepository;


import java.util.ArrayList;
import java.util.List;

public class RegisterPropertyController {
    public void createProperty(String sellOrRent, String typeProperty, int bedrooms, int bathrooms, int parking,
                               ArrayList<String> equipmentList, String basement, String inhabitalLoft, String sunExposure,
                               int area, String location, int centreDistance, double price, ArrayList<String> photographs, Employee agent) {


    }
    public List<Employee> getAgent() {
        return new RegisterEmployeeRepository().getAgent();

    }
    public Employee getEmployee(String name){
        return RegisterEmployeeRepository.getEmployee(name);
    }
}
