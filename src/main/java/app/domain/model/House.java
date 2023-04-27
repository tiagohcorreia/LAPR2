package app.domain.model;

import app.domain.shared.SunExposure;

import java.util.ArrayList;

public class House extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    private boolean hasBasement;
    private boolean hasInhabitableLoft;
    private SunExposure sunExposure;

    public House(float area, City address, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment, boolean hasBasement, boolean hasInhabitableLoft, SunExposure sunExposure) {
        super(area, address, cityCentreDistance, photographs);
        this.numberOfBedrooms=numberOfBedrooms;
        this.numberOfBathrooms=numberOfBathrooms;
        this.numberOfParkingSpaces=numberOfParkingSpaces;
        this.equipment=equipment;
        this.hasBasement=hasBasement;
        this.hasInhabitableLoft=hasInhabitableLoft;
        this.sunExposure=sunExposure;
    }
    // Getters and Setters
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

    public boolean isHasBasement() {
        return hasBasement;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public boolean isHasInhabitableLoft() {
        return hasInhabitableLoft;
    }

    public void setHasInhabitableLoft(boolean hasInhabitableLoft) {
        this.hasInhabitableLoft = hasInhabitableLoft;
    }

    public SunExposure getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }

    //toString()

    @Override
    public String toString() {
        return "House{" +
                "numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                ", hasBasement=" + hasBasement +
                ", hasInhabitableLoft=" + hasInhabitableLoft +
                ", sunExposure=" + sunExposure +
                '}';
    }


}
