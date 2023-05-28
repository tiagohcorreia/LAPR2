//package pt.ipp.isep.dei.esoft.project.ui.console;
//
//import pt.ipp.isep.dei.esoft.project.application.controller.PlaceOrderToBuyPropertyController;
//import pt.ipp.isep.dei.esoft.project.application.controller.PurchaseOrderController;
//import pt.ipp.isep.dei.esoft.project.domain.model.Property;
//import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
//import pt.ipp.isep.dei.esoft.project.domain.model.PurchaseOrder;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class PurchaseOrderUI implements Runnable{
//
//    private PurchaseOrderController controller;
//    private Property property;
//    private Scanner scanner;
//
//    public PurchaseOrderUI() {
//        this.controller = new PurchaseOrderController();
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void run() {
//        while (true) {
//            System.out.println("\n=============== Real Estate USA ===============\n ");
//            System.out.println("1. List Purchase Orders");
//            System.out.println("2. Accept or Decline Purchase Order");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "1":
//                    listPurchaseOrders();
//                    break;
//                case "2":
//                    handlePurchaseOrder();
//                    break;
//                case "3":
//                    return;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private void listPurchaseOrders() {
//        List<PurchaseOrder> orders = controller.getPurchaseOrdersByProperty(property);
//        if (orders.isEmpty()) {
//            System.out.println("No purchase orders found.");
//            return;
//        }
//        for (PurchaseOrder order : orders) {
//            System.out.println(order);
//        }
//    }
//
//    private void handlePurchaseOrder() {
//        System.out.print("Enter the id of the purchase order you want to handle: ");
//        String id = scanner.nextLine();
//        PurchaseOrder order = controller.getPurchaseOrderById(id);
//        if (order == null) {
//            System.out.println("No purchase order found with the provided id.");
//            return;
//        }
//        System.out.println("1. Accept");
//        System.out.println("2. Decline");
//        System.out.print("Choose an action: ");
//        String action = scanner.nextLine();
//        switch (action) {
//            case "1":
//                controller.acceptPurchaseOrder(order);
//                System.out.println("Purchase order accepted.");
//                break;
//            case "2":
//                controller.declinePurchaseOrder(order);
//                System.out.println("Purchase order declined.");
//                break;
//            default:
//                System.out.println("Invalid action. Please try again.");
//        }
//    }
//}
