package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PurchaseOrderController;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;

import java.util.List;
import java.util.Scanner;

public class PurchaseOrderUI implements Runnable {

    private final Scanner scanner;
    private final PurchaseOrderController purchaseOrderController;
    private Property property;

    public PurchaseOrderUI() {
        scanner = new Scanner(System.in);
        purchaseOrderController = new PurchaseOrderController();
    }

    public void run() {
        while (true) {
            System.out.println("1. List purchase orders");
            System.out.println("2. Accept purchase order");
            System.out.println("3. Decline purchase order");
            System.out.println("4. Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    List<PurchaseOrder> purchaseOrders = purchaseOrderController.getPurchaseOrdersByProperty(property);
                    purchaseOrders.forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Enter the id of the purchase order to accept:");
                    String acceptId = scanner.nextLine();
                    purchaseOrderController.acceptPurchaseOrder(acceptId, "agent@example.com"); // replace with the agent's email
                    break;
                case "3":
                    System.out.println("Enter the id of the purchase order to decline:");
                    String declineId = scanner.nextLine();
                    purchaseOrderController.declinePurchaseOrder(declineId, "agent@example.com"); // replace with the agent's email
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
