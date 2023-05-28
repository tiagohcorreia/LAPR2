//package pt.ipp.isep.dei.esoft.project.domain.controller;
//
//import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
//import pt.ipp.isep.dei.esoft.project.domain.dto.PurchaseOrderDTO;
//import pt.ipp.isep.dei.esoft.project.domain.model.EmailNotification;
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;
//import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PurchaseOrderController {
//    private PurchaseOrderRepository purchaseOrderRepository;
//
//    public PurchaseOrderController() {
//        this.purchaseOrderRepository = new PurchaseOrderRepository();
//    }
//
//    public List<PurchaseOrderDTO> getPurchaseOrdersByProperty(String propertyId) {
//        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getPurchaseOrdersByProperty(propertyId);
//
//        List<PurchaseOrderDTO> purchaseOrderDTOs = new ArrayList<>();
//        for (PurchaseOrder purchaseOrder : purchaseOrders) {
//            PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(
//                    purchaseOrder.getId(),
//                    purchaseOrder.getAnnouncementDTO().getProperty().getId(),
//                    purchaseOrder.getOrderAmount(),
//                    purchaseOrder.isAccepted()
//            );
//            purchaseOrderDTOs.add(purchaseOrderDTO);
//        }
//
//        return purchaseOrderDTOs;
//    }
//
//    public void sortPurchaseOrdersByAmount(List<PurchaseOrderDTO> purchaseOrders) {
//        purchaseOrders.sort(Comparator.comparingDouble(PurchaseOrderDTO::getOfferAmount).reversed());
//    }
//
//    public void acceptPurchaseOrder(String orderId) {
//        PurchaseOrder purchaseOrder = purchaseOrderRepository.getPurchaseOrderById(orderId);
//
//        // Update the accepted purchase order
//        purchaseOrder.accept();
//
//        // Decline all other purchase orders for the same property
//        declineOtherPurchaseOrders(purchaseOrder);
//
//        // Send email notification to the customer
////        sendEmailNotification(purchaseOrder.getAnnouncementDTO().getCustomerEmail(), "Purchase Order Accepted");
//    }
//
//    public void declinePurchaseOrder(String orderId) {
//        PurchaseOrder purchaseOrder = purchaseOrderRepository.get(orderId);
//
//        // Update the declined purchase order
//        purchaseOrder.decline();
//
//        // Send email notification to the customer
//        sendEmailNotification(purchaseOrder.getAnnouncementDTO().getCustomerEmail(), "Purchase Order Declined");
//    }
//
//    private void declineOtherPurchaseOrders(PurchaseOrder acceptedOrder) {
//        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getPurchaseOrdersByProperty(
//                acceptedOrder.getAnnouncementDTO().getProperty().getId());
//
//        for (PurchaseOrder order : purchaseOrders) {
//            if (!order.getId().equals(acceptedOrder.getId())) {
//                order.decline();
//            }
//        }
//    }
//
//    private void sendEmailNotification(String customerEmail, String message) {
//        EmailNotification.sendEmail(customerEmail, message);
//    }
//}

