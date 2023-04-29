package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;



import java.util.ArrayList;
import java.util.List;


import java.util.Scanner;

public class PublishAnnouncementUI implements Runnable {

    private Scanner scanner;
    private PublishAnnouncementController controller;

    public PublishAnnouncementUI(PublishAnnouncementController controller) {
        scanner = new Scanner(System.in);
        this.controller= controller;


    }

    public void  run () {

        TypeOfBusiness sellOrRent;
        TypeOfProperty typeProperty;
        int bedrooms = 0;
        int bathrooms = 0;
        int parkingSpaces = 0;
        ArrayList<String> equipmentList = new ArrayList();
        int numberEquipment = 1;
        String equipment = "";
        boolean hasBasement = false;
        boolean hasLoft = false;
        SunExposure sunExposure = null;
        int area;
        City location;
        int distance;
        float price;
        ArrayList<String> photographs = new ArrayList();
        String photo;
        int numberPhotos = 1;


        boolean confirmed = false;
        do {
            System.out.println("===== Publish a new announcement =====");

            //Agente
            String agentsList = this.controller.getAgent().toString();
            String agent = Utils.readLineFromConsole("Agent, insert your name:: ");
            Employee agentResp = this.controller.getEmployee(agent);

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
                System.out.println("Location:");
                String city = scanner.nextLine();
                location = this.controller.getCity(city);

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

                photographs = new ArrayList();
                while (true) {
                    System.out.print("insert the photos\n" +
                            "type 'exit' to exit or when you have no more pictures: ");
                    photo = scanner.nextLine();
                    if (photo.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        photographs.add(photo);
                    }
                }


                // Dados específicos de cada tipo de propriedade
                switch (posTypeOfProperty) {
                    case 1: // House
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
                        List<String> availableEquipments = new ArrayList<>();
                        while (true) {
                            System.out.print("insert the available Equipments\n" +
                                    "type 'exit' to exit or when you have no more equipments: ");
                            equipment = scanner.nextLine();
                            if (equipment.equalsIgnoreCase("exit")) {
                                break;
                            } else {
                                availableEquipments.add(equipment);
                            }
                        }

                        //basement
                        System.out.println("Has a basement? (s/n)");
                        String basement = scanner.nextLine();
                        hasBasement = false;
                        if (basement.equalsIgnoreCase("s")) {
                            hasBasement = true;
                        } else if (!basement.equalsIgnoreCase("n")) {
                            System.out.println("Invalid. Please, digit 's' or 'n'.");
                        }

                        //loft
                        System.out.println("Has an habitable loft? (s/n)");
                        String loft = scanner.nextLine();
                        hasLoft = false;
                        if (loft.equalsIgnoreCase("s")) {
                            hasLoft = true;
                        } else if (!loft.equalsIgnoreCase("n")) {
                            System.out.println("Invalid. Please, digit 's' or 'n'.");
                        }

                        //sunExposure
                        List<SunExposure> sunExposure1 = this.controller.getSunExposureAsList();
                        Utils.showList(sunExposure1, "SunExposure");
                        Integer posSunExposure = Utils.readIntegerFromConsole("Choose the sunExposure: ");
                        sunExposure = SunExposure.getSunExposureById(posSunExposure);


                        break;


                    case 2: // Apartamento
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
                        availableEquipments = new ArrayList<>();
                        while (true) {
                            System.out.print("insert the available Equipments\n" +
                                    "type 'exit' to exit or when you have no more equipments: ");
                            equipment = scanner.nextLine();
                            if (equipment.equalsIgnoreCase("exit")) {
                                break;
                            } else {
                                availableEquipments.add(equipment);
                            }
                        }

                        break;

                    default:
                        System.out.println("invalid!");
                        break;

                }
                System.out.println("===== Review Ad Details =====");
                System.out.println("Type of Business: " + sellOrRent);
                System.out.println("Type of property: " + selectedType);
                System.out.println("Area: " + area + " m2");
                System.out.println("Location: " + location);
                System.out.println("Distance of Centre: " + distance);
                System.out.println("Price: " + price + "€");
                System.out.println("Price: " + price + "€");
                System.out.println("Responsible Agent: " + agentResp.getName());

                if (posTypeOfProperty == 1 || posTypeOfProperty == 2) {

                    System.out.println("Number of bedrooms: " + bedrooms);
                    System.out.println("Number of bathrooms: " + bathrooms);
                    System.out.println("Number of parking spaces: " + parkingSpaces);
                    System.out.println("Equipment available: " + equipmentList);

                }
                if (posTypeOfProperty == 1) {
                    System.out.println("The house has basement? " + hasBasement);
                    System.out.println("The house has inhabital loft? " + hasLoft);
                    System.out.println("The house has sun exposure? " + sunExposure);
                }


                System.out.print("Confirm ad creation (y/n)? ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    this.controller.createAnnouncement(sellOrRent, posTypeOfProperty, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft,
                            sunExposure, area, location, distance, commission, price, photographs, agentResp);
                    System.out.println("Ad created successfully!");
                    confirmed = true;
                } else {
                    System.out.print("Cancel (y/n)? ");
                    String cancel = scanner.nextLine();
                    if (cancel.equalsIgnoreCase("y")) {
                        System.out.println("Ad creation cancelled.");
                        confirmed = true;
                    }
                }
            }


        }while (!confirmed) ;

        scanner.close();
    }
}
