package app.domain.model;
import app.domain.shared.TypeOfBusiness;

import java.util.NoSuchElementException;

public class Listing {
    private int listingID;
    private boolean visible;
    private float price;
    private float commission;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;

    //Full constructor
    public Listing(int listingID, boolean visible, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.setListingID(listingID);
        this.setVisible(visible);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        if (price < 0){
            throw new IllegalArgumentException("Invalid commission value.");
        }
        this.commission = commission;
    }

    //Default constructor
    public Listing(){
        this.setListingID(0);
        this.setVisible(false);
        this.setPrice(0);
        this.setCommission(0);
        this.setTypeOfBusiness(TypeOfBusiness.BUY);
        this.setProperty(null);
        this.setAgent(null);
    }

    //Copy constructor
    public Listing(Listing anotherListing){
        this.setListingID(anotherListing.getListingID());
        this.setVisible(anotherListing.isVisible());
        this.setPrice(anotherListing.getPrice());
        this.setCommission(anotherListing.getCommission());
        this.setTypeOfBusiness(anotherListing.getTypeOfBusiness());
        this.setProperty(anotherListing.getProperty());
        this.setAgent(anotherListing.getAgent());
    }

    public Listing getListing() { return new Listing(this); }

    public Listing getListing(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        if (this.isVisible() && typeOfBusiness.equals(this.typeOfBusiness.toString()) && typeOfProperty.equals(this.property.getClass().getSimpleName()) && numberOfBedrooms == 300){
        //if (this.isVisible() && typeOfBusiness.equals(this.typeOfBusiness.toString()) && typeOfProperty.equals(this.property.getClass().getSimpleName()) && numberOfBedrooms == this.property.getBedrooms()){
            return new Listing(this);
        }
        else
            throw new NoSuchElementException("No entries found.");
    }
    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) { this.listingID = listingID; }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0){
            throw new IllegalArgumentException("Invalid price value.");
        }
        this.price = price;
    }

    public TypeOfBusiness getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
        this.agent = agent;
    }

    //TO-FIX
    public String toString(){
        return String.format("Listing - " +
                "ID: %d\t" +
                "Visible: %s\t" +
                "Business Type: %s\t" +
                "Property: %s\t" +
                "Price: %f\t" +
                "Commission: %f\t" +
                "Agent: %s\t",
                this.listingID,
                "true",
                this.typeOfBusiness.toString(),
                this.property.toString(),
                this.price,
                this.commission,
                this.agent.toString());
    }
}
