package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;

import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The type Register property ui.
 */
public class RegisterPropertyUI implements Runnable {

    private RegisterPropertyController controller;

    /**
     * Instantiates a new Register property ui.
     *
     * @param controller the controller
     */
    public RegisterPropertyUI(RegisterPropertyController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        boolean success = true;

        while (success) {

            TypeOfBusiness sellOrRent;
            TypeOfProperty typeProperty;
            int numberOfBedrooms = 0;
            int numberOfBathrooms = 0;
            int numberOfParkingSpaces = 0;
            ArrayList<String> equipmentList = new ArrayList();
            int numberEquipment = 1;
            String equipment = "";
            boolean hasBasement = false;
            boolean hasInhabitalLoft = false;
            String hasBasementString="";
            String hasInhabitalLoftString="";
            SunExposure sunExposure = null;
            int area;
            Location location;
            int cityCenterDistance;
            float price;
            ArrayList<String> photographs = new ArrayList();
            String photo;
            int numberPhotos = 1;
            String agent;
            Employee choosedAgent;
            Date date = null;



            // date
            String dateString = Utils.readLineFromConsole("Insert the date (YYYY-MM-DD):");


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                 date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }


            //Type of property
            List<TypeOfProperty> x = this.controller.getTypeOfPropertyAsList();
            Utils.showList(x, "Type of Property");
            Integer posTypeOfProperty = Utils.readIntegerFromConsole("Choose the type of property: ");
            typeProperty = TypeOfProperty.getTypeOfPropertyById(posTypeOfProperty);

            //area in m2
            area = Utils.readIntegerFromConsole("Insert area in m2: ");

            //Location
            String city = Utils.readLineFromConsole("Insert the city:");
            location = null;

            City existingCity = this.controller.getCity(city);
            if (existingCity != null) {

                String street = Utils.readLineFromConsole("Insert the street:");
                String postalCode = Utils.readLineFromConsole("Insert the postal code:");


                location = new Location(street, postalCode, existingCity);
            } else {

                System.out.println("City not found in the repository. Please enter a valid city.");
            }

            //area in m2
            cityCenterDistance = Utils.readIntegerFromConsole("Insert the distance from the centre: ");

            //Photographs
            numberPhotos = Utils.readIntegerFromConsole("Insert how many photos you want to add: ");
            for (int i = 0; i < numberPhotos; i++) {
                photo = Utils.readLineFromConsole("Insert the path of the photo " + i + 1 + ": ");
                photographs.add(photo);
            }

            if (posTypeOfProperty == 1 || posTypeOfProperty == 2) {

                //Number of bedrooms
                numberOfBedrooms = Utils.readIntegerFromConsole("Insert Number of bedrooms: ");

                //Number of  bathrooms
                numberOfBathrooms = Utils.readIntegerFromConsole("Insert Number of bathrooms: ");

                //Number of parking spaces
                numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert Number of Parking Spaces: ");

                //Equipment Available
                numberEquipment = Utils.readIntegerFromConsole("Insert how many equipments you want to add: ");
                for (int i = 0; i < numberEquipment; i++) {
                    equipment = Utils.readLineFromConsole("Insert the equipment: ");
                    equipmentList.add(equipment);
                }
            }
            if (posTypeOfProperty == 1) {

                int hasBasementInt = Utils.readIntegerFromConsole("The house has a basement? \n0. NO\n1. YES");
                if (hasBasementInt == 0) {
                    hasBasement = false;
                    hasBasementString="No";
                } else {
                    hasBasement = true;
                    hasBasementString= "Yes";
                }
                int hasInhabitalLoftInt = Utils.readIntegerFromConsole("The house has an inhabitalLoft? \n0. NO\n1. YES");
                if (hasInhabitalLoftInt == 0) {
                    hasInhabitalLoft = false;
                    hasInhabitalLoftString="No";
                } else {
                    hasInhabitalLoft = true;
                    hasInhabitalLoftString="Yes";
                }

                //SunExposure
                List<SunExposure> y = this.controller.getSunExposureAsList();
                Utils.showList(y, "SunExposure");
                Integer posSunExposure = Utils.readIntegerFromConsole("Choose the sunExposure: ");
                sunExposure = SunExposure.getSunExposureById(posSunExposure);
            }


            //price
            price = (float) Utils.readDoubleFromConsole("Insert the price of the property: ");

            //agent
            List<Employee> agentsList = this.controller.getAgent();
            Utils.showList(agentsList, "Agents List");
            agent = Utils.readLineFromConsole("Insert the Name of the responsible agent: ");
            choosedAgent = this.controller.getEmployee(agent);


            //Sell or Rent a property
            List<TypeOfBusiness> z = this.controller.getTypeOfBusinessAsList();
            Utils.showList(z, "Type of Business");
            Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
            sellOrRent = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    this.controller.createAnnouncement(date, sellOrRent, posTypeOfProperty, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, equipmentList, hasBasement, hasInhabitalLoft,
                            sunExposure, area, location, cityCenterDistance, price, photographs, choosedAgent);
                    success = false;
                    if (success) {

                        System.out.println("Please insert Announcement data again");
                    }

                } catch (IllegalArgumentException e) {

                    System.err.println(e.getMessage());

                } catch (NullPointerException e) {

                    System.err.println(e.getMessage());

                }


                System.out.println("Type of Business: " + sellOrRent);
                System.out.println("Type of property: " + typeProperty);
                if (posTypeOfProperty == 1 || posTypeOfProperty == 2) {

                    System.out.println("Number of bedrooms: " + numberOfBedrooms);
                    System.out.println("Number of bathrooms: " + numberOfBathrooms);
                    System.out.println("Number of parking spaces: " + numberOfParkingSpaces);
                    System.out.println("Equipment available: " + equipmentList);

                }
                if (posTypeOfProperty == 1) {
                    System.out.println("The house has basement? " + hasBasementString);
                    System.out.println("The house has inhabital loft? " + hasInhabitalLoftString);
                    System.out.println("The house has sun exposure? " + sunExposure);
                }
                System.out.println("Area: " + area + " m2");
                System.out.println("Location: " + location);
                System.out.println("Distance of Centre: " + cityCenterDistance+" Km");
                System.out.println("Price: " + price + "$");
                System.out.println("Responsible Agent: " + choosedAgent.getName());

            } else {
                System.err.println("Operation Canceled!");
            }

        }
    }
}
