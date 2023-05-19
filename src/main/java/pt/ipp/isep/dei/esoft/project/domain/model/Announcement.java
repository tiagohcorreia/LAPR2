package pt.ipp.isep.dei.esoft.project.domain.model;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

/**
 * The type Announcement.
 */
public class Announcement {
    private boolean visible;
    private float price;
    private float commission;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;

    /**
     * Instantiates a new Announcement.
     *
     * @param visible        the visible
     * @param price          the price
     * @param commission     the  agent commission
     * @param typeOfBusiness the type of business (sellor/rent)
     * @param property       the property
     * @param agent          the agent
     */
//Full constructor
    public Announcement(boolean visible, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.setVisible(visible);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
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
        this.setVisible(false);
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
        this.setVisible(anotherAnnouncement.isVisible());
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
            if (this.isVisible() && typeOfBusiness.equals(this.typeOfBusiness.toString().toUpperCase()) && typeOfProperty.equals(this.property.getClass().getSimpleName().toUpperCase()) && numberOfBedrooms == this.getProperty().getNumberOfBedrooms()) {
                return new Announcement(this);
            }
        } else if(this.isVisible() && typeOfBusiness.equals(this.typeOfBusiness.toString().toUpperCase()) && typeOfProperty.equals(this.property.getClass().getSimpleName().toUpperCase())){
            return new Announcement(this);
        }
        return null;
    }


    /**
     * Is visible boolean.
     *
     * @return the boolean
     */
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * Sets visible.
     *
     * @param visible the visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

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

    //TO-FIX
    public String toString(){
        String visibility = (this.visible) ? "yes" : "no";
        return String.format("Announcement - " +
                "Visible: %s\t" +
                "Business Type: %s\t" +
                "Property: %s\t" +
                "Price: %f\t" +
                "Commission: %f\t" +
                "Agent: %s\t",
                visibility,
                this.typeOfBusiness.toString(),
                this.property.toString(),
                this.price,
                this.commission,
                this.agent.toString());
    }

    public String getAnnouncementAsString() {
        String result =
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
}
