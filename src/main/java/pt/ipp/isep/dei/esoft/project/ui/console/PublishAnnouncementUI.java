package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        Location location = null;
        int distance;
        float price;
        ArrayList<String> photographs = new ArrayList<>();
        String photo;
        ArrayList<String> availableEquipment = new ArrayList<>();
        LocalDate date=LocalDate.now();
        int doorNumber = 0;
        String street = null;
        int postalCode = 0;
        boolean confirmed = false;
        int rentalMonths = 0;





        System.out.println("===== Publish a new announcement =====\n");

        //Agent
        //String agentsList = this.controller.getAgent().toString();
       // String agentName = controller.getAgentName();
        //String agent = Utils.readLineFromConsole("Agent, insert your name:: ");
        // Employee agentResp = this.controller.getEmployee(agent);

        String agentName = controller.getCurrentAgent();
        Employee agent = controller.getEmployeeByName(agentName);







        //typeOfBusiness

        /*List<TypeOfBusiness> typeOfBusinessList = this.controller.getTypeOfBusinessAsList();
        Utils.showList(typeOfBusinessList, "Type of Business");
        TypeOfBusiness selectedTypeOfBusiness = null;
        while (selectedTypeOfBusiness == null) {
            Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
            selectedTypeOfBusiness = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);
            if (selectedTypeOfBusiness == null) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        sellOrRent = selectedTypeOfBusiness; */

        List<TypeOfBusiness> typeOfBusinessList = this.controller.getTypeOfBusinessAsList();
        Utils.showList(typeOfBusinessList, "Type of Business");
         sellOrRent = null;

        while (sellOrRent == null) {
            try {
                Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
                TypeOfBusiness selectedTypeOfBusiness = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);

                if (selectedTypeOfBusiness == null) {
                    throw new IllegalArgumentException();
                }

                sellOrRent = selectedTypeOfBusiness;

                if (sellOrRent == TypeOfBusiness.RENT) {
                    System.out.print("Number of months: ");
                    rentalMonths = scanner.nextInt();

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }


        //TypeOfProperty
        /*List<TypeOfProperty> types = this.controller.getTypeOfPropertyAsList();
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
            TypeOfProperty selectedType = types.get(posTypeOfProperty - 1); */

        List<TypeOfProperty> types = this.controller.getTypeOfPropertyAsList();
        System.out.println("Select the property type:");
        for (int i = 0; i < types.size(); i++) {
            System.out.println((i + 1) + " - " + types.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int posTypeOfProperty = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                if (scanner.hasNextInt()) {
                    posTypeOfProperty = scanner.nextInt();
                    if (posTypeOfProperty > 0 && posTypeOfProperty <= types.size()) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please choose a number between 1 and " + types.size() + ".");
                        scanner.nextLine(); // Descartar a entrada inválida do usuário
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Descartar a entrada inválida do usuário
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Descartar a entrada inválida do usuário
            }
        }

        TypeOfProperty selectedType = types.get(posTypeOfProperty - 1);


            // Dados comuns a todas as propriedades

            //area
            System.out.println("area (m2):");
            area = scanner.nextInt();
            scanner.nextLine();

            //location
           /* String city = Utils.readLineFromConsole("Insert the city:");

            City existingCity = this.controller.getCity(city);
            if (existingCity != null) {

                street = Utils.readLineFromConsole("Insert the street:");
                postalCode = Integer.parseInt(Utils.readLineFromConsole("Insert the postal code(5 digits):"));


            } else {

                System.out.println("City not found in the repository. Please enter a valid city.");
            } */


        // Location
        List<City> cityList = this.controller.getCityList();
        Utils.showList(cityList, "Cities");

        String city = null;
        City existingCity = null;

        while (existingCity == null) {
            city = Utils.readLineFromConsole("Insert the city:");
            existingCity = this.controller.getCity(city);

            if (existingCity == null) {
                System.out.println("City not found in the repository. Please enter a valid city.");
            }
        }

        street = null;
        boolean validStreet = false;

        while (!validStreet) {
            street = Utils.readLineFromConsole("Insert the street:");

            if (location.streetIsValid(street)) {
                validStreet = true;
            } else {
                System.out.println("Street is invalid. Please enter a valid street.");
            }
        }

        postalCode = 0;
        boolean validPostalCode = false;

        while (!validPostalCode) {
            String postalCodeStr = Utils.readLineFromConsole("Insert the postal code (5 digits):");

            try {
                int postalCodeValue = Integer.parseInt(postalCodeStr);

                if (location.zipCodeIsValid(postalCodeValue)) {
                    postalCode = postalCodeValue;
                    validPostalCode = true;
                } else {
                    System.out.println("Postal code is invalid. Please enter a valid postal code.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Postal code must be a number.");
            }
        }


            //distanceFromCityCenter
            System.out.println("Distance from city center(km):");
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
        photo = "";
        int maxPhotos = 30;
        while (!photo.equalsIgnoreCase("exit")) {
            photo = scanner.nextLine();
            if (!photo.equalsIgnoreCase("exit")) {
                if (photographs.size() < maxPhotos) {
                    photographs.add(photo);
                } else {
                    System.out.println("Maximum number of photos (30) reached.");
                    break;
                }
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
                        System.out.println("Invalid. Please, insert 'yes' or 'no'.");
                    }

                    //loft
                    System.out.println("Has an habitable loft? (yes/no)");
                    String loft = scanner.nextLine();
                    hasLoft = false;
                    if (loft.equalsIgnoreCase("yes")) {
                        hasLoft = true;
                    } else if (!loft.equalsIgnoreCase("no")) {
                        System.out.println("Invalid. Please, insert 'yes' or 'no'.");
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
                    System.out.println("Number of parking spaces:");
                    parkingSpaces = scanner.nextInt();
                    scanner.nextLine();

                    //availableEquipments

                    System.out.println("Insert the available equipment");
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
            System.out.println("Distance of Centre: " + distance + "km");
            System.out.println("Price: " + price + "$");


            if (posTypeOfProperty == 1 || posTypeOfProperty == 2) {

                System.out.println("Number of bedrooms: " + bedrooms);
                System.out.println("Number of bathrooms: " + bathrooms);
                System.out.println("Number of parking spaces: " + parkingSpaces);
                System.out.println("Available equipments: " + availableEquipment);
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


            System.out.print("Do you confirm the creation (y/n)? \n");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("y")) {

                String ownerEmail = Utils.readLineFromConsole("Enter the owner's email: ");
                Client owner = controller.getClientByEmail(ownerEmail);

                this.controller.createAnnouncement(date,sellOrRent, posTypeOfProperty, bedrooms, bathrooms, parkingSpaces, availableEquipment, hasBasement, hasLoft,
                        sunExposure, area, location, distance, commission, price, photographs, agent, owner, rentalMonths );
                System.out.println("Announcement created successfully!\n");
                confirmed = true;
                if (owner != null) {

                    String ownerName = owner.getName();

                    String notificationSubject = "New Announcement Published";
                    String notificationMessage = "Dear " + ownerName + ",\n\n"
                            + "Your property has been published with the following details:\n"
                            + "Announcement ID: " + location.toString() + "\n"
                            + "Publication Date: " + date.toString() + "\n"
                            + "Responsible Agent: " + agent.getName() + "\n"
                            + "Agent Phone Number: " + agent.getTelephoneNumber() + "\n";

                    // Enviar a notificação para o EmailService
                    NotificationService notificationService = new NotificationService();
                    notificationService.sendNotification(ownerEmail, notificationSubject, notificationMessage);

                    System.out.println("Notification sent to owner: " + ownerEmail);
                } else {
                    System.out.println("Owner not found. Please enter a valid email address.");
                }
            } else {
                System.out.print("Cancel (y/n)?");
                String cancel = scanner.next();
                if (cancel.equalsIgnoreCase("y")) {
                    System.out.println("Announcement creation cancelled.\n");
                    confirmed = true;
                }
            }

         String ownerEmail = Utils.readLineFromConsole("Enter the owner's email: ");
            Client owner = controller.getClientByEmail(ownerEmail);




    }
    }



