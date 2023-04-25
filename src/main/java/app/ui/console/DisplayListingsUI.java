package app.ui.console;

import app.domain.model.Listing;
import app.ui.console.utils.Utils;
import app.controller.DisplayListingsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DisplayListingsUI implements Runnable{

    @Override
    public void run() {

    }

    private boolean displayListings(){
        DisplayListingsController controller = new DisplayListingsController();
        List<List<Object>> availableFields = controller.getAvailableFields();


        System.out.println("Search filter:");
        System.out.println("(select from the available options)");
        System.out.println("Type of business - ");
        for (Object fields : availableFields.get(0)){
            System.out.print(fields.toString() + " ");
        }
        System.out.println();

        System.out.println("Type of property - ");
        for (Object fields : availableFields.get(1)){
            System.out.print(fields.toString() + " ");
        }
        System.out.println();

        System.out.println("Number of bedrooms - ");
        for (Object fields : availableFields.get(2)){
            System.out.print(fields.toString() + " ");
        }
        System.out.println();


        String selectedTypeOfBusiness;
        do {
            selectedTypeOfBusiness = Utils.readLineFromConsole("Type of business: ").toUpperCase(Locale.ROOT);
        } while (!availableFields.get(0).toString().contains(selectedTypeOfBusiness));

        String selectedTypeOfProperty;
        do {
            selectedTypeOfProperty = Utils.readLineFromConsole("Type of property: ").toUpperCase(Locale.ROOT);
        } while (!availableFields.get(1).toString().contains(selectedTypeOfProperty));


        int selectedNumberOfBedrooms;
        do {
            selectedNumberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms: ");
        } while (!availableFields.get(2).contains(selectedNumberOfBedrooms));

        List<Listing> matchingListings = controller.getListings(selectedTypeOfBusiness, selectedTypeOfProperty, selectedNumberOfBedrooms);

        for (Listing matchingListing: matchingListings){
            System.out.println(matchingListing);
        }





        //TODO
        int sortingMode;

        do {
            sortingMode = Utils.readIntegerFromConsole("Sorting modes:\n1 - Price\n2 - Parish\n0 - Exit\nSort by: ");
            if(sortingMode != 1 && sortingMode != 2 && sortingMode != 3){
                System.out.println("Invalid selection, please try again");
            }
        } while (sortingMode != 1 && sortingMode != 2);

        if(sortingMode == 1){
            //matchingListings.sort();
        }





        return false;
    }
}
