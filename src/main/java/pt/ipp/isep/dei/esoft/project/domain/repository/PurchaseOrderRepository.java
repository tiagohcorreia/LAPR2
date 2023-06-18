package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderRepository {

    private List<Order> purchaseOrders;

    public PurchaseOrderRepository() {
        this.purchaseOrders = new ArrayList<>();
    }

    public void save(Order purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
    }

    public void delete(Order purchaseOrder) {
        purchaseOrders.remove(purchaseOrder);
    }

    public List<Order> getAll() {
        return purchaseOrders;
    }

    public List<Order> getByProperty(Property property) {
        List<Order> result = new ArrayList<>();
        for (Order purchaseOrder : purchaseOrders) {
            if (purchaseOrder.getAnnouncementDTO().getProperty().equals(property)) {
                result.add(purchaseOrder);
            }
        }
        return result;
    }

    public Order getPurchaseOrderById(String id) {
        for (Order order : purchaseOrders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public void updatePurchaseOrder(Order updatedOrder) {
        int indexToUpdate = -1;
        for (int i = 0; i < purchaseOrders.size(); i++) {
            if (purchaseOrders.get(i).getId().equals(updatedOrder.getId())) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            purchaseOrders.set(indexToUpdate, updatedOrder);
        } else {
            throw new IllegalArgumentException("No purchase order found with id: " + updatedOrder.getId());
        }
    }
}
