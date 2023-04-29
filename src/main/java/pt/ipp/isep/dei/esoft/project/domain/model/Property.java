package pt.ipp.isep.dei.esoft.project.domain.model;

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

        this.area = setArea(area);
        this.cityCentreDistance = setCityCentreDistance(cityCentreDistance);
        this.location = location;
        this.photographs = setPhotographs(photographs);
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

    public City getLocation() {
        return location;
    }

    public float getCityCentreDistance() {
        return cityCentreDistance;
    }

    public ArrayList<String> getPhotographs() {
        return photographs;
    }

    public int getNumberOfBedrooms(){ return -1; }


    public float setArea(float area) {

        if (area<=0){
            throw new IllegalArgumentException("Please insert an area >0");
        }
        return area;
    }

    public void setLocation(City location) {
        this.location = location;
    }


    public float setCityCentreDistance(float cityCentreDistance) {
        if (cityCentreDistance<=0){
            throw new IllegalArgumentException("Please insert a distance >0");
        }
        return cityCentreDistance;
    }

    public ArrayList<String> setPhotographs(ArrayList<String> photographs) {
        if (photographs.isEmpty() && photographs.size()>30){
            throw new IllegalArgumentException("Please insert at least 1 photograph and a maximum of 30 photographs");
        }else if (photographs == null) {
            throw new NullPointerException("You need to insert at least 1 photograph");
        }
        return photographs;
    }



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
