package pt.ipp.isep.dei.esoft.project.domain.model;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.ZoneId;


/**
 * The type Announcement.
 */
public class Announcement implements Serializable {
    // private boolean visible;

    private LocalDate date;
    private AnnouncementStatus status;
    private float price;
    private float commission;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;
    private String reason;

    /**
     * Instantiates a new Announcement.
     *
     * @param price          the price
     * @param commission     the  agent commission
     * @param typeOfBusiness the type of business (sellor/rent)
     * @param property       the property
     * @param agent          the agent
     */
//Full constructor
    public Announcement(LocalDate date, AnnouncementStatus status, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.setDate(date);
        this.setStatus(status);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
    }

    public Announcement(AnnouncementStatus status, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {

        this.setStatus(status);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
    }

    public void setStatus(AnnouncementStatus status) {

        this.status = status;
    }
    public AnnouncementStatus getStatus(){

        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets commission.
     *
     * @return the commission
     */
    public float getCommission() {
        return commission;
    }

    /**
     * Sets commission.
     *
     * @param commission the commission
     */
    public void setCommission(float commission) {
        if (commission < 0){
            throw new IllegalArgumentException("Invalid commission value.");
        }
        this.commission = commission;
    }

    /**
     * Instantiates a new Announcement.
     */
//Default constructor
    public Announcement(){
        this.setStatus(AnnouncementStatus.PENDENT);
        this.setPrice(0);
        this.setCommission(0);
        this.setTypeOfBusiness(TypeOfBusiness.SELL);
        this.setProperty(null);
        this.setAgent(null);
    }

    /**
     * Instantiates a new Announcement.
     *
     * @param anotherAnnouncement the another announcement
     */
//Copy constructor
    public Announcement(Announcement anotherAnnouncement){
        this.setDate(anotherAnnouncement.getDate());
        this.setStatus(anotherAnnouncement.getStatus());
        this.setPrice(anotherAnnouncement.getPrice());
        this.setCommission(anotherAnnouncement.getCommission());
        this.setTypeOfBusiness(anotherAnnouncement.getTypeOfBusiness());
        this.setProperty(anotherAnnouncement.getProperty());
        this.setAgent(anotherAnnouncement.getAgent());
    }

    /**
     * Gets announcement.
     *
     * @return the announcement
     */
    public Announcement getAnnouncement() {
        return new Announcement(this); }

    /**
     * Get announcement announcement.
     *
     * @param typeOfBusiness   the type of business
     * @param typeOfProperty   the type of property
     * @param numberOfBedrooms the number of bedrooms
     * @return the announcement
     */
    public Announcement getAnnouncement(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        if (!typeOfBusiness.equals("LAND")) {
            if (this.status == AnnouncementStatus.PUBLISHED && typeOfBusiness.equals(this.typeOfBusiness.toString().toUpperCase()) && typeOfProperty.equals(this.property.getClass().getSimpleName().toUpperCase()) && numberOfBedrooms == this.getProperty().getNumberOfBedrooms()) {
                return new Announcement(this);
            }
        } else if(this.status == AnnouncementStatus.PUBLISHED&& typeOfBusiness.equals(this.typeOfBusiness.toString().toUpperCase()) && typeOfProperty.equals(this.property.getClass().getSimpleName().toUpperCase())){
            return new Announcement(this);
        }
        return null;
    }


    /**
     * Is visible boolean.
     *
     * @return the boolean
     */
   /* public boolean isVisible() {
        return this.visible;
    }/*

    /**
     * Sets visible.
     *
     * @param visible the visible
     */
   /* public void setVisible(boolean visible) {
        this.visible = visible;
    }
    */

    /**
     * Gets price.
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(float price) {
        if (price < 0){
            throw new IllegalArgumentException("Invalid price value.");
        }
        this.price = price;
    }

    /**
     * Gets type of business.
     *
     * @return the type of business
     */
    public TypeOfBusiness getTypeOfBusiness() {
        return typeOfBusiness;
    }

    /**
     * Sets type of business.
     *
     * @param typeOfBusiness the type of business
     */
    public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    /**
     * Gets property.
     *
     * @return the property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets property.
     *
     * @param property the property
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Gets agent.
     *
     * @return the agent
     */
    public Employee getAgent() {
        return agent;
    }

    /**
     * Sets agent.
     *
     * @param agent the agent
     */
    public void setAgent(Employee agent) {
        this.agent = agent;
    }
    public void setRejectionReason(String reason) {
        this.reason = reason;
    }

    //TO-FIX
   /* public String toString(){
            String status = (this.status == AnnouncementStatus.PUBLISHED) ? "Published" : "Not Published";
            String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));



        return String.format("Announcement - " +
                    "Date: %s\t" +
            "Status: %s\t" +
            "Business Type: %s\t" +
             "Property: %s\t" +
             "Price: %.2f\t" +
             "Commission: %.2f\t" +
              "Agent: %s\t",
                formattedDate,
               this.status,
               this.typeOfBusiness.toString(),
               this.property.toString(),
                this.price,
                this.commission,
               this.agent.toString());
        }*/
    public String toString() {
        String status = (this.status == AnnouncementStatus.PUBLISHED) ? "Published" : "Not Published";
        String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        StringBuilder sb = new StringBuilder();
        sb.append("Announcement Details:\n");
        sb.append(String.format("Date:    %s\n", formattedDate));
        sb.append(String.format("Status:  %s\n", status));
        sb.append(String.format("Price:   %.2f\n", price));
        sb.append(String.format("Type of Business: %s\n", typeOfBusiness));
        sb.append(String.format("Property: %s\n", property));
        sb.append(String.format("Agent:   %s\n", agent));
        return sb.toString();
    }

    public String getAnnouncementAsString() {
        String result =
                getDate().toString() +"\t" +
                getTypeOfBusiness().toString() + "\t" +
                getProperty().getClass().getSimpleName() + "\t" +
                getPrice() + "\t" +
                getProperty().getLocation() + "\t" +
                getProperty().getArea() + "\t" +
                getProperty().getCityCentreDistance() + "\t" +
                getProperty().getNumberOfBedrooms() + "\t" +
                getProperty().getPhotographs() + "\t" +
                getAgent().getName();
        return result;
    }

    public static Property createProperty(float area, Location location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment) {
        return new Apartment(area, location, cityCentreDistance, equipment, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, equipment);
    }
    public static Property createProperty(float area, Location location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment, boolean hasBasement, boolean hasInhabitableLoft, SunExposure sunExposure) {
        return new House(area, location, cityCentreDistance, photographs, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, equipment ,hasBasement, hasInhabitableLoft, sunExposure);
    }
    public static Property createProperty(float area, Location location, float cityCentreDistance, ArrayList<String> photographs) {
        return new Land(area, location, cityCentreDistance, photographs);
    }

}
