package pt.ipp.isep.dei.esoft.project.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    /*private AnnouncementDTO announcementDTO;
    private Order order1;*/

    /*@AfterEach
    void createOrder() {
        AnnouncementDTO announcementDTO = new AnnouncementDTO();
        Order order1 = new Order(123, announcementDTO);
    }*/

    /*@DisplayName("Ensure adding a negative order amount fails")
    @Test
    void EnsureAddingNegativeOrderAmountFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            order1.setOrderAmount(-123);

        });
    }
*/

    @DisplayName("Ensure adding a negative order amount fails")
    @Test
    void EnsureAddingNegativeOrderAmountFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            Order order1 = new Order(123, announcementDTO);
            order1.setOrderAmount(-123);
        });
    }

}