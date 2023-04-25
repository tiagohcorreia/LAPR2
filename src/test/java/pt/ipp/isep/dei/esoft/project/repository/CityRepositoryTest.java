package pt.ipp.isep.dei.esoft.project.repository;

import app.domain.model.City;
import app.domain.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CityRepositoryTest {
    private CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        cityRepository = new CityRepository();
    }

    @Test
    void save() {
        City newYork = new City("New York");
        cityRepository.save(newYork);

        City foundCity = cityRepository.findByName("New York");
        assertEquals(newYork, foundCity);
    }

    @Test
    void findByName() {
        City newYork = new City("New York");
        cityRepository.save(newYork);

        City foundCity = cityRepository.findByName("New York");
        assertEquals(newYork, foundCity);
    }

    @Test
    void findByNameNotFound() {
        City foundCity = cityRepository.findByName("Nonexistent City");
        assertNull(foundCity);
    }

    @Test
    void findAll() {
        City newYork = new City("New York");
        City losAngeles = new City("Los Angeles");
        cityRepository.save(newYork);
        cityRepository.save(losAngeles);

        List<City> cities = cityRepository.findAll();
        assertEquals(2, cities.size());
        assertEquals(newYork, cities.get(0));
        assertEquals(losAngeles, cities.get(1));
    }
}
