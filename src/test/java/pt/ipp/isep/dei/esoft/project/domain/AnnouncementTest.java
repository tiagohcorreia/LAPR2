package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Announcement test.
 */
class AnnouncementTest {

    /**
     * Ensure announcement is created.
     */
    @Test
    void ensureAnnouncementIsCreated() {
        // Arrange
        Date date = new Date();
        AnnouncementStatus announcementStatus = AnnouncementStatus.PUBLISHED;
        float price = 1000.0f;
        float commission = 50.0f;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Property();

        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);

        // Act
        Announcement announcement = new Announcement(date, announcementStatus, price, commission, typeOfBusiness, property, agent);

        // Assert
        Assertions.assertEquals(date, announcement.getDate());
        Assertions.assertEquals(price, announcement.getPrice());
        Assertions.assertEquals(commission, announcement.getCommission());
        Assertions.assertEquals(typeOfBusiness, announcement.getTypeOfBusiness());
        Assertions.assertEquals(property, announcement.getProperty());
        Assertions.assertEquals(agent, announcement.getAgent());
    }

    /**
     * Ensure default announcement is created.
     */
    @Test
    void ensureDefaultAnnouncementIsCreated() {
        // Act
        Announcement announcement = new Announcement();

        // Assert
        Assertions.assertEquals(AnnouncementStatus.PENDENT,announcement.getStatus());
        Assertions.assertEquals(0.0f, announcement.getPrice());
        Assertions.assertEquals(0.0f, announcement.getCommission());
        Assertions.assertEquals(TypeOfBusiness.SELL, announcement.getTypeOfBusiness());
        Assertions.assertNull(announcement.getProperty());
        Assertions.assertNull(announcement.getAgent());
    }


    /**
     * Ensure throw exception when setting negative price.
     */
    @Test
    void EnsureThrowExceptionWhenSettingNegativePrice() {
        // Arrange
        Announcement announcement = new Announcement();

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setPrice(-1000.0f));
    }

    /**
     * Ensure throw exception when setting negative commission.
     */
    @Test
    void ensureThrowExceptionWhenSettingNegativeCommission() {
        // Arrange
        Announcement announcement = new Announcement();

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setCommission(-50.0f));
    }




}
