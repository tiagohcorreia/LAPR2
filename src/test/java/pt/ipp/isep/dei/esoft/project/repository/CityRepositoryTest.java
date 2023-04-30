package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type City repository test.
 */
class CityRepositoryTest {
    private CityRepository cityRepository;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        cityRepository = new CityRepository();
    }

    /**
     * Save.
     */
    @Test
    void save() {
        City newYork = new City("New York");
        cityRepository.save(newYork);

        City foundCity = cityRepository.findByName("New York");
        assertEquals(newYork, foundCity);
    }

    /**
     * Find by name.
     */
    @Test
    void findByName() {
        City newYork = new City("New York");
        cityRepository.save(newYork);

        City foundCity = cityRepository.findByName("New York");
        assertEquals(newYork, foundCity);
    }

    /**
     * Find by name not found.
     */
    @Test
    void findByNameNotFound() {
        City foundCity = cityRepository.findByName("Nonexistent City");
        assertNull(foundCity);
    }

    /**
     * Find all.
     */
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
