package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;

import java.util.Objects;

public class Order {

    private double orderAmount;
    private AnnouncementDTO announcementDTO;
    private static boolean status = false;     //True - the order was accepted   False - the order is not accepted

    public Order(double orderAmount, AnnouncementDTO announcementDTO) {

        this.orderAmount = setOrderAmount(orderAmount);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    public static boolean isStatus() {
        return status;
    }

    public double setOrderAmount(double orderAmount) {
        return this.orderAmount = orderAmount;
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    public static void setStatus(boolean status) {
        Order.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
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
        return Double.compare(order.orderAmount, orderAmount) == 0 && Objects.equals(announcementDTO, order.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAmount, announcementDTO);
    }
}
