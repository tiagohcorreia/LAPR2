package app.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class Property {
    private float area;
    City address;
    float cityCentreDistance;
    private ArrayList<String> photographs;


    //Constructor

    public Property(float area, float cityCentreDistance, City address, ArrayList<String> photographs) {
        this.area = area;
        this.cityCentreDistance = cityCentreDistance;
        this.address = address;
        this.photographs = photographs;
    }
    // Getters and Setters

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public City getAddress() {
        return address;
    }

    public void setAddress(City location) {
        this.address = location;
    }

    public float getCityCentreDistance() {
        return cityCentreDistance;
    }

    public void setCityCentreDistance(float cityCentreDistance) {
        this.cityCentreDistance = cityCentreDistance;
    }

    public ArrayList<String> getPhotographs() {
        return photographs;
    }

    public void setPhotographs(ArrayList<String> photographs) {
        this.photographs = photographs;
    }

    //ToString()
    @Override
    public String toString() {
        return "Property{" +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", cityCentreDistance=" + cityCentreDistance +
                ", photographs=" + photographs +
                '}';
    }
    //equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Float.compare(property.area, area) == 0 && Float.compare(property.cityCentreDistance, cityCentreDistance) == 0 && Objects.equals(address, property.address) && Objects.equals(photographs, property.photographs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, address, cityCentreDistance, photographs);
    }
}
