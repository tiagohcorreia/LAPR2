package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PlaceOrderToBuyPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.exceptions.NegativeNumberException;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

/**
 * The type Place order to buy property ui.
 */
public class PlaceOrderToBuyPropertyUI implements Runnable {

    private PlaceOrderToBuyPropertyController controller = new PlaceOrderToBuyPropertyController(new PlaceOrderToBuyPropertyRepository());

    /**
     * Instantiates a new Place order to buy property ui.
     *
     * @param controller the controller
     */
    public PlaceOrderToBuyPropertyUI(PlaceOrderToBuyPropertyController controller) {
        //this.controller = controller;
    }

    @Override
    public void run() {

        boolean success = true;

        while(success) {

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.announcementDTOList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property");


            //OrderAmount
            Double orderAmount = Utils.readDoubleFromConsole("Insert order amount: ");


            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    this.controller.createOrder(orderAmount, posAnouncement);
                    success = false;

                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                System.out.println("=== Review Order Detail ===");
                System.out.println("Order amount: " + orderAmount + "$");
                System.out.println("Selected Announcement:\n" + posAnouncement.toString());

            } else {

                System.err.println("Operation Canceled");
            }
        }

    }
}
