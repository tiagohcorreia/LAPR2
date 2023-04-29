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

class DistrictTest {
    private District district;
    private List<City> cities;

    @BeforeEach
    void setUp() {
        cities = new ArrayList<>(Arrays.asList(new City("New York"), new City("Los Angeles")));
        district = new District("Central", cities);
    }

    @Test
    void getName() {
        assertEquals("Central", district.getName());
    }

    @Test
    void setName() {
        district.setName("North");
        assertEquals("North", district.getName());
    }

    @Test
    void getCities() {
        assertEquals(cities, district.getCities());
    }

    @Test
    void setCities() {
        List<City> newCities = new ArrayList<>(Arrays.asList(new City("Chicago"), new City("Houston")));
        district.setCities(newCities);
        assertEquals(newCities, district.getCities());
    }

    @Test
    void testToString() {
        assertEquals("District{name='Central', cities=" + cities + "}", district.toString());
    }

    @Test
    void testEquals() {
        District anotherDistrict = new District("Central", cities);
        assertEquals(district, anotherDistrict);

        anotherDistrict.setName("South");
        assertNotEquals(district, anotherDistrict);
    }
}