//package pt.ipp.isep.dei.esoft.project.domain.repository;
//
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PurchaseOrderRepository {
//    private List<PurchaseOrder> purchaseOrders;
//
//    public PurchaseOrderRepository() {
//        this.purchaseOrders = new ArrayList<>();
//    }
//
//    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
//        purchaseOrders.add(purchaseOrder);
//    }
//
//    public List<PurchaseOrder> getAllPurchaseOrders() {
//        return new ArrayList<>(purchaseOrders);
//    }
//
//    public List<PurchaseOrder> getPurchaseOrdersByProperty(String propertyId) {
//        List<PurchaseOrder> result = new ArrayList<>();
//        for (PurchaseOrder purchaseOrder : purchaseOrders) {
//            if (purchaseOrder.getAnnouncementDTO().getProperty().getId().equals(propertyId)) {
//                result.add(purchaseOrder);
//            }
//        }
//        return result;
//    }
//
//    public void updatePurchaseOrder(PurchaseOrder updatedPurchaseOrder) {
//        for (PurchaseOrder purchaseOrder : purchaseOrders) {
//            if (purchaseOrder.getId().equals(updatedPurchaseOrder.getId())) {
//                purchaseOrders.set(purchaseOrders.indexOf(purchaseOrder), updatedPurchaseOrder);
//                break;
//            }
//        }
//    }
//}
