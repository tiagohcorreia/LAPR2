package pt.ipp.isep.dei.esoft.project.domain;

import app.domain.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CityTest {
    private City city;

    @BeforeEach
    void setUp() {
        city = new City("Chicago");
    }

    @Test
    void getName() {
        assertEquals("Chicago", city.getName());
    }

    @Test
    void setName() {
        city.setName("New York");
        assertEquals("New York", city.getName());
    }

    @Test
    void testToString() {
        assertEquals("City{name='Chicago'}", city.toString());
    }

    @Test
    void testEquals() {
        City anotherCity = new City("Chicago");
        assertEquals(city, anotherCity);

        anotherCity.setName("New York");
        assertNotEquals(city, anotherCity);
    }
}
