package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PurchaseOrderController {

    private PlaceOrderToBuyPropertyRepository orderToBuyPropertyRepository = Repositories.getInstance().getOrderToBuyPropertyRepository();
    private PurchaseOrderRepository purchaseOrderRepository = Repositories.getInstance().getPurchaseOrderRepository();

    public PurchaseOrderController() {

    }

    public List<Order> getPurchaseOrdersByProperty() {
        List<Order> purchaseOrders = orderToBuyPropertyRepository.getOrderList();

        // Sort the purchase orders from oldest to most recent
        Collections.sort(purchaseOrders, Comparator.comparing(Order::getId));

        // Sort the purchase orders by the amount offered, highest first
        purchaseOrders.sort(Collections.reverseOrder(Comparator.comparingDouble(Order::getOrderAmount)));

        return purchaseOrders;
    }

    public void acceptPurchaseOrder(Order purchaseOrder) {
        if (!purchaseOrder.isStatus()) {
            purchaseOrder.setStatus(true);
            purchaseOrderRepository.save(purchaseOrder);

        }
    }

    public void declinePurchaseOrder(Order purchaseOrder) {
        if (purchaseOrder.isStatus()) {
            purchaseOrder.setStatus(false);
            purchaseOrderRepository.save(purchaseOrder);
        }
    }

    public void declineOtherPurchaseOrders(Property property) {
        List<Order> ordersForProperty = purchaseOrderRepository.getByProperty(property);
        for (Order order : ordersForProperty) {
            if (!order.isStatus()) {
                order.setStatus(false);
                purchaseOrderRepository.save(order);
            }
        }
    }
}
