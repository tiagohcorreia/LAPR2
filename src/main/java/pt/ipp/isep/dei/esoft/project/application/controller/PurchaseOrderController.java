package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PurchaseOrderController {

    private PurchaseOrderRepository purchaseOrderRepository = Repositories.getInstance().getPurchaseOrderRepository();

    public PurchaseOrderController() {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public List<Order> getPurchaseOrdersByProperty(Property property) {
        List<Order> purchaseOrders = purchaseOrderRepository.getByProperty(property);

        // Sort the purchase orders from oldest to most recent
        Collections.sort(purchaseOrders, Comparator.comparing(Order::getId));

        // Sort the purchase orders by the amount offered, highest first
        purchaseOrders.sort(Collections.reverseOrder(Comparator.comparingDouble(Order::getOrderAmount)));

        return purchaseOrders;
    }

    public void acceptPurchaseOrder(Order purchaseOrder) {
        if(!purchaseOrder.isStatus()){
            purchaseOrderRepository.updatePurchaseOrder(purchaseOrder);
        }
    }

    public void declinePurchaseOrder(Order purchaseOrder) {
        if(purchaseOrder.isStatus()){
            purchaseOrderRepository.updatePurchaseOrder(purchaseOrder);
        }
    }

    public void declineOtherPurchaseOrders(Property property) {
        List<Order> ordersForProperty = purchaseOrderRepository.getByProperty(property);
        for (Order order : ordersForProperty) {
            if (!order.isStatus()) {
                order.isStatus();
                purchaseOrderRepository.updatePurchaseOrder(order);
            }
        }
    }
}


