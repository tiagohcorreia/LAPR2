package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementLocationComparator;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementPriceComparator;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.application.controller.DisplayAnnouncementsController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayAnnouncementsUI implements Runnable{
    private static final DisplayAnnouncementsController controller = new DisplayAnnouncementsController();

    @Override
    public void run() {
        runUS();
    }

    public List<List<Object>> getAvailableFields(){
        return controller.getAvailableFields();
    }

    public boolean displayAvailableFields(List<List<Object>> availableFields){
        if (availableFields.get(0).size() == 0){
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
        }
        return false;
    }

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
                System.out.println("Please try again.");
            }
        } while (!availableFields.get(0).contains(selectedTypeOfBusiness) && !selectedTypeOfBusiness.equals(""));

        //  -Type of property
        String selectedTypeOfProperty=null;
        do {
            try {
                selectedTypeOfProperty = Utils.readLineFromConsole("Type of property: ").trim().toUpperCase();
                selectedData[1] = selectedTypeOfProperty;
            } catch (Exception e){
                System.out.println("Please try again.");
            }
        } while (!availableFields.get(1).contains(selectedTypeOfProperty) && !selectedTypeOfProperty.equals(""));

//        int selectedNumberOfBedrooms = -1;
//        String input = null;
//        if(!selectedTypeOfProperty.equals("LAND")) {
//            do {
//                try {
//                    input = Utils.readLineFromConsole("Number of bedrooms: ").trim();
//                    selectedNumberOfBedrooms = (input.equals("")) ? -1 : Integer.parseInt(input);
//                    selectedData[2] = String.valueOf(selectedNumberOfBedrooms);
//                } catch (Exception e){
//                    selectedNumberOfBedrooms = -1;
//                    System.out.println("Please try again.");
//                }
//            } while (!availableFields.get(2).contains(selectedNumberOfBedrooms) && selectedNumberOfBedrooms == -1 && !input.equals(""));
//        }

        //  -Number of bedrooms
        //(only displayed if the selected property type is not "LAND")
        String selectedNumberOfBedrooms = null;
        if(!selectedTypeOfProperty.equals("LAND")) {
            do {
                try {
                    selectedNumberOfBedrooms = Utils.readLineFromConsole("Number of bedrooms: ").trim();
                    selectedData[2] = selectedNumberOfBedrooms;
                } catch (Exception e){
                    System.out.println("Please try again.");
                }
//            } while (!availableFields.get(2).contains(selectedNumberOfBedrooms) && selectedNumberOfBedrooms == -1 && !input.equals(""));
            } while (!availableFields.get(1).toString().contains(String.valueOf(selectedNumberOfBedrooms)) && !selectedNumberOfBedrooms.equals(""));

    }

        if (selectedData[0].equals("") && selectedData[1].equals("") && selectedData[2].equals(""))
            return null;
        else
            return selectedData;
    }

    public List<Announcement> getMatchingAnnouncements(String[] selectedData){
        return controller.getAnnouncements(selectedData[0], selectedData[1], Integer.parseInt(selectedData[2]));
    }

    public List<Announcement> sortAnnouncements(int sortingMode, List<Announcement> announcements){
        switch (sortingMode){
            case 1:
                //sort by price
                announcements.sort(new AnnouncementPriceComparator());
                break;
            case 2:
                //sort by city
                announcements.sort(new AnnouncementLocationComparator());
        }
        return announcements;
    }

    private boolean runUS(){
        List<List<Object>> availableFields = getAvailableFields();
        if (displayAvailableFields(availableFields))
            return true;
        String[] selectedData = requestFilterData(availableFields);
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        if (selectedData == null)
            matchingAnnouncements = getMatchingAnnouncements(selectedData);
        else
            matchingAnnouncements = controller.getAllVisibleAnnouncements();
        //Reverse the list so it shows most recent announcements first
        Collections.reverse(matchingAnnouncements);
        displayAnnouncements(matchingAnnouncements);


        //Select sorting mode
        int sortingMode = -1;
        while(sortingMode != 0) {
            System.out.println("Sorting options");
            System.out.println("1 - Price");
            System.out.println("2 - City");

            while(sortingMode != 1 && sortingMode != 2){
                try{
                    sortingMode = Utils.readIntegerFromConsole("Sorting mode: ");
                } catch (Exception e){
                    System.out.println(e.getMessage() + "Por favor tente novamente.");
                }
            }

            matchingAnnouncements = sortAnnouncements(sortingMode, matchingAnnouncements);
            displayAnnouncements(matchingAnnouncements);

        }

        return false;
    }

    private void displayAnnouncements(List<Announcement> matchingAnnouncements) {
        for(Announcement announcement : matchingAnnouncements){
            System.out.println(announcement.toString());
        }
    }
}
