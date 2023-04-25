package app.domain.model;

import java.util.List;


public class District {
    private String name;
    private List<City> cities;

    public District(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        District district = (District) otherObject;
        return name.equals(district.name);
    }
}
