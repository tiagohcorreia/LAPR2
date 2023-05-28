//package pt.ipp.isep.dei.esoft.project.domain.repository;
//
//
//import pt.ipp.isep.dei.esoft.project.domain.model.Property;
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PurchaseOrderRepository {
//
//    private List<PurchaseOrder> purchaseOrders;
//
//    public PurchaseOrderRepository() {
//        this.purchaseOrders = new ArrayList<>();
//    }
//
//    // Save a purchase order
//    public void save(PurchaseOrder purchaseOrder) {
//        purchaseOrders.add(purchaseOrder);
//    }
//
//    // Delete a purchase order
//    public void delete(PurchaseOrder purchaseOrder) {
//        purchaseOrders.remove(purchaseOrder);
//    }
//
//    // Get all purchase orders
//    public List<PurchaseOrder> getAll() {
//        return purchaseOrders;
//    }
//
//    // Get purchase order by property
//    public List<PurchaseOrder> getByProperty(Property property) {
//        List<PurchaseOrder> result = new ArrayList<>();
//        for (PurchaseOrder purchaseOrder : purchaseOrders) {
//            if (purchaseOrder.getProperty().equals(property)) {
//                result.add(purchaseOrder);
//            }
//        }
//        return result;
//    }
//
//    // Accept a purchase order
//    public void accept(PurchaseOrder purchaseOrder) {
//        purchaseOrder.setAccepted(true);
//    }
//
//    // Decline a purchase order
//    public void decline(PurchaseOrder purchaseOrder) {
//        purchaseOrder.setAccepted(false);
//    }
//
//    public PurchaseOrder getPurchaseOrderById(String id) {
//        for (PurchaseOrder order : this.purchaseOrders) {
//            if (order.getId().equals(id)) {
//                return order;
//            }
//        }
//        return null; // Retorna null se nenhum PurchaseOrder com o ID fornecido for encontrado.
//    }
//}

