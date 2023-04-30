package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type City test.
 */
class CityTest {
    private City city;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        city = new City("Chicago");
    }

    /**
     * Gets name.
     */
    @Test
    void getName() {
        assertEquals("Chicago", city.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        city.setName("New York");
        assertEquals("New York", city.getName());
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        assertEquals("City{name='Chicago'}", city.toString());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        City anotherCity = new City("Chicago");
        assertEquals(city, anotherCity);

        anotherCity.setName("New York");
        assertNotEquals(city, anotherCity);
    }
}
