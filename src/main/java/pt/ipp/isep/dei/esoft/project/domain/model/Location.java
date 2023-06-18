package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Validator;

import java.io.Serializable;


public class Location implements Serializable, Validator {
    int doorNumber;
    String street;
    City city;
    District district;
    State state;
    int zipCode;

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

    public Location(int doorNumber, String street, City city, int zipCode) {
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }




    public Location(){
        doorNumber = 0;
        street = "Street Zero";
        city = new City("City Zero");
        zipCode = 0;
    }

    public Location(int doorNumber, String street, City city, District district, State state, int zipCode){
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

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

    public boolean streetIsValid(String street){
        if (street.isBlank())
            throw new IllegalArgumentException("Street can't be blank");
        return true;
    }

    public boolean cityIsValid(City city){
        if (city == null)
            throw new IllegalArgumentException("City is invalid");
        return true;
    }

    public boolean zipCodeIsValid(int zipCode){
        if (zipCode < 10000 || zipCode > 99999)
            throw new IllegalArgumentException("Zip code must have 5 digits");
        return true;
    }

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


