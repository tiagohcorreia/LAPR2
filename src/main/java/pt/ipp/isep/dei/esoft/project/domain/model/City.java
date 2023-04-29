package pt.ipp.isep.dei.esoft.project.domain.model;

public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }
    public City() {
        this.name = "Default City";
    }


    public String getName() {
        return name;
    }

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
