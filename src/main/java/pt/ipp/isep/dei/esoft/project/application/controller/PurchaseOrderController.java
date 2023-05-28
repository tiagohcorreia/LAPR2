//package pt.ipp.isep.dei.esoft.project.application.controller;
//
//import pt.ipp.isep.dei.esoft.project.domain.model.Property;
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;
//import pt.ipp.isep.dei.esoft.project.domain.repository.EmailService;
//import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
//
//
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//    public class PurchaseOrderController {
//
//        private PurchaseOrderRepository purchaseOrderRepository;
//        private EmailService emailService;
//
//        public PurchaseOrderController() {
//            this.purchaseOrderRepository = new PurchaseOrderRepository();
//            this.emailService = new EmailService();
//        }
//
//        public List<PurchaseOrder> getPurchaseOrdersByProperty(Property property) {
//            List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getByProperty(property);
//
//            // Sort the purchase orders from highest to lowest offer
//            Collections.sort(purchaseOrders, Comparator.comparing(PurchaseOrder::getOrderAmount).reversed());
//
//            return purchaseOrders;
//        }
//
//        public PurchaseOrder getPurchaseOrderById(String id) {
//            return this.purchaseOrderRepository.getPurchaseOrderById(id);
//        }
//
//        public void acceptPurchaseOrder(PurchaseOrder purchaseOrder) {
//            purchaseOrderRepository.accept(purchaseOrder);
//            emailService.sendNotification(purchaseOrder.getClient(), "Your purchase order has been accepted.");
//
//            // Decline all other purchase orders for the property
//            List<PurchaseOrder> otherPurchaseOrders = purchaseOrderRepository.getByProperty(purchaseOrder.getProperty());
//            for (PurchaseOrder otherPurchaseOrder : otherPurchaseOrders) {
//                if (!otherPurchaseOrder.equals(purchaseOrder)) {
//                    declinePurchaseOrder(otherPurchaseOrder);
//                }
//            }
//        }
//
//        public void declinePurchaseOrder(PurchaseOrder purchaseOrder) {
//            purchaseOrderRepository.decline(purchaseOrder);
//            emailService.sendNotification(purchaseOrder.getClient(), "Your purchase order has been declined.");
//        }
//    }

