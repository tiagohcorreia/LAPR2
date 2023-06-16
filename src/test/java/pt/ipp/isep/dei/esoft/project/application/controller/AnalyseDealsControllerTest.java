package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyseDealsControllerTest {
    Repositories repositories = Repositories.getInstance();
    PurchaseOrderRepository purchaseOrderRepository= repositories.getPurchaseOrderRepository();
    EmployeeRepository employeeRepository= repositories.getInstance().getEmployeeRepository();
    AnalyseDealsController analyseDealsController;
    City city;
    Property apartment;
    Property house;
    Property land;
    AnnouncementDTO DTOHouse;
    AnnouncementDTO DTOApartment;
    AnnouncementDTO DTOLand;
    @BeforeEach
    void setup(){
        analyseDealsController = new AnalyseDealsController();
        ArrayList<String> photographs = new ArrayList<String>();
        Branch branch = new Branch();
        photographs.add("photo1");
        city = new City("Porto");
        Location location =new Location("asdas",city,12345);
        ArrayList<String> equipment= new ArrayList<>();
        equipment.add("equipment1");
        house = new House(13,location,1232,photographs,2,1,1,equipment,true,true, SunExposure.NORTH);
        apartment=new Apartment(1243,location,12,photographs,2,1,1,equipment);
        land=new Land(123, location, 123, photographs);
       Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        DTOHouse = new AnnouncementDTO(1235, TypeOfBusiness.SELL, house, e1);
        DTOApartment = new AnnouncementDTO(1234, TypeOfBusiness.SELL, apartment, e1);
        DTOLand = new AnnouncementDTO(123, TypeOfBusiness.SELL, land, e1);

        pt.ipp.isep.dei.esoft.project.domain.model.Order orderHouse = new Order(123,DTOHouse);
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderApartment = new Order(123,DTOApartment);
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderLand = new Order(123,DTOLand);
        purchaseOrderRepository.getAll().add(orderHouse);
        purchaseOrderRepository.getAll().add(orderApartment);
        purchaseOrderRepository.getAll().add(orderLand);
    }
    /*
    @Test
    void getApartmentsAndHouses() {
        List<Order> expectedHouseAndApartmentsList = new ArrayList<>();
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderHouse1 = new Order(123,DTOHouse);
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderApartment1 = new Order(123,DTOApartment);
        expectedHouseAndApartmentsList.add(orderHouse1);
        expectedHouseAndApartmentsList.add(orderApartment1);

        List<Order> result= analyseDealsController.getApartmentsAndHouses();

        assertEquals(expectedHouseAndApartmentsList, result);


    }*/
}