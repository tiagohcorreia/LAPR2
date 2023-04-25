package app.domain.repository;

import app.domain.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private List<City> cities = new ArrayList<>();


    public void save(City city) {
        if (cityIsValid(city)) {
            cities.add(city);
        }
    }

    public City findByName(String name) {
        for (City city: cities) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }

    private boolean cityIsValid(City city) {
        return city != null && !cities.contains(city);
    }

    public List<City> findAll() {
        return new ArrayList<>(cities);
    }

    public boolean isEmpty() {
        return cities.isEmpty();
    }
}

