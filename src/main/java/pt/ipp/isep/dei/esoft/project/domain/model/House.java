package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.shared.MultiStoryInhabitableProperty;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;

import java.util.ArrayList;

/**
 * The type House.
 */
public class House extends Property implements MultiStoryInhabitableProperty {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    private boolean hasBasement;
    private boolean hasInhabitableLoft;
    /**
     * The Sun exposure.
     */
    SunExposure sunExposure;

    /**
     * Instantiates a new House.
     *
     * @param area                  the area
     * @param location              the location
     * @param cityCentreDistance    the city centre distance
     * @param photographs           the photographs
     * @param numberOfBedrooms      the number of bedrooms
     * @param numberOfBathrooms     the number of bathrooms
     * @param numberOfParkingSpaces the number of parking spaces
     * @param equipment             the equipment
     * @param hasBasement           the has basement
     * @param hasInhabitableLoft    the has inhabitable loft
     * @param sunExposure           the sun exposure
     */
    public House(float area, Location location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment, boolean hasBasement, boolean hasInhabitableLoft, SunExposure sunExposure) {
        super(area, location, cityCentreDistance, photographs);
        this.numberOfBedrooms=setNumberOfBedrooms(numberOfBedrooms);
        this.numberOfBathrooms=setNumberOfBathrooms(numberOfBathrooms);
        this.numberOfParkingSpaces=setNumberOfParkingSpaces(numberOfParkingSpaces);
        this.equipment=setEquipment(equipment);
        this.hasBasement=hasBasement;
        this.hasInhabitableLoft=hasInhabitableLoft;
        this.sunExposure=sunExposure;
    }
    // Getters and Setters
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
     * Is has basement boolean.
     *
     * @return the boolean
     */
    public boolean getHasBasement() {
        return hasBasement;
    }


    /**
     * Is has inhabitable loft boolean.
     *
     * @return the boolean
     */
    public boolean getHasInhabitableLoft() {
        return hasInhabitableLoft;
    }


    /**
     * Gets sun exposure.
     *
     * @return the sun exposure
     */
    public SunExposure getSunExposure() {
        return sunExposure;
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
     * Sets sun exposure.
     *
     * @param sunExposure the sun exposure
     */
    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }

    /**
     * Sets has inhabitable loft.
     *
     * @param hasInhabitableLoft the has inhabitable loft
     */
    public void setHasInhabitableLoft(boolean hasInhabitableLoft) {

        this.hasInhabitableLoft = hasInhabitableLoft;
    }

    /**
     * Sets has basement.
     *
     * @param hasBasement the has basement
     */
    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    /**
     * Sets equipment.
     *
     * @param equipment the equipment
     * @return the equipment
     */
    public ArrayList<String> setEquipment(ArrayList<String> equipment) {
        if (equipment == null) {
            throw new NullPointerException("You need to insert at least 1 equipment.");
        }
        return equipment;
    }



    //toString()

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("House \n");
        sb.append(super.toString());
        sb.append(String.format("Number of Bedrooms:      %s\n", numberOfBedrooms));
        sb.append(String.format("Number of Bathrooms:     %s\n", numberOfBathrooms));
        sb.append(String.format("Number of Parking Spaces: %s\n", numberOfParkingSpaces));
        sb.append(String.format("Equipment:               %s\n", equipment));
        sb.append(String.format("Has Basement:            %s\n", hasBasement));
        sb.append(String.format("Has Inhabitable Loft:    %s\n", hasInhabitableLoft));
        sb.append(String.format("Sun Exposure:            %s\n", sunExposure));
        return sb.toString();
    }


}
