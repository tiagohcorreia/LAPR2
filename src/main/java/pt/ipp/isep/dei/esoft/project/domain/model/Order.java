package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;


import java.io.Serializable;
import java.util.Objects;

/**
 * The type Order.
 */
public class Order implements Serializable{

    private String id;
    private double orderAmount;
    private AnnouncementDTO announcementDTO;
    private static boolean status = false;     //True - the order was accepted   False - the order is not accepted
    private Client client;

    /**
     * Instantiates a new Order.
     *
     * @param orderAmount     the order amount
     * @param announcementDTO the announcement dto
     */
    public Order(double orderAmount, AnnouncementDTO announcementDTO) {

        this.orderAmount = setOrderAmount(orderAmount);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
    }

    public Order(String id, double orderAmount, AnnouncementDTO announcementDTO, Client client) {
        this.id = id;
        this.orderAmount = orderAmount;
        this.announcementDTO = announcementDTO;
        this.client = client;
    }

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

    public Client getClient() {
        return client;
    }

    /**
     * Is status boolean.
     *
     * @return the boolean
     */
    public static boolean isStatus() {
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
    public static void setStatus(boolean status) {
        Order.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append("orderAmount=").append(orderAmount);
        sb.append(", announcementDTO=").append(announcementDTO);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderAmount, orderAmount) == 0 && Objects.equals(id, order.id) && Objects.equals(announcementDTO, order.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderAmount, announcementDTO);
    }
}
