package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * The type City repository.
 */
public class CityRepository {
    private List<City> cities = new ArrayList<>();


    /**
     * Save.
     *
     * @param city the city
     */
    public void save(City city) {
        if (cityIsValid(city)) {
            cities.add(city);
        }
    }

    /**
     * Find by name city.
     *
     * @param name the name
     * @return the city
     */
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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<City> findAll() {
        return new ArrayList<>(cities);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return cities.isEmpty();
    }
}

