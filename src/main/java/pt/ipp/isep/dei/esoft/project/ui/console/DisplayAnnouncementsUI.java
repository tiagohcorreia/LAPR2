package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementLocationComparator;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementPriceComparator;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.application.controller.DisplayAnnouncementsController;

import java.util.Collections;
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
            System.out.println("SEARCH FILTER");
            System.out.println("- Select one from the following options");
            System.out.println("- Or press [Enter] to see all available announcements");
            System.out.println();
            System.out.print("Type of business - ");
            for (Object fields : availableFields.get(0)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();

            System.out.print("Type of property - ");
            for (Object fields : availableFields.get(1)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();

            System.out.print("Number of bedrooms - ");
            for (Object fields : availableFields.get(2)) {
                System.out.print(fields.toString() + " ");
            }
            System.out.println();

            //Getting user input
            String selectedTypeOfBusiness=null;
            do {
                try {
                    selectedTypeOfBusiness = Utils.readLineFromConsole("Type of business: ").trim().toUpperCase();
                } catch (Exception e){
                    System.out.println("Please try again.");
                }
            } while (!availableFields.get(0).toString().contains(selectedTypeOfBusiness) && !selectedTypeOfBusiness.equals(""));

            String selectedTypeOfProperty=null;
            do {
                try {
                    selectedTypeOfProperty = Utils.readLineFromConsole("Type of property: ").trim().toUpperCase();
                } catch (Exception e){
                    System.out.println("Please try again.");
                }
            } while (!availableFields.get(1).toString().contains(selectedTypeOfProperty) && !selectedTypeOfProperty.equals(""));

            int selectedNumberOfBedrooms = -1;
            String input = null;
            if(!selectedTypeOfProperty.equals("LAND")) {
                do {
                    try {
                        input = Utils.readLineFromConsole("Number of bedrooms: ").trim();
                        selectedNumberOfBedrooms = (input.equals("")) ? -1 : Integer.parseInt(input);
                    } catch (Exception e){
                        selectedNumberOfBedrooms = -1;
                        System.out.println("Please try again.");
                    }
                } while (!availableFields.get(2).contains(selectedNumberOfBedrooms) && selectedNumberOfBedrooms == -1 && !input.equals(""));
            }

            //Get matching announcements
            //Default order is oldest first
            List<Announcement> announcements;
            //TO-FIX
            if (selectedTypeOfBusiness.equals("") && selectedTypeOfProperty.equals("") && selectedNumberOfBedrooms == -1){
                announcements = controller.getAllVisibleAnnouncements();
            } else {
                announcements = controller.getAnnouncements(selectedTypeOfBusiness, selectedTypeOfProperty, selectedNumberOfBedrooms);
            }

            Collections.reverse(announcements);

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
                    sortingMode = Utils.readIntegerFromConsole("Sorting modes:\n1 - Price\n2 - City\n0 - Exit\nSort by: ");
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
                    AnnouncementLocationComparator announcementLocationComparator = new AnnouncementLocationComparator();
                    announcements.sort(announcementLocationComparator);
                    for (Announcement announcement : announcements) {
                        System.out.println(announcement);
                    }
                }
            }
        }

        return false;
    }
}
