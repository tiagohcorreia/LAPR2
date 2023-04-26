package app.domain.model;

import java.util.ArrayList;

public class Apartment extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    //Constructor
    public Apartment(int propertyID, float area, String address, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment) {
        super(propertyID, area, address, cityCentreDistance, photographs);
        this.numberOfBedrooms=numberOfBedrooms;
        this.numberOfBathrooms=numberOfBathrooms;
        this.numberOfParkingSpaces=numberOfParkingSpaces;
        this.equipment=equipment;

    }

    //Getters and Setters

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }

    //ToString

    @Override
    public String toString() {
        return "Apartment{" +
                "numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                '}';
    }
}
