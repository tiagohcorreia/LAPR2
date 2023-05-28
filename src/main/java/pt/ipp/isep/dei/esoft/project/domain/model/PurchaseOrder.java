//package pt.ipp.isep.dei.esoft.project.domain.model;
//
//import java.util.Objects;
//
//public class PurchaseOrder {
//    private String id;
//    private double orderAmount;
//    private Client client;
//    private Property property;
//    private boolean isAccepted;
//
//    // constructor, getters, setters
//
//
//    public PurchaseOrder(String id, double orderAmount, Client client, Property property, boolean isAccepted) {
//        this.id = id;
//        this.orderAmount = orderAmount;
//        this.client = client;
//        this.property = property;
//        this.isAccepted = isAccepted;
//    }
//
//    public PurchaseOrder() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public double getOrderAmount() {
//        return orderAmount;
//    }
//
//    public void setOrderAmount(double orderAmount) {
//        this.orderAmount = orderAmount;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public Property getProperty() {
//        return property;
//    }
//
//    public void setProperty(Property property) {
//        this.property = property;
//    }
//
//    public boolean isAccepted() {
//        return isAccepted;
//    }
//
//    public void setAccepted(boolean accepted) {
//        isAccepted = accepted;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PurchaseOrder that = (PurchaseOrder) o;
//        return Double.compare(that.orderAmount, orderAmount) == 0 && isAccepted == that.isAccepted && Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(property, that.property);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, orderAmount, client, property, isAccepted);
//    }
//
//    @Override
//    public String toString() {
//        return "PurchaseOrder{" +
//                "id='" + id + '\'' +
//                ", orderAmount=" + orderAmount +
//                ", client=" + client +
//                ", property=" + property +
//                ", isAccepted=" + isAccepted +
//                '}';
//    }
//}
