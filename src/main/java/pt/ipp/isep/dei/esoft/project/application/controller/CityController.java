package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.repository.CityRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

/**
 * The type City controller.
 */
public class CityController {
    private CityRepository cityRepository = Repositories.getInstance().getCityRepository();
    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();


    /**
     * Instantiates a new City controller.
     *
     * @param cityRepository the city repository
     */
    public CityController(CityRepository cityRepository) {

        //this.cityRepository = cityRepository;
    }

    /**
     * Add city.
     *
     * @param name the name
     */
    public void addCity(String name) {
        City city = new City(name);
        cityRepository.save(city);
        cityRepository.writeObject();
    }

    /**
     * Find city by name city.
     *
     * @param name the name
     * @return the city
     */
    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

    /**
     * Gets all cities.
     *
     * @return the all cities
     */
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}

