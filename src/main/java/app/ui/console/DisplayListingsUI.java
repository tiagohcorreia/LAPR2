package app.ui.console;

import app.domain.model.Listing;
import app.domain.shared.ListingPriceComparator;
import app.ui.console.utils.Utils;
import app.controller.DisplayListingsController;
import java.util.List;

public class DisplayListingsUI implements Runnable{

    @Override
    public void run() {
        displayListings();
    }

    private boolean displayListings(){
        DisplayListingsController controller = new DisplayListingsController();
        List<List<Object>> availableFields = controller.getAvailableFields();

        if (availableFields.get(0) == null){
            System.out.println("There are no announcements in the system.");
            return true;
        }

        else {
            System.out.println("Search filter:");
            System.out.println("(select from the available options)");
            System.out.println("Type of business - ");
            for (Object fields : availableFields.get(0)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();

            System.out.println("Type of property - ");
            for (Object fields : availableFields.get(1)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();

            System.out.println("Number of bedrooms - ");
            for (Object fields : availableFields.get(2)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();


            String selectedTypeOfBusiness;
            do {
                selectedTypeOfBusiness = Utils.readLineFromConsole("Type of business: ").toUpperCase();
            } while (!availableFields.get(0).toString().contains(selectedTypeOfBusiness));

            String selectedTypeOfProperty;
            do {
                selectedTypeOfProperty = Utils.readLineFromConsole("Type of property: ").toUpperCase();
            } while (!availableFields.get(1).toString().contains(selectedTypeOfProperty));

            int selectedNumberOfBedrooms;
            do {
                selectedNumberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms: ");
            } while (!availableFields.get(2).contains(selectedNumberOfBedrooms));


            List<Listing> listings;
            //TO-FIX
            if (selectedTypeOfBusiness.equals("") && selectedTypeOfProperty.equals("") && selectedNumberOfBedrooms == 0){
                listings = controller.getAllVisibleListings();
            } else {
                listings = controller.getListings(selectedTypeOfBusiness, selectedTypeOfProperty, selectedNumberOfBedrooms);
            }

            for (Listing listing : listings) {
                System.out.println(listing);
            }
//            while (sortingMode != 0) {
//
//                do {
//                    sortingMode = Utils.readIntegerFromConsole("Sorting modes:\n1 - Price\n2 - Parish\n0 - Exit\nSort by: ");
//                    if (sortingMode != 1 && sortingMode != 2 && sortingMode != 0) {
//                        System.out.println("Invalid selection, please try again");
//                    }
//                } while (sortingMode != 1 && sortingMode != 2);
//
//                if (sortingMode == 1) {
//                    ListingPriceComparator listingPriceComparator = new ListingPriceComparator();
//                    matchingListings.sort(listingPriceComparator);
//                    for (Listing matchingListing : matchingListings) {
//                        System.out.println(matchingListing);
//                    }
//                } else {
//
//                }
//            }

            int sortingMode = -1;
            boolean sortingModeIsValid = false;
            while (sortingMode != 0){
                do{
                    sortingMode = Utils.readIntegerFromConsole("Sorting modes:\n1 - Price\n2 - Parish\n0 - Exit\nSort by: ");
                    if (sortingMode == 1 || sortingMode == 2 || sortingMode == 0) {
                        sortingModeIsValid = true;
                    }
                    else {
                        System.out.println("Invalid selection, please try again");
                    }
                } while (!sortingModeIsValid);

                if (sortingMode == 1) {
                    ListingPriceComparator listingPriceComparator = new ListingPriceComparator();
                    listings.sort(listingPriceComparator);
                    for (Listing listing : listings) {
                        System.out.println(listing);
                    }
                } else if (sortingMode == 2){
                    //TODO
                }
            }
        }

        return false;
    }
}
