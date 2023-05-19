package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.Objects;

public class Order {

    private double orderAmount;
    private Announcement announcement;
    private static boolean status = false;     //True - the order was accepted   False - the order is not accepted

    public Order(double orderAmount, Announcement announcement) {

        this.orderAmount = setOrderAmount(orderAmount);
        this.announcement = setAnnouncement(announcement);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public double setOrderAmount(double orderAmount) {
       return this.orderAmount = orderAmount;
    }

    public Announcement setAnnouncement(Announcement announcement) {
       return this.announcement = announcement;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderAmount=").append(orderAmount);
        sb.append(", announcement=").append(announcement);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderAmount, orderAmount) == 0 && status == order.status && Objects.equals(announcement, order.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAmount, announcement, status);
    }

}
