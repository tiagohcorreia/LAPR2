package app.ui.console;

import app.domain.model.Announcement;
import app.domain.shared.AnnouncementPriceComparator;
import app.domain.shared.TypeOfProperty;
import app.ui.console.utils.Utils;
import app.controller.DisplayAnnouncementsController;
import java.util.List;

public class DisplayAnnouncementsUI implements Runnable{

    @Override
    public void run() {
        displayAnnouncements();
    }

    private boolean displayAnnouncements(){
        DisplayAnnouncementsController controller = new DisplayAnnouncementsController();
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

            int selectedNumberOfBedrooms = -1;

            if(!selectedTypeOfProperty.equals(TypeOfProperty.LAND.toString()))
                do {
                    selectedNumberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms: ");
                } while (!availableFields.get(2).contains(selectedNumberOfBedrooms));




            List<Announcement> announcements;
            //TO-FIX
            if (selectedTypeOfBusiness.equals("") && selectedTypeOfProperty.equals("") && selectedNumberOfBedrooms == -1){
                announcements = controller.getAllVisibleAnnouncements();
            } else {
                announcements = controller.getAnnouncements(selectedTypeOfBusiness, selectedTypeOfProperty, selectedNumberOfBedrooms);
            }

            for (Announcement announcement : announcements) {
                System.out.println(announcement);
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
//                    for (Announcement matchingListing : matchingListings) {
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
                    AnnouncementPriceComparator announcementPriceComparator = new AnnouncementPriceComparator();
                    announcements.sort(announcementPriceComparator);
                    for (Announcement announcement : announcements) {
                        System.out.println(announcement);
                    }
                } else if (sortingMode == 2){
                    //TODO
                }
            }
        }

        return false;
    }
}
