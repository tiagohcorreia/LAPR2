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
    private Employee agent;

    //Constructor
    public Property(String sellOrRent, String typeProperty, int bedrooms, int bathrooms, int parking, ArrayList<String> equipmentList, String basement, String inhabitalLoft, String sunExposure, int area, String location, int centreDistance, double price, ArrayList<String> photographs,Employee agent) {

        verifyDataNull(sellOrRent, typeProperty, bedrooms, bathrooms, parking, equipmentList, basement, inhabitalLoft, sunExposure, area, location, centreDistance, price, photographs, agent);

        this.sellOrRent = setSellOrRent(sellOrRent);
        this.typeProperty = setTypeProperty(typeProperty);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.parking = parking;
        this.equipmentList = equipmentList;
        this.basement = setBasement(basement);
        this.inhabitalLoft = setInhabitalLoft(inhabitalLoft);
        this.sunExposure = setSunExposure(sunExposure);
        this.area = area;
        this.location = location;
        this.centreDistance = centreDistance;
        this.price = price;
        this.photographs = setPhotographs(photographs);
        this.agent=agent;
    }
    //Getters ans setters
    public String getSellOrRent() {
        return sellOrRent;
    }
    public String setSellOrRent(String sellOrRent) {

        if(sellOrRent != "S" || sellOrRent != "R") {
            throw new IllegalArgumentException("You must insert 'S' if you want to sell or 'R' if you want to rent the property.");
        }
        return sellOrRent = sellOrRent;

    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public String setTypeProperty(String typeProperty) {
        if(typeProperty != "A" || typeProperty != "H" || typeProperty != "L") {
            throw new IllegalArgumentException("You must insert 'A' if your property is an apartment, 'H' if it's a house or 'L' if it's a land.");
        }
        return typeProperty = typeProperty;
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

    public Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
        this.agent = agent;
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

    public String setBasement(String basement) {
        if(basement!= "Y" || basement != "y" || basement != "N" || basement != "n") {
            throw new IllegalArgumentException("Please insert 'Y' if the property has basement and 'N' if the property hasn't basement.");
        }
        return basement = basement;
    }

    public String getInhabitalLoft() {
        return inhabitalLoft;
    }

    public String setInhabitalLoft(String inhabitalLoft) {
        if(inhabitalLoft!= "Y" || inhabitalLoft != "y" || inhabitalLoft != "N" || inhabitalLoft != "n") {
            throw new IllegalArgumentException("Please insert 'Y' if the property has inhabital loft and 'N' if the property hasn't inhabital loft.");
        }
        return inhabitalLoft = inhabitalLoft;

    }

    public String getSunExposure() {
        return sunExposure;
    }

    public String setSunExposure(String sunExposure) {
        if(sunExposure!= "Y" || sunExposure != "y" || sunExposure != "N" || sunExposure != "n") {
            throw new IllegalArgumentException("Please insert 'Y' if the property has Sun Exposure and 'N' if the property hasn't Sun Exposure.");
        }
        return sunExposure = sunExposure;

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

    public ArrayList<String> setPhotographs(ArrayList<String> photographs) {
        if(photographs.size() < 1 && photographs.size() > 30) {
            throw new IllegalArgumentException("Please insert at least 1 photograph with a maximum of 30 photographs.");
        }
        return photographs = photographs;

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
                ", equipmentList=" + equipmentList +
                ", basement='" + basement + '\'' +
                ", inhabitalLoft='" + inhabitalLoft + '\'' +
                ", sunExposure='" + sunExposure + '\'' +
                ", area=" + area +
                ", location='" + location + '\'' +
                ", centreDistance=" + centreDistance +
                ", price=" + price +
                ", photographs=" + photographs +
                ", agent=" + agent +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return bedrooms == property.bedrooms && bathrooms == property.bathrooms && parking == property.parking && area == property.area && centreDistance == property.centreDistance && Double.compare(property.price, price) == 0 && Objects.equals(sellOrRent, property.sellOrRent) && Objects.equals(typeProperty, property.typeProperty) && Objects.equals(equipmentList, property.equipmentList) && Objects.equals(basement, property.basement) && Objects.equals(inhabitalLoft, property.inhabitalLoft) && Objects.equals(sunExposure, property.sunExposure) && Objects.equals(location, property.location) && Objects.equals(photographs, property.photographs) && Objects.equals(agent, property.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellOrRent, typeProperty, bedrooms, bathrooms, parking, equipmentList, basement, inhabitalLoft, sunExposure, area, location, centreDistance, price, photographs, agent);
    }

    private void verifyDataNull(String sellOrRent, String typeProperty, int bedrooms, int bathrooms, int parking, ArrayList<String> equipmentList, String basement, String inhabitalLoft, String sunExposure, int area, String location, int centreDistance, double price, ArrayList<String> photographs,Employee agent){
        if (sellOrRent == null || typeProperty == null || bedrooms==0 || bathrooms==0 || parking==0 || equipmentList.size()<=0 || basement == null || inhabitalLoft == null || sunExposure ==null || area == 0 || location == null || centreDistance==0 || price==0 || photographs.size()<=0 || agent == null){
            throw new NullPointerException("Property data can't be empty, please insert all the required information.");
        }
    }
}
