package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Announcement test.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static pt.ipp.isep.dei.esoft.project.domain.EmployeeTwoTest.branch;

public class AnnouncementTest {

    @Test
    public void ensureCommissionCannotBeNegative() {
        Announcement announcement = new Announcement();
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setCommission(-100));
    }

    @Test
    public void ensurePriceCannotBeNegative() {
        Announcement announcement = new Announcement();
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setPrice(-200));
    }

    @Test
    public void ensureStatusIsSetCorrectly() {
        Announcement announcement = new Announcement();
        announcement.setStatus(AnnouncementStatus.PUBLISHED);
        Assertions.assertEquals(AnnouncementStatus.PUBLISHED, announcement.getStatus());
    }

    @Test
    public void ensureDateIsSetCorrectly() {
        LocalDate date = LocalDate.of(2023, 4, 27);
        Announcement announcement = new Announcement();
        announcement.setDate(date);
        Assertions.assertEquals(date, announcement.getDate());
    }

    @Test
    public void ensureTypeOfBusinessIsSetCorrectly() {
        Announcement announcement = new Announcement();
        announcement.setTypeOfBusiness(TypeOfBusiness.RENT);
        Assertions.assertEquals(TypeOfBusiness.RENT, announcement.getTypeOfBusiness());
    }

    @Test
    public void ensurePropertyIsSetCorrectly() {
        Property property = new Apartment(1000, new Location(0, "violets",new City("porto"),  12345 ),100,new ArrayList<>(),5,5,5,new ArrayList<>());
        Announcement announcement = new Announcement();
        announcement.setProperty(property);
        Assertions.assertEquals(property, announcement.getProperty());
    }

    @Test
    public void ensureAgentIsSetCorrectly() {
        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", String.valueOf(1234567890), Role.AGENT, branch);
        Announcement announcement = new Announcement();
        announcement.setAgent(agent);
        Assertions.assertEquals(agent, announcement.getAgent());
    }

    @Test
    public void ensureOwnerIsSetCorrectly() {
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement();
        announcement.setOwner(owner);
        Assertions.assertEquals(owner, announcement.getOwner());
    }

    @Test
    public void ensureNumberOfMonthsRentIsSetCorrectly() {
        Announcement announcement = new Announcement();
        announcement.setNumberOfMonthsRent(12);
        Assertions.assertEquals(12, announcement.getNumberOfMonthsRent());
    }

    @Test
    public void ensureAnnouncementAsStringReturnsExpectedString() {
        LocalDate date = LocalDate.of(2024, 4, 27);
        AnnouncementStatus status = AnnouncementStatus.PUBLISHED;
        float price = 100000;
        float commission = 5000;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Land(1000, new Location(0, "violets", new City("porto"), 12345), 1000, new ArrayList<>());
        Branch branch = new Branch();
        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", String.valueOf(1234567890), Role.AGENT, branch);
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement(date, status, price, commission, typeOfBusiness, property, agent, owner);

        String expectedString = "2024-04-27\tSELL\tLand\t100000.0\tDoor Number:0\tStreet:violets\tCity:porto\tZip Code:12345\t1000.0\t1000.0\t0\t[]\temployee";
        Assertions.assertEquals(expectedString, announcement.getAnnouncementAsString());
    }

    @Test
    public void ensureAnnouncementIsCreated() {

        Location location = new Location(0, "violets", new City("porto"), 12345);
        Branch branch = new Branch();
        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", "1234567890", Role.AGENT, branch);
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);
        LocalDate date = LocalDate.of(2024, 4, 27);
        AnnouncementStatus status = AnnouncementStatus.PUBLISHED;
        float price = 100000;
        float commission = 5000;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Land(1000, location, 1000, new ArrayList<>());

        Announcement announcement = new Announcement(date, status, price, commission, typeOfBusiness, property, agent, owner);

        assertNotNull(announcement);
    }



}
