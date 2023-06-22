package pt.ipp.isep.dei.esoft.project.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderToBuyPropertyRepositoryTest {

    PlaceOrderToBuyPropertyRepository placeOrderToBuyPropertyRepository = new PlaceOrderToBuyPropertyRepository();
    Schedule schedule;
    Property property;
    Announcement announcement;
    AnnouncementDTO announcementDTO;

    @BeforeEach
    void setup() {

        Branch branch = new Branch();

        ArrayList<String> photographs = new ArrayList<String>();
        photographs.add("photo1");

        City city = new City("Porto");

        LocalDate day = LocalDate.of(2023, 12, 10);
        LocalTime beginHour = LocalTime.of(12, 30, 0);
        LocalTime endHour = LocalTime.of(13, 40, 0);

        property = new Land(123, new Location(), 123, photographs);

        pt.ipp.isep.dei.esoft.project.domain.model.Employee e1 = new pt.ipp.isep.dei.esoft.project.domain.model.Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);

        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e1, owner);
        AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e1);
    }

//    @Disabled
//    @DisplayName("Ensure Duplicate Order Fails")
//    @Test
//    void EnsureDuplicateOrderFails() {
//
//        assertThrows(DuplicateDataException.class, () -> {
//
//            boolean status = false;
//
//            Order o1 = new Order(123, announcementDTO, status);
//
//            placeOrderToBuyPropertyRepository.saveOrder(o1);
//            placeOrderToBuyPropertyRepository.saveOrder(o1);
//        });
//    }


    /*@Test
    void EnsureValidateWorks() {

        boolean status = false;
        Order o2 = new Order(12, announcementDTO, status);
        assertTrue(placeOrderToBuyPropertyRepository.validateOrder(o2));
    }*/


    @Test
    void EnsureAddOrderWorks() {

        boolean status = false;
        Order o3 = new Order(1234, announcementDTO, status);
        assertTrue(placeOrderToBuyPropertyRepository.addOrder(o3));
    }


    /*@Test
    void EnsureSaveWorks() {

        boolean status = false;
        Order o4 = new Order(12345, announcementDTO, status);
        assertTrue(placeOrderToBuyPropertyRepository.saveOrder(o4));
    }*/
}