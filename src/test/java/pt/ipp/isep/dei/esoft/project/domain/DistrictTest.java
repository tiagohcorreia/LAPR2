package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type District test.
 */
class DistrictTest {
    private District district;
    private List<City> cities;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        cities = new ArrayList<>(Arrays.asList(new City("New York"), new City("Los Angeles")));
        district = new District("Central", cities);
    }

    /**
     * Gets name.
     */
    @Test
    void getName() {
        assertEquals("Central", district.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        district.setName("North");
        assertEquals("North", district.getName());
    }

    /**
     * Gets cities.
     */
    @Test
    void getCities() {
        assertEquals(cities, district.getCities());
    }

    /**
     * Sets cities.
     */
    @Test
    void setCities() {
        List<City> newCities = new ArrayList<>(Arrays.asList(new City("Chicago"), new City("Houston")));
        district.setCities(newCities);
        assertEquals(newCities, district.getCities());
    }

    /**
     * Test to string.
     */
    /*@Test
    void testToString() {
        assertEquals("District{name='Central', cities=" + cities + "}", district.toString());
    }*/

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        District anotherDistrict = new District("Central", cities);
        assertEquals(district, anotherDistrict);

        anotherDistrict.setName("South");
        assertNotEquals(district, anotherDistrict);
    }
}