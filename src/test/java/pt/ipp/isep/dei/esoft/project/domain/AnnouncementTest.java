package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class AnnouncementTest {

    @Test
    void ensureAnnouncementIsCreated() {
        // Arrange
        boolean visible = true;
        float price = 1000.0f;
        float commission = 50.0f;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Property();

        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);

        // Act
        Announcement announcement = new Announcement(visible, price, commission, typeOfBusiness, property, agent);

        // Assert
        Assertions.assertEquals(visible, announcement.isVisible());
        Assertions.assertEquals(price, announcement.getPrice());
        Assertions.assertEquals(commission, announcement.getCommission());
        Assertions.assertEquals(typeOfBusiness, announcement.getTypeOfBusiness());
        Assertions.assertEquals(property, announcement.getProperty());
        Assertions.assertEquals(agent, announcement.getAgent());
    }

    @Test
    void ensureDefaultAnnouncementIsCreated() {
        // Act
        Announcement announcement = new Announcement();

        // Assert
        Assertions.assertFalse(announcement.isVisible());
        Assertions.assertEquals(0.0f, announcement.getPrice());
        Assertions.assertEquals(0.0f, announcement.getCommission());
        Assertions.assertEquals(TypeOfBusiness.SELL, announcement.getTypeOfBusiness());
        Assertions.assertNull(announcement.getProperty());
        Assertions.assertNull(announcement.getAgent());
    }


    @Test
    void EnsureThrowExceptionWhenSettingNegativePrice() {
        // Arrange
        Announcement announcement = new Announcement();

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setPrice(-1000.0f));
    }

    @Test
    void ensureThrowExceptionWhenSettingNegativeCommission() {
        // Arrange
        Announcement announcement = new Announcement();

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setCommission(-50.0f));
    }




}
