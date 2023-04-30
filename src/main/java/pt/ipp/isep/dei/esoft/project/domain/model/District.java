package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.List;


/**
 * The type District.
 */
public class District {
    private String name;
    private List<City> cities;

    /**
     * Instantiates a new District.
     *
     * @param name   the name
     * @param cities the cities
     */
    public District(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets cities.
     *
     * @return the cities
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Sets cities.
     *
     * @param cities the cities
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("District: ").append(name).append("\n");
        sb.append("Cities:\n");

        if (cities.isEmpty()) {
            sb.append("No cities in this district.\n");
        } else {
            for (City city : cities) {
                sb.append("- ").append(city.getName()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        District district = (District) otherObject;
        return name.equals(district.name);
    }
}
