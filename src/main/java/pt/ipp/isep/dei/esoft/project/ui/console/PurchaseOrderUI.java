package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PurchaseOrderController;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class PurchaseOrderUI implements Runnable {
    private final PurchaseOrderController controller;
    private Property property;

    public PurchaseOrderUI() {
        this.controller = new PurchaseOrderController();
    }

    public void run() {

        while (true) {
            System.out.println("=== Purchase Order Menu ===");
            System.out.println("1. List purchase orders");
            System.out.println("2. Accept purchase order");
            System.out.println("3. Decline purchase order");
            System.out.println("0. Exit");
            int option = Utils.readIntegerFromConsole("Enter your option: ");

            switch (option) {
                case 1:
                    listPurchaseOrders();
                    break;
                case 2:
                    acceptPurchaseOrder();
                    break;
                case 3:
                    declinePurchaseOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void listPurchaseOrders() {
        List<Order> purchaseOrders = controller.getPurchaseOrdersByProperty(property);

        if (purchaseOrders.isEmpty()) {
            System.out.println("No purchase orders found.");
        } else {
            System.out.println("List of Purchase Orders:");
            for (int i = 0; i < purchaseOrders.size(); i++) {
                Order purchaseOrder = purchaseOrders.get(i);
                System.out.println((i + 1) + ". " + purchaseOrder);
            }
        }
    }

    private void acceptPurchaseOrder() {
        List<Order> purchaseOrders = controller.getPurchaseOrdersByProperty(property);

        if (purchaseOrders.isEmpty()) {
            System.out.println("No purchase orders found.");
        } else {
            int option = Utils.readIntegerFromConsole("Select a purchase order to accept (0 to cancel): ");

            if (option > 0 && option <= purchaseOrders.size()) {
                Order selectedPurchaseOrder = purchaseOrders.get(option - 1);
                controller.acceptPurchaseOrder(selectedPurchaseOrder);
                controller.declineOtherPurchaseOrders(selectedPurchaseOrder.getAnnouncementDTO().getProperty());
                sendEmailNotification(selectedPurchaseOrder, true);
            } else {
                System.out.println("Invalid option. Purchase order not accepted.");
            }
        }
    }

    private void declinePurchaseOrder() {
        List<Order> purchaseOrders = controller.getPurchaseOrdersByProperty(property);

        if (purchaseOrders.isEmpty()) {
            System.out.println("No purchase orders found.");
        } else {
            int option = Utils.readIntegerFromConsole("Select a purchase order to decline (0 to cancel): ");

            if (option > 0 && option <= purchaseOrders.size()) {
                Order selectedPurchaseOrder = purchaseOrders.get(option - 1);
                controller.declinePurchaseOrder(selectedPurchaseOrder);
                sendEmailNotification(selectedPurchaseOrder, false);
            } else {
                System.out.println("Invalid option. Purchase order not declined.");
            }
        }
    }

    private void sendEmailNotification(Order purchaseOrder, boolean accepted) {
        String emailContent;
        if (accepted) {
            emailContent = "Your purchase order for property " + purchaseOrder.getAnnouncementDTO().getProperty().getId()
                    + " has been accepted.";
        } else {
            emailContent = "Your purchase order for property " + purchaseOrder.getAnnouncementDTO().getProperty().getId()
                    + " has been declined.";
        }

        Utils.sendEmail(purchaseOrder.getClient().getEmail(), emailContent);
        System.out.println("Email notification sent to client: " + purchaseOrder.getClient().getEmail());
    }
}