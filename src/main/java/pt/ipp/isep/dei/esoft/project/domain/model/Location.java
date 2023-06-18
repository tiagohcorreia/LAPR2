package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Validator;

import java.io.Serializable;


/**
 * The type Location.
 */
public class Location implements Serializable, Validator {
    /**
     * The Door number.
     */
    int doorNumber;
    /**
     * The Street.
     */
    String street;
    /**
     * The City.
     */
    City city;
    /**
     * The District.
     */
    District district;
    /**
     * The State.
     */
    State state;
    /**
     * The Zip code.
     */
    int zipCode;

    /**
     * Instantiates a new Location.
     *
     * @param street  the street
     * @param city    the city
     * @param zipCode the zip code
     */
    public Location(String street, City city, int zipCode) {
        if(
        //doorNumberIsValid(doorNumber) &&
            streetIsValid(street) &&
            cityIsValid(city) &&
            zipCodeIsValid(zipCode)) {

            //this.doorNumber = doorNumber;
            this.street = street;
            this.city = city;
            this.zipCode = zipCode;
        }
        else
            throw new IllegalArgumentException("Couldn't register location");
    }

    /**
     * Instantiates a new Location.
     *
     * @param doorNumber the door number
     * @param street     the street
     * @param city       the city
     * @param zipCode    the zip code
     */
    public Location(int doorNumber, String street, City city, int zipCode) {
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }


    /**
     * Instantiates a new Location.
     */
    public Location(){
        doorNumber = 0;
        street = "Street Zero";
        city = new City("City Zero");
        zipCode = 0;
    }

    /**
     * Instantiates a new Location.
     *
     * @param doorNumber the door number
     * @param street     the street
     * @param city       the city
     * @param district   the district
     * @param state      the state
     * @param zipCode    the zip code
     */
    public Location(int doorNumber, String street, City city, District district, State state, int zipCode){
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid(){
        return (
                validateZipCode(zipCode) &&
                validateString(street) &&
                validateObject(city) &&
                validateObject(state)
        );
    }

//    private boolean doorNumberIsValid(int doorNumber){
//        if (doorNumber < 1)
//            throw new IllegalArgumentException("Door number must be greater than zero");
//        return true;
//    }

    /**
     * Street is valid boolean.
     *
     * @param street the street
     * @return the boolean
     */
    public boolean streetIsValid(String street){
        if (street.isBlank())
            throw new IllegalArgumentException("Street can't be blank");
        return true;
    }

    /**
     * City is valid boolean.
     *
     * @param city the city
     * @return the boolean
     */
    public boolean cityIsValid(City city){
        if (city == null)
            throw new IllegalArgumentException("City is invalid");
        return true;
    }

    /**
     * Zip code is valid boolean.
     *
     * @param zipCode the zip code
     * @return the boolean
     */
    public boolean zipCodeIsValid(int zipCode){
        if (zipCode < 10000 || zipCode > 99999)
            throw new IllegalArgumentException("Zip code must have 5 digits");
        return true;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }


    /*public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Door Number: %s\n", doorNumber));
        sb.append(String.format("Street:      %s\n", street));
        sb.append(String.format("City:        %s\n", city));
        sb.append(String.format("Zip Code:    %s\n", zipCode));
        return sb.toString();
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Door Number:").append(doorNumber).append("\t");
        sb.append("Street:").append(street).append("\t");
        sb.append("").append(city).append("");
        sb.append("Zip Code:").append(zipCode);
        return sb.toString();
    }
}


