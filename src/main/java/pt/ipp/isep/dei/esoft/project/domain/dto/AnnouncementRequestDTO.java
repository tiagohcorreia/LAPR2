package pt.ipp.isep.dei.esoft.project.domain.dto;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;

import java.time.LocalDate;

/**
 * The type Announcement request dto.
 */
public class AnnouncementRequestDTO {

        private LocalDate date;
        private AnnouncementStatus status;
        private float price;
        private TypeOfBusiness typeOfBusiness;
        private Property property;
        private Employee agent;
        private Client owner;


    /**
     * Announcement request dto.
     *
     * @param date           the date
     * @param status         the status
     * @param price          the price
     * @param typeOfBusiness the type of business
     * @param property       the property
     * @param agent          the agent
     * @param owner          the owner
     */
    public void AnnouncementRequestDTO(LocalDate date, AnnouncementStatus status, float price, TypeOfBusiness typeOfBusiness, Property property, Employee agent, Client owner) {
            this.date = LocalDate.now();
            this.status = status;
            this.price = price;
            this.typeOfBusiness = typeOfBusiness;
            this.property = property;
            this.agent = agent;
            this.owner = owner;
        }


    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
            return date;
        }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
            this.date = date;
        }

    /**
     * Gets status.
     *
     * @return the status
     */
    public AnnouncementStatus getStatus() {
            return status;
        }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(AnnouncementStatus status) {
            this.status = status;
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
        this.status = status;
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

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public Client getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Announcement - Date: ").append(String.format("%-12s", date.toString()));
            sb.append("Status: ").append(String.format("%-10s", status));
            sb.append("Business Type: ").append(String.format("%-10s", typeOfBusiness));
            sb.append("Property: ").append(property.toString());
            return sb.toString();
        }


}
