package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;

import java.util.ArrayList;

public class House extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    private boolean hasBasement;
    private boolean hasInhabitableLoft;
    SunExposure sunExposure;

    public House(float area, City location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment, boolean hasBasement, boolean hasInhabitableLoft, SunExposure sunExposure) {
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



    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }



    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }



    public ArrayList<String> getEquipment() {
        return equipment;
    }



    public boolean isHasBasement() {
        return hasBasement;
    }



    public boolean isHasInhabitableLoft() {
        return hasInhabitableLoft;
    }



    public SunExposure getSunExposure() {
        return sunExposure;
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
    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }
    public void setHasInhabitableLoft(boolean hasInhabitableLoft) {

        this.hasInhabitableLoft = hasInhabitableLoft;
    }
    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }
    public ArrayList<String> setEquipment(ArrayList<String> equipment) {
        if (equipment == null) {
            throw new NullPointerException("You need to insert at least 1 equipment.");
        }
        return equipment;
    }



    //toString()

    @Override
    public String toString() {
        return "House{" +super.toString()+
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                ", hasBasement=" + hasBasement +
                ", hasInhabitableLoft=" + hasInhabitableLoft +
                ", sunExposure=" + sunExposure +
                '}';
    }


}
