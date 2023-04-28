package app.domain.model;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Property {

    private static final float DEFAULT_AREA = 1;
    private static final City DEFAULT_LOCATION = new City();
    private static final float DEFAULT_CITY_CENTER_DISTANCE = 10;
    private static final ArrayList<String> DEFAULT_PHOTOGRAPHS = new ArrayList<>();

    private float area;
    City location;
    float cityCentreDistance;
    private ArrayList<String> photographs;


    //Full constructor
    public Property(float area, City location, float cityCentreDistance, ArrayList<String> photographs) {

        this.area = area;
        this.cityCentreDistance = cityCentreDistance;
        this.location = location;
        this.photographs = photographs;
    }

    //Default constructor
    public Property(){
        this.area = DEFAULT_AREA;
        this.location = DEFAULT_LOCATION;
        this.cityCentreDistance = DEFAULT_CITY_CENTER_DISTANCE;
        this.photographs = DEFAULT_PHOTOGRAPHS;
    }

    //Copy constructor
    public Property(Property anotherProperty){
        this.setArea(anotherProperty.getArea());
        this.setLocation(anotherProperty.getLocation());
        this.setCityCentreDistance(anotherProperty.getCityCentreDistance());
        this.setPhotographs(anotherProperty.getPhotographs());
    }

    // Getters and Setters

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public City getLocation() {
        return location;
    }

    public void setLocation(City location) {
        this.location = location;
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

    public int getNumberOfBedrooms(){ return -1; }

    //ToString()
    @Override
    public String toString() {
        return " area=" + area +
                ", address='" + location + '\'' +
                ", cityCentreDistance=" + cityCentreDistance +
                ", photographs=" + photographs;
    }
    //equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Float.compare(property.area, area) == 0 && Float.compare(property.cityCentreDistance, cityCentreDistance) == 0 && Objects.equals(location, property.location) && Objects.equals(photographs, property.photographs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, location, cityCentreDistance, photographs);
    }
}
