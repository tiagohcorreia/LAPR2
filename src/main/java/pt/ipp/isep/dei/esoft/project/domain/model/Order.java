package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;


import java.io.Serializable;
import java.util.Objects;

/**
 * The type Order.
 */
public class Order implements Serializable {

    private String id;
    private double orderAmount;
    private AnnouncementDTO announcementDTO;
    private boolean status = false;     //True - the order was accepted   False - the order is not accepted
    private Client client;

    /**
     * Instantiates a new Order.
     *
     * @param orderAmount     the order amount
     * @param announcementDTO the announcement dto
     * @param status          the status
     */
    public Order(double orderAmount, AnnouncementDTO announcementDTO, boolean status) {

        this.orderAmount = setOrderAmount(orderAmount);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
        this.status = false;
    }

    /**
     * Instantiates a new Order.
     *
     * @param id              the id
     * @param orderAmount     the order amount
     * @param announcementDTO the announcement dto
     * @param client          the client
     */
    public Order(String id, double orderAmount, AnnouncementDTO announcementDTO, Client client) {
        this.id = id;
        this.orderAmount = orderAmount;
        this.announcementDTO = announcementDTO;
        this.client = client;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets order amount.
     *
     * @return the order amount
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Gets announcement dto.
     *
     * @return the announcement dto
     */
    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Is status boolean.
     *
     * @return the boolean
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets order amount.
     *
     * @param orderAmount the order amount
     * @return the order amount
     */
    public double setOrderAmount(double orderAmount) {

        if (orderAmount < 0) {

            throw new IllegalArgumentException("Order amount must be positive");
        }
        return this.orderAmount;
    }

    /**
     * Sets announcement dto.
     *
     * @param announcementDTO the announcement dto
     * @return the announcement dto
     */
    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Order -");

        sb.append("Id:").append(id);
        sb.append("Order Amount:").append(orderAmount);
        sb.append(", Announcement:").append(announcementDTO);
        sb.append("");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order otherOrder = (Order) o;
        return Objects.equals(orderAmount, otherOrder.orderAmount) && Objects.equals(announcementDTO, otherOrder.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderAmount, announcementDTO);
    }
}
