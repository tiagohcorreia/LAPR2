package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;



import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Publish announcement ui.
 */
public class PublishAnnouncementUI implements Runnable {
    private Scanner scanner;

    private final PublishAnnouncementController controller;
    private final AuthenticationController authenticationController;

    /**
     * Instantiates a new Publish announcement ui.
     */
    public PublishAnnouncementUI() {
        Scanner scanner = new Scanner(System.in);
        this.controller = new PublishAnnouncementController();
        this.authenticationController = new AuthenticationController();


    }

    public void run() {

        TypeOfBusiness sellOrRent;
        TypeOfProperty typeProperty;
        int bedrooms = 0;
        int bathrooms = 0;
        int parkingSpaces = 0;
        String equipment = "";
        boolean hasBasement = false;
        boolean hasLoft = false;
        SunExposure sunExposure = null;
        int area;
        Location location;
        int distance;
        float price;
        ArrayList<String> photographs = new ArrayList<>();
        String photo;
        ArrayList<String> availableEquipment = new ArrayList<>();
        LocalDate date=null;
        int doorNumber = 0;
        String street = null;
        int postalCode = 0;
        boolean confirmed = false;





        System.out.println("===== Publish a new announcement =====\n");

        //Agent
        //String agentsList = this.controller.getAgent().toString();
        String agentName = controller.getAgentName();


        //String agent = Utils.readLineFromConsole("Agent, insert your name:: ");
        // Employee agentResp = this.controller.getEmployee(agent);


        // date
        while (date == null) {
            //System.out.print("Enter the date (YYYY-MM-DD): ");
            String date1 = Utils.readLineFromConsole("Enter the date (YYYY-MM-DD): ");
            //String dateString = scanner.nextLine();

            try {
                date = LocalDate.parse(date1);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }
        }



        //typeOfBusiness
        List<TypeOfBusiness> typeOfBusinessList = this.controller.getTypeOfBusinessAsList();
        Utils.showList(typeOfBusinessList, "Type of Business");
        TypeOfBusiness selectedTypeOfBusiness = null;
        while (selectedTypeOfBusiness == null) {
            Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
            selectedTypeOfBusiness = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);
            if (selectedTypeOfBusiness == null) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        sellOrRent = selectedTypeOfBusiness;

        //TypeOfProperty
        List<TypeOfProperty> types = this.controller.getTypeOfPropertyAsList();
        System.out.println("Select the property type:");
        for (int i = 0; i < types.size(); i++) {
            System.out.println((i + 1) + " - " + types.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int posTypeOfProperty = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                posTypeOfProperty = scanner.nextInt();
                if (posTypeOfProperty > 0 && posTypeOfProperty <= types.size()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid, choose between 1 - 3 " + types.size() + ".");

                    scanner.next();
                }
            }
            TypeOfProperty selectedType = types.get(posTypeOfProperty - 1);

            // Dados comuns a todas as propriedades

            //area
            System.out.println("area (m2):");
            area = scanner.nextInt();
            scanner.nextLine();

            //location
            String city = Utils.readLineFromConsole("Insert the city:");

            City existingCity = this.controller.getCity(city);
            if (existingCity != null) {

                street = Utils.readLineFromConsole("Insert the street:");
                postalCode = Integer.parseInt(Utils.readLineFromConsole("Insert the postal code(5 digits):"));


            } else {

                System.out.println("City not found in the repository. Please enter a valid city.");
            }


            //distanceFromCityCenter
            System.out.println("Distance from city center(km2):");
            distance = scanner.nextInt();
            scanner.nextLine();

            //price
            System.out.println("price:");
            price = scanner.nextFloat();
            scanner.nextLine();

            //Commission
            System.out.println("Commission:");
            float commission = scanner.nextFloat();
            scanner.nextLine();


            //photographs
            System.out.println("Insert the photos");
            System.out.println("Type 'exit' to finish");
            photo= "";
            while (!photo.equalsIgnoreCase("exit")) {
                photo= scanner.nextLine();
                if (!photo.equalsIgnoreCase("exit")) {
                    photographs.add(photo);
                }
            }



            // Dados específicos de cada tipo de propriedade


            switch (posTypeOfProperty) {
                case 1: // House

                    doorNumber = Integer.getInteger(Utils.readLineFromConsole("Insert the door number:"));

                    //bedrroms
                    System.out.println("Number of bedrooms:");
                    bedrooms = scanner.nextInt();
                    scanner.nextLine();

                    //bathrooms
                    System.out.println("Number of bathrooms:");
                    bathrooms = scanner.nextInt();
                    scanner.nextLine();


                    //parkingSpaces
                    System.out.println("Number of parking spces:");
                    parkingSpaces = scanner.nextInt();
                    scanner.nextLine();

                    //availableEquipments
                    System.out.println("Insert the available Equipments");
                    System.out.println("Type 'exit' to finish");
                    equipment = "";
                    while (!equipment.equalsIgnoreCase("exit")) {
                        equipment = scanner.nextLine();
                        if (!equipment.equalsIgnoreCase("exit")) {
                            availableEquipment.add(equipment);
                        }
                    }

                    //basement
                    System.out.println("Has a basement? (yes/no)");
                    String basement = scanner.nextLine();
                    hasBasement = false;
                    if (basement.equalsIgnoreCase("yes")) {
                        hasBasement = true;
                    } else if (!basement.equalsIgnoreCase("no")) {
                        System.out.println("Invalid. Please, digit 'yes' or 'no'.");
                    }

                    //loft
                    System.out.println("Has an habitable loft? (yes/no)");
                    String loft = scanner.nextLine();
                    hasLoft = false;
                    if (loft.equalsIgnoreCase("yes")) {
                        hasLoft = true;
                    } else if (!loft.equalsIgnoreCase("no")) {
                        System.out.println("Invalid. Please, digit 'yes' or 'no'.");
                    }

                    //sunExposure
                    List<SunExposure> sunExposure1 = this.controller.getSunExposureAsList();
                    Utils.showList(sunExposure1, "SunExposure");
                    Integer posSunExposure = Utils.readIntegerFromConsole("Choose the sunExposure: ");
                    sunExposure = SunExposure.getSunExposureById(posSunExposure);


                    break;


                case 2: // Apartamento
                    doorNumber = Integer.getInteger(Utils.readLineFromConsole("Insert the door number:"));

                    //bedrroms
                    System.out.println("Number of bedrooms:");
                    bedrooms = scanner.nextInt();
                    scanner.nextLine();

                    //bathrooms
                    System.out.println("Number of bathrooms:");
                    bathrooms = scanner.nextInt();
                    scanner.nextLine();


                    //parkingSpaces
                    System.out.println("Number of parking spces:");
                    parkingSpaces = scanner.nextInt();
                    scanner.nextLine();

                    //availableEquipments

                    System.out.println("Insert the available Equipments");
                    System.out.println("Type 'exit' to finish");
                    equipment = "";
                    while (!equipment.equalsIgnoreCase("exit")) {
                        equipment = scanner.nextLine();
                        if (!equipment.equalsIgnoreCase("exit")) {
                            availableEquipment.add(equipment);
                        }
                    }
                    break;
                default:
                    System.out.println("invalid!");
                    break;
            }
            location = new Location(doorNumber, street, existingCity, postalCode);


            System.out.println("\n");
            System.out.println("===== Review Ad Details =====");
            System.out.println("Type of Business: " + sellOrRent);
            System.out.println("Type of property: " + selectedType);
            System.out.println("Photos: " + photographs);
            System.out.println("Area: " + area + " m2");
            System.out.println("Location: " + location);
            System.out.println("Distance of Centre: " + distance + "km2");
            System.out.println("Price: " + price + "$");


            if (posTypeOfProperty == 1 || posTypeOfProperty == 2) {

                System.out.println("Number of bedrooms: " + bedrooms);
                System.out.println("Number of bathrooms: " + bathrooms);
                System.out.println("Number of parking spaces: " + parkingSpaces);
                System.out.println("Available Equipments: " + availableEquipment);
            }


            if (posTypeOfProperty == 1) {
                if (hasBasement == true) {
                    System.out.println("Basement: yes");
                } else {
                    System.out.println("Basement: no");
                }
                if (hasLoft == true) {
                    System.out.println("Loft: yes");
                } else {
                    System.out.println("Loft: no");
                }
                System.out.println("Sun exposure: " + sunExposure);
            }
            System.out.println("Agent: " + agentName +"\n\n");
            System.out.print("Confirm ad creation (y/n)? \n");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("y")) {

                this.controller.createAnnouncement(date,sellOrRent, posTypeOfProperty, bedrooms, bathrooms, parkingSpaces, availableEquipment, hasBasement, hasLoft,
                        sunExposure, area, location, distance, commission, price, photographs, agentName);
                System.out.println("Ad created successfully!\n");
                confirmed = true;
            } else {
                System.out.print("Cancel (y/n)?");
                String cancel = scanner.next();
                if (cancel.equalsIgnoreCase("y")) {
                    System.out.println("Ad creation cancelled.\n");
                    confirmed = true;
                }
            }

        }
    }

}

