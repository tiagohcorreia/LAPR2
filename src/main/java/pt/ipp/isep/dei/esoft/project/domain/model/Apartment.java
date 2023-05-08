package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.shared.InhabitableProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Apartment.
 */
public class Apartment extends Property implements InhabitableProperty {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    /**
     * Instantiates a new Apartment.
     *
     * @param area                  the area
     * @param location              the location
     * @param cityCentreDistance    the city centre distance
     * @param photographs           the photographs
     * @param numberOfBedrooms      the number of bedrooms
     * @param numberOfBathrooms     the number of bathrooms
     * @param numberOfParkingSpaces the number of parking spaces
     * @param equipment             the equipment
     */
//Constructor
    public Apartment(float area, City location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment) {
        super(area, location, cityCentreDistance, photographs);
        this.numberOfBedrooms=numberOfBedrooms;
        this.numberOfBathrooms=numberOfBathrooms;
        this.numberOfParkingSpaces=numberOfParkingSpaces;
        this.equipment=equipment;

    }

    //Getters and Setters

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }


    /**
     * Gets number of bathrooms.
     *
     * @return the number of bathrooms
     */
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }


    /**
     * Gets number of parking spaces.
     *
     * @return the number of parking spaces
     */
    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }


    /**
     * Gets equipment.
     *
     * @return the equipment
     */
    public ArrayList<String> getEquipment() {
        return equipment;
    }

    /**
     * Sets number of bedrooms.
     *
     * @param numberOfBedrooms the number of bedrooms
     * @return the number of bedrooms
     */
    public int setNumberOfBedrooms(int numberOfBedrooms) {
        if (numberOfBedrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBedrooms;
    }

    /**
     * Sets number of bathrooms.
     *
     * @param numberOfBathrooms the number of bathrooms
     * @return the number of bathrooms
     */
    public int setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBathrooms;
    }

    /**
     * Sets number of parking spaces.
     *
     * @param numberOfParkingSpaces the number of parking spaces
     * @return the number of parking spaces
     */
    public int setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        if (numberOfParkingSpaces<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfParkingSpaces;
    }

    /**
     * Sets equipment.
     *
     * @param equipment the equipment
     * @return the equipment
     */
    public List<String> setEquipment(List<String> equipment) {
        if (equipment == null) {
            throw new NullPointerException("You need to insert at least 1 equipment.");
        }
        return equipment;
    }

    //ToString

    @Override
    public String toString() {
        return "Apartment{" +super.toString()+
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                '}';
    }
}
