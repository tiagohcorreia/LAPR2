package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.CityController;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * The type City controller test.
 */
class CityControllerTest {
    private CityRepository cityRepository;
    private CityController cityController;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        cityRepository = Mockito.mock(CityRepository.class);
        cityController = new CityController(cityRepository);
    }

    /**
     * Add city.
     */
    @Test
    void addCity() {
        String cityName = "Los Angeles";
        cityController.addCity(cityName);

        City city = new City(cityName);
        verify(cityRepository, times(1)).save(city);
    }

    /**
     * Find city by name.
     */
    @Test
    void findCityByName() {
        City newYork = new City("New York");
        when(cityRepository.findByName("New York")).thenReturn(newYork);

        City foundCity = cityController.findCityByName("New York");
        assertEquals(newYork, foundCity);
    }

    /**
     * Gets all cities.
     */
    @Test
    void getAllCities() {
        List<City> cities = new ArrayList<>(Arrays.asList(
                new City("New York"),
                new City("Los Angeles"),
                new City("Chicago")
        ));
        when(cityRepository.findAll()).thenReturn(cities);

        List<City> allCities = cityController.getAllCities();
        assertEquals(cities, allCities);
    }
}
