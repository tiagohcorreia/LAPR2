package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.ArrayList;

public class Apartment extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

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



    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }



    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }



    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public int setNumberOfBedrooms(int numberOfBedrooms) {
        if (numberOfBedrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBedrooms;
    }
    public int setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBathrooms;
    }
    public int setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        if (numberOfParkingSpaces<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfParkingSpaces;
    }

    public ArrayList<String> setEquipment(ArrayList<String> equipment) {
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
