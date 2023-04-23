package app.controller;

import app.domain.model.City;
import app.domain.repository.CityRepository;

import java.util.List;

public class CityController {
    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void addCity(String name) {
        City city = new City(name);
        cityRepository.save(city);
    }

    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}

