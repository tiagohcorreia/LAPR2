package pt.ipp.isep.dei.esoft.project.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderToBuyPropertyRepositoryTest {

    PlaceOrderToBuyPropertyRepository placeOrderToBuyPropertyRepository = new PlaceOrderToBuyPropertyRepository();

    /*@DisplayName("Ensure Duplicate Order Fails")
    @Test
    void EnsureDuplicateOrderFails() {

        assertThrows(DuplicateDataException.class, () -> {

            Branch branch = new Branch();
            Employee agent = new Employee("Employee", 987654321, 987654321, "Porto", "employee@this.app", "9876543210", Role.AGENT, branch);
            Location location = new Location();
            Property property = new Land(12, location, 12, new ArrayList<>());
            AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, agent);
            boolean status = false;

            Order o1 = new Order(123, announcementDTO, status);
            placeOrderToBuyPropertyRepository.validateOrder(o1);

            Order o2 = new Order(123, announcementDTO, status);
            placeOrderToBuyPropertyRepository.validateOrder(o2);
        });
    }
*/
}