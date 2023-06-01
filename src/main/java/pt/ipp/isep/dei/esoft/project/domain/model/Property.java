package pt.ipp.isep.dei.esoft.project.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


/**
 * The type Property.
 */
public class Property implements Serializable {

    private static final float DEFAULT_AREA = 1;
    private static final Location DEFAULT_LOCATION = new Location(0,"Street Zero", new City("City Zero"), 0);
    private static final float DEFAULT_CITY_CENTER_DISTANCE = 10;
    private static final ArrayList<String> DEFAULT_PHOTOGRAPHS = new ArrayList<>();

    private String id;
    private float area;
    /**
     * The Location.
     */
    private final Location location;
    /**
     * The City centre distance.
     */
    private float cityCentreDistance;
    private ArrayList<String> photographs;


    /**
     * Instantiates a new Property.
     *
     * @param area               the area
     * @param location           the location
     * @param cityCentreDistance the city centre distance
     * @param photographs        the photographs
     */
//Full constructor
    public Property(float area, Location location, float cityCentreDistance, ArrayList<String> photographs) {

        this.area = setArea(area);
        this.cityCentreDistance = setCityCentreDistance(cityCentreDistance);
        this.location = location;
        this.photographs = setPhotographs(photographs);
    }

    public Property(String id, float area, Location location, float cityCentreDistance, ArrayList<String> photographs) {
        this.id = id;
        this.area = area;
        this.location = location;
        this.cityCentreDistance = cityCentreDistance;
        this.photographs = photographs;
    }

    /**
     * Instantiates a new Property.
     */
//Default constructor
    public Property(){
        this.area = DEFAULT_AREA;
        this.location = DEFAULT_LOCATION;
        this.cityCentreDistance = DEFAULT_CITY_CENTER_DISTANCE;
        this.photographs = DEFAULT_PHOTOGRAPHS;
    }

    /**
     * Instantiates a new Property.
     *
     * @param anotherProperty the another property
     */
//Copy constructor
    public Property(Property anotherProperty){
        location = anotherProperty.getLocation();
        this.setArea(anotherProperty.getArea());
        //this.setLocation(anotherProperty.getLocation());
        this.setCityCentreDistance(anotherProperty.getCityCentreDistance());
        this.setPhotographs(anotherProperty.getPhotographs());
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    /**
     * Gets area.
     *
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets city centre distance.
     *
     * @return the city centre distance
     */
    public float getCityCentreDistance() {
        return cityCentreDistance;
    }

    /**
     * Gets photographs.
     *
     * @return the photographs
     */
    public ArrayList<String> getPhotographs() {
        return photographs;
    }

    /**
     * Get number of bedrooms int.
     *
     * @return the int
     */
    public int getNumberOfBedrooms(){ return 0; }


    /**
     * Sets area.
     *
     * @param area the area
     * @return the area
     */
    public float setArea(float area) {

        if (area<=0){
            throw new IllegalArgumentException("Please insert an area >0");
        }
        return area;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    /*public void setLocation(Location location) {
        this.location = location;
    }*/


    /**
     * Sets city centre distance.
     *
     * @param cityCentreDistance the city centre distance
     * @return the city centre distance
     */
    public float setCityCentreDistance(float cityCentreDistance) {
        if (cityCentreDistance<=0){
            throw new IllegalArgumentException("Please insert a distance >0");
        }
        return cityCentreDistance;
    }

    /**
     * Sets photographs.
     *
     * @param photographs the photographs
     * @return the photographs
     */
    public ArrayList<String> setPhotographs(ArrayList<String> photographs) {
        if (photographs.size()>30){
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
