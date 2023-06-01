package pt.ipp.isep.dei.esoft.project.domain.model;

import java.io.Serializable;


public class Location implements Serializable {
    int doorNumber;
    String street;
    City city;
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




    private boolean isValid(){
        return false;
    }

    public Location(){
        doorNumber = 0;
        street = "Street Zero";
        city = new City("City Zero");
        zipCode = 0;
    }

//    private boolean doorNumberIsValid(int doorNumber){
//        if (doorNumber < 1)
//            throw new IllegalArgumentException("Door number must be greater than zero");
//        return true;
//    }

    private boolean streetIsValid(String street){
        if (street.isBlank())
            throw new IllegalArgumentException("Street can't be blank");
        return true;
    }

    private boolean cityIsValid(City city){
        if (city == null)
            throw new IllegalArgumentException("City is invalid");
        return true;
    }

    private boolean zipCodeIsValid(int zipCode){
        if (zipCode < 10000 || zipCode > 99999)
            throw new IllegalArgumentException("Zip code must have 5 digits");
        return true;
    }

    public String getStreet() {
        return street;
    }
}


