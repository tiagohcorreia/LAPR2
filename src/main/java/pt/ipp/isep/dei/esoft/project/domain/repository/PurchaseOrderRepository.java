package pt.ipp.isep.dei.esoft.project.domain.repository;


import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderRepository {

    private List<Order> purchaseOrders;

    public PurchaseOrderRepository() {
        this.purchaseOrders = new ArrayList<>();
    }

    // Save a purchase order
    public void save(Order purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
    }

    // Delete a purchase order
    public void delete(Order purchaseOrder) {
        purchaseOrders.remove(purchaseOrder);
    }

    // Get all purchase orders
    public List<Order> getAll() {
        return purchaseOrders;
    }

    // Get purchase order by property
    public List<Order> getByProperty(Property property) {
        List<Order> result = new ArrayList<>();
        for (Order purchaseOrder : purchaseOrders) {
            if (purchaseOrder.getAnnouncementDTO().getProperty().equals(property)) {
                result.add(purchaseOrder);
            }
        }
        return result;
    }

    // Accept a purchase order
    public void accept(Order purchaseOrder) {
        purchaseOrder.setStatus(true);
    }

    // Decline a purchase order
    public void decline(Order purchaseOrder) {
        purchaseOrder.setStatus(false);
    }

    public Order getPurchaseOrderById(String id) {
        for (Order order : this.purchaseOrders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null; // Retorna null se nenhum PurchaseOrder com o ID fornecido for encontrado.
    }

    // Update a purchase order
    public void updatePurchaseOrder(Order updatedOrder) {
        int indexToUpdate = -1;
        for (int i = 0; i < purchaseOrders.size(); i++) {
            if (purchaseOrders.get(i).getId().equals(updatedOrder.getId())) {
                indexToUpdate = i;
                break;
            }
        }

        // If we found the PurchaseOrder, update it
        if (indexToUpdate != -1) {
            purchaseOrders.set(indexToUpdate, updatedOrder);
        } else {
            throw new IllegalArgumentException("No purchase order found with id: " + updatedOrder.getId());
        }
    }
}

