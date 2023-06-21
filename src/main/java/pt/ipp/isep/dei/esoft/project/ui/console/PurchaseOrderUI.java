package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PurchaseOrderController;
import pt.ipp.isep.dei.esoft.project.domain.model.NotificationService;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmailService;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class PurchaseOrderUI implements Runnable {
    private final PurchaseOrderController controller;
    private Property property;
    private final NotificationService notificationService;


        public PurchaseOrderUI() {
            this.controller = new PurchaseOrderController();
            this.notificationService = new NotificationService();
        }

        public void run() {
            while (true) {
                System.out.println("=== Purchase Order Menu ===");
                System.out.println("1. List purchase orders");
                System.out.println("0. Exit");
                int option = Utils.readIntegerFromConsole("Enter your option: ");

                switch (option) {
                    case 1:
                        listAndProcessPurchaseOrders();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        private void listAndProcessPurchaseOrders() {
            List<Order> purchaseOrders = controller.getPurchaseOrdersByProperty();

            if (purchaseOrders.isEmpty()) {
                System.out.println("No purchase orders found.");
            } else {
                System.out.println("List of Purchase Orders:");
                for (int i = 0; i < purchaseOrders.size(); i++) {
                    Order purchaseOrder = purchaseOrders.get(i);
                    System.out.println((i + 1) + ". " + purchaseOrder);
                }

                int option = Utils.readIntegerFromConsole("Select a purchase order to process (0 to cancel): ");

                if (option > 0 && option <= purchaseOrders.size()) {
                    Order selectedPurchaseOrder = purchaseOrders.get(option - 1);
                    processPurchaseOrder(selectedPurchaseOrder);
                } else {
                    System.out.println("Invalid option. Purchase order not processed.");
                }
            }
        }

        private void processPurchaseOrder(Order purchaseOrder) {
            System.out.println("Selected purchase order: " + purchaseOrder);

            int choice = Utils.readIntegerFromConsole("1. Accept\n2. Decline\nEnter your choice: ");

            switch (choice) {
                case 1:
                    controller.acceptPurchaseOrder(purchaseOrder);
                    System.out.println("Purchase order accepted.");
                    sendEmailNotification(purchaseOrder, true);
                    break;
                case 2:
                    controller.declinePurchaseOrder(purchaseOrder);
                    System.out.println("Purchase order declined.");
                    sendEmailNotification(purchaseOrder, false);
                    break;
                default:
                    System.out.println("Invalid choice. Purchase order not processed.");
                    break;
            }
        }

        private void sendEmailNotification(Order purchaseOrder, boolean accepted) {
            String emailContent;
            if (accepted) {
                emailContent = "Your purchase order for property " + purchaseOrder.getAnnouncementDTO().getProperty().getLocation()
                        + " has been accepted.";
            } else {
                emailContent = "Your purchase order for property " + purchaseOrder.getAnnouncementDTO().getProperty().getLocation()
                        + " has been declined.";
            }

            notificationService.sendNotification(purchaseOrder.getClient().getEmail(), "Purchase Order Notification", emailContent);
            System.out.println("Email notification sent to client: " + purchaseOrder.getClient().getEmail());
        }
    }
