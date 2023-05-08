package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementLocationComparator;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementPriceComparator;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.application.controller.DisplayAnnouncementsController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Display announcements ui.
 */
public class DisplayAnnouncementsUI implements Runnable{
    private static final DisplayAnnouncementsController controller = new DisplayAnnouncementsController();

    @Override
    public void run() {
        runUS();
    }

    /**
     * Get available fields list.
     *
     * @return the list
     */
    public List<List<Object>> getAvailableFields(){
        return controller.getAvailableFields();
    }

    /**
     * Display available fields boolean.
     *
     * @param availableFields the available fields
     * @return the boolean
     */
    public boolean displayAvailableFields(List<List<Object>> availableFields){
        if (availableFields.get(0).size() == 0) {
            System.out.println("There are no announcements registered in the system.");
            Utils.readLineFromConsole("Press [Enter] to continue");
            return true;
        }
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

        return false;
    }

    /**
     * Request filter data string [ ].
     *
     * @param availableFields the available fields
     * @return the string [ ]
     */
    public String[] requestFilterData(List<List<Object>> availableFields){
        String[] selectedData = new String[3];

        //Getting user data
        //  -Type of business
        String selectedTypeOfBusiness=null;
        do {
            try {
                selectedTypeOfBusiness = Utils.readLineFromConsole("Type of business: ").trim().toUpperCase();
                selectedData[0] = selectedTypeOfBusiness;
            } catch (Exception e){
                System.out.println(e.getMessage() + "Please try again.");
            }
        } while (!availableFields.get(0).contains(selectedTypeOfBusiness) && !selectedTypeOfBusiness.equals(""));

        //  -Type of property
        String selectedTypeOfProperty=null;
        do {
            try {
                selectedTypeOfProperty = Utils.readLineFromConsole("Type of property: ").trim().toUpperCase();
                selectedData[1] = selectedTypeOfProperty;
            } catch (Exception e){
                System.out.println(e.getMessage() + "Please try again.");
            }
        } while (!availableFields.get(1).contains(selectedTypeOfProperty) && !selectedTypeOfProperty.equals(""));

        //  -Number of bedrooms
        //(only displayed if the selected property type is not "LAND")
        String selectedNumberOfBedrooms = null;
        int bedrooms = -1;
        if(!selectedTypeOfProperty.equals("LAND")) {
            do {
                try {
                    selectedNumberOfBedrooms = Utils.readLineFromConsole("Number of bedrooms: ").trim();
                    selectedData[2] = selectedNumberOfBedrooms;
                    bedrooms = Integer.parseInt(selectedNumberOfBedrooms);
                } catch (Exception e){
                    System.out.println(e.getMessage() + "Please try again.");
                }
            } while (!availableFields.get(2).contains(bedrooms) && !selectedNumberOfBedrooms.equals(""));

        } else
            selectedData[2] = "-1";

        if (selectedData[0].equals("") && selectedData[1].equals("") && selectedData[2].equals(""))
            return null;
        else
            return selectedData;
    }

    /**
     * Get matching announcements list.
     *
     * @param selectedData the selected data
     * @return the list
     */
    public List<Announcement> getMatchingAnnouncements(String[] selectedData){
        if(selectedData[2].equals(""))
            return controller.getAnnouncements(selectedData[0], selectedData[1], -1);
        else
            return controller.getAnnouncements(selectedData[0], selectedData[1], Integer.parseInt(selectedData[2]));
    }

    /**
     * Sort announcements list.
     *
     * @param sortingMode   the sorting mode
     * @param announcements the announcements
     * @return the list
     */
    public List<Announcement> sortAnnouncements(int sortingMode, List<Announcement> announcements){
        switch (sortingMode) {
            case 1 ->
                    //sort by price
                    announcements.sort(new AnnouncementPriceComparator());
            case 2 ->
                    //sort by city
                    announcements.sort(new AnnouncementLocationComparator());
            default -> {
            }
        }
        return announcements;
    }

    private void runUS(){
        List<List<Object>> availableFields = getAvailableFields();
        if (displayAvailableFields(availableFields))
            return;
        String[] selectedData = requestFilterData(availableFields);
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        if (selectedData == null) {
            matchingAnnouncements = controller.getAllVisibleAnnouncements();
        }
        else {
            matchingAnnouncements = getMatchingAnnouncements(selectedData);
        }
        //Reverse the list so it shows most recent announcements first
        Collections.reverse(matchingAnnouncements);
        displayAnnouncements(matchingAnnouncements);


        //Set sorting mode
        int sortingMode = -1;
        while(sortingMode != 0) {
            System.out.println("Sorting options");
            System.out.println("1 - Price");
            System.out.println("2 - City");
            System.out.println("0 - Exit");

            do{
                try{
                    sortingMode = Utils.readIntegerFromConsole("Sorting mode: ");
                } catch (Exception e){
                    System.out.println(e.getMessage() + "Por favor tente novamente.");
                }
            }while(sortingMode != 1 && sortingMode != 2 && sortingMode != 0);

            matchingAnnouncements = sortAnnouncements(sortingMode, matchingAnnouncements);
            displayAnnouncements(matchingAnnouncements);
        }
    }

    /**
     * Prints announcements list.
     *
     * @param matchingAnnouncements announcement list.
     */
    private void displayAnnouncements(List<Announcement> matchingAnnouncements) {
        System.out.println("Type\tProperty\tPrice\tLocation\tArea\tCenterDist\tNoBedrooms\tPhotographs\tAgent");
        for(Announcement announcement : matchingAnnouncements){
            //System.out.println(announcement.toString());
//            System.out.println(
//                    announcement.getTypeOfBusiness().toString() + "\t"
//                    + announcement.getProperty().getClass().getSimpleName() + "\t"
//                    + announcement.getPrice() + "\t"
//                    + announcement.getProperty().getArea() + "\t"
//
//            );
            System.out.println(announcement.getAnnouncementAsString());
        }
    }
}
