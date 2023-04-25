package app.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class Property {
    private String sellOrRent;
    private String typeProperty;
    private int bedrooms;
    private int bathrooms;
    private int parking;
    private ArrayList<String> equipmentList;
    private String basement;
    private String inhabitalLoft;
    private String sunExposure;
    private int area;
    private String location;
    private int centreDistance;
    private double price;
    private ArrayList<String> photographs;

    //Constructor
    public Property(String sellOrRent, String typeProperty, int bedrooms, int bathrooms, int parking, ArrayList<String> equipmentList, String basement, String inhabitalLoft, String sunExposure, int area, String location, int centreDistance, double price, ArrayList<String> photographs) {
        this.sellOrRent = sellOrRent;
        this.typeProperty = typeProperty;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.parking = parking;
        this.equipmentList = equipmentList;
        this.basement = basement;
        this.inhabitalLoft = inhabitalLoft;
        this.sunExposure = sunExposure;
        this.area = area;
        this.location = location;
        this.centreDistance = centreDistance;
        this.price = price;
        this.photographs = photographs;
    }
    //Getters ans setters
    public String getSellOrRent() {
        return sellOrRent;
    }

    public void setSellOrRent(String sellOrRent) {
        this.sellOrRent = sellOrRent;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public ArrayList<String> getEquipment() {
        return equipmentList;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipmentList = equipmentList;
    }

    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String getInhabitalLoft() {
        return inhabitalLoft;
    }

    public void setInhabitalLoft(String inhabitalLoft) {
        this.inhabitalLoft = inhabitalLoft;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCentreDistance() {
        return centreDistance;
    }

    public void setCentreDistance(int centreDistance) {
        this.centreDistance = centreDistance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getPhotographs() {
        return photographs;
    }

    public void setPhotographs(ArrayList<String> photographs) {
        this.photographs = photographs;
    }

    //toString()

    @Override
    public String toString() {
        return "Property{" +
                "sellOrRent='" + sellOrRent + '\'' +
                ", typeProperty='" + typeProperty + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", parking=" + parking +
                ", equipment='" + equipmentList + '\'' +
                ", basement=" + basement +
                ", inhabitalLoft=" + inhabitalLoft +
                ", sunExposure=" + sunExposure +
                ", area=" + area +
                ", location='" + location + '\'' +
                ", centreDistance=" + centreDistance +
                ", price=" + price +
                ", photographs=" + photographs +
                '}';
    }

}
