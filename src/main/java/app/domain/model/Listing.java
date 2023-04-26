package app.domain.model;
import app.domain.shared.TypeOfBusiness;

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
        this.listingID = listingID;
        this.visible = visible;
        this.price = price;
        this.commission = commission;
        this.typeOfBusiness = typeOfBusiness;
        this.property = property;
        this.agent = agent;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    //Default constructor
    public Listing(){
        this.listingID = 0;
        this.visible = false;
        this.price = 0;
        this.commission = 0;
        this.typeOfBusiness = TypeOfBusiness.BUY;
        this.property = null;
        this.agent = null;
    }

    //Copy constructor
    public Listing(Listing anotherListing){
        this.listingID = anotherListing.listingID;
        this.visible = anotherListing.visible;
        this.price = anotherListing.price;
        this.commission = anotherListing.commission;
        this.typeOfBusiness = anotherListing.typeOfBusiness;
        this.property = anotherListing.property;
        this.agent = anotherListing.agent;
    }

    public Listing getListing() {return new Listing(this);}

    public Listing getListing(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        if (this.isVisible() && typeOfBusiness.equals(this.typeOfBusiness.toString()) && typeOfProperty.equals(this.property.getTypeProperty()) && numberOfBedrooms == this.property.getBedrooms()){
            return new Listing(this);
        }
        else
            return null;
    }
    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) {
        this.listingID = listingID;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    //TODO
    /*public String toString(){
        return String.format();
    }*/
}
