package pt.ipp.isep.dei.esoft.project.domain.model;

/**
 * The type City.
 */
public class City {
    private String name;

    /**
     * Instantiates a new City.
     *
     * @param name the name
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new City.
     */
    public City() {
        this.name = "Default City";
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

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        City city = (City) otherObject;
        return name.equals(city.name);
    }

}