package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PlaceOrderToBuyPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class PlaceOrderToBuyPropertyUI implements Runnable {

    private PlaceOrderToBuyPropertyController controller = new PlaceOrderToBuyPropertyController(new PlaceOrderToBuyPropertyRepository());

    public PlaceOrderToBuyPropertyUI(PlaceOrderToBuyPropertyController controller) {
        //this.controller = controller;
    }

    @Override
    public void run() {

        boolean success = true;

        while(success) {

            //List of anouncements


            //OrderAmount
            Double orderAmount = Utils.readDoubleFromConsole("Insert order amount: ");


            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    //this.controller.createOrder();
                    success = false;


                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                System.out.println();
                System.out.println();

            } else {

                System.err.println("Operation Canceled");
            }
        }

    }
}
