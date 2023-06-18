package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PlaceOrderToBuyPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


import java.util.List;

/**
 * The type Place order to buy property ui.
 */
public class PlaceOrderToBuyPropertyUI implements Runnable {

    private PlaceOrderToBuyPropertyController controller = new PlaceOrderToBuyPropertyController();

    @Override
    public void run() {

        boolean success = true;

        while(success) {

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.announcementDTOList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property");
            AnnouncementDTO announcement = controller.getAnnouncementByPos(posAnouncement);

            //OrderAmount
            Double orderAmount = Utils.readDoubleFromConsole("Insert order amount: ");

            //Client

            //Status
            boolean status = false;

            System.out.println("=== Review Order Detail ===");
            System.out.println("Status: " + status);
            System.out.println("Order amount: " + orderAmount + "$");
            System.out.println("Selected Announcement: " + announcement);

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    this.controller.createOrder(orderAmount, announcement, status);
                    System.out.println("Order created with success");
                    success = false;

                } catch (IllegalArgumentException e) {

                    System.err.println(e.getMessage());

                } catch (Exception e) {

                    System.err.println("Something went wrong");
                }

            } else {

                System.err.println("Operation Canceled");
            }
        }

    }
}
