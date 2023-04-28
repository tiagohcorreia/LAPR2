package app.ui.console;

/*import app.controller.PublishAnnouncementController;
import app.domain.repository.AnnouncementRepository;
import app.domain.shared.TypeOfBusiness;
import app.domain.shared.TypeOfProperty;

import app.domain.model.City;
import app.domain.model.Employee;
import app.domain.shared.SunExposure;
import app.domain.shared.TypeOfBusiness;
import app.domain.shared.TypeOfProperty;
import app.ui.console.utils.Utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import java.util.Scanner;

/*public class PublishAnnouncementUI {

    private Scanner scanner;
    private PublishAnnouncementController controller;

    public PublishAnnouncementUI(PublishAnnouncementController controller){
        scanner = new Scanner(System.in);
        //controller = new PublishAnnouncementController();


        }

        public void publishAnnouncement() {

            TypeOfBusiness sellOrRent;
            TypeOfProperty typeProperty;
            int numberOfBedrooms=0;
            int numberOfBathrooms=0;
            int numberOfParkingSpaces=0;
            ArrayList<String> equipmentList = new ArrayList();
            int numberEquipment=1;
            String equipment="";
            boolean hasBasement=false;
            boolean hasLoft=false;
            SunExposure sunExposure=null;
            int area;
            City location;
            int distance;
            float price;
            ArrayList<String> photographs = new ArrayList();
            String photo;
            int numberPhotos=1;


            //Agente
            String agentsList = this.controller.getAgent().toString();
            String agent = Utils.readLineFromConsole("Agent, insert your name:: ");
            Employee agentResp= this.controller.getEmployee(agent);

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
                City location = this.controller.getCity(city);

                //distanceFromCityCenter
                System.out.println("Distance from city center(km2):");
                int distance = scanner.nextInt();
                scanner.nextLine();

                //price
                System.out.println("price:");
                float price = scanner.nextFloat();
                scanner.nextLine();

                //Commission
                System.out.println("Commission:");
                double commission = scanner.nextDouble();
                scanner.nextLine();


                //photographs

                ArrayList<String> photographs = new ArrayList();
                while (true) {
                    System.out.print("insert the photos\n" +
                            "type 'exit' to exit or when you have no more pictures: ");
                    String photo = scanner.nextLine();
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
                        int bedrooms = scanner.nextInt();
                        scanner.nextLine();

                        //bathrooms
                        System.out.println("Number of bathrooms:");
                        int bathrooms = scanner.nextInt();
                        scanner.nextLine();


                        //parkingSpaces
                        System.out.println("Number of parking spces:");
                        int parkingSpaces = scanner.nextInt();
                        scanner.nextLine();

                        //availableEquipments
                        List<String> availableEquipments = new ArrayList<>();
                        while (true) {
                            System.out.print("insert the available Equipments\n" +
                                    "type 'exit' to exit or when you have no more equipments: ");
                            String equipment = scanner.nextLine();
                            if (equipment.equalsIgnoreCase("exit")) {
                                break;
                            } else {
                                availableEquipments.add(equipment);
                            }
                        }

                        //basement
                        System.out.println("Has a basement? (s/n)");
                        String basement = scanner.nextLine();
                        boolean hasBasement = false;
                        if (basement.equalsIgnoreCase("s")) {
                            hasBasement = true;
                        } else if (!basement.equalsIgnoreCase("n")) {
                            System.out.println("Invalid. Please, digit 's' or 'n'.");
                        }

                        //loft
                        System.out.println("Has an habitable loft? (s/n)");
                        String loft = scanner.nextLine();
                        boolean hasLoft = false;
                        if (loft.equalsIgnoreCase("s")) {
                            hasLoft = true;
                        } else if (!loft.equalsIgnoreCase("n")) {
                            System.out.println("Invalid. Please, digit 's' or 'n'.");
                        }

                        //sunExposure
                        System.out.println("Sun Exposure:");
                        List<SunExposure> sunExposure = this.controller.getSunExposureAsList();
                        for (int i = 0; i < sunExposure.size(); i++) {
                            System.out.println((i + 1) + ". " + sunExposure.get(i));
                        }
                        Integer exposure = null;
                        do {
                            System.out.print("Insert the sun exposure according to the number: ");
                            String option = scanner.nextLine();
                            try {
                                exposure = Integer.parseInt(option);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid! Digit a number.");
                            }
                        } while (exposure == null || exposure < 1 || exposure > sunExposure.size());

                        SunExposure sunExposure1 = sunExposure.get(exposure - 1);

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

                        this.controller.createAnnouncement(sellOrRent,posTypeOfProperty,bedrooms,bathrooms, parkingSpaces, (ArrayList<String>) availableEquipments,hasBasement,hasLoft,
                                sunExposure1,area,location,distance,price,photographs,agentResp);
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
                            String equipment = scanner.nextLine();
                            if (equipment.equalsIgnoreCase("exit")) {
                                break;
                            } else {
                                availableEquipments.add(equipment);
                            }
                        }

                        //typeOfBusiness
                        typeOfBusinessList = this.controller.getTypeOfBusinessAsList();
                        Utils.showList(typeOfBusinessList, "Type of Business");
                        selectedTypeOfBusiness = null;
                        while (selectedTypeOfBusiness == null) {
                            Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
                            selectedTypeOfBusiness = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);
                            if (selectedTypeOfBusiness == null) {
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        sellOrRent = selectedTypeOfBusiness;

                        this.controller.createAnnouncement(sellOrRent,posTypeOfProperty,bedrooms,bathrooms, parkingSpaces, (ArrayList<String>) availableEquipments,hasBasement,hasLoft,
                                sunExposure1,area,location,distance,price,photographs,agentResp);
                        break;


                    case 3: // Terreno
                        System.out.println("Describe the land:");
                        String description = scanner.nextLine();

                        //typeOfBusiness
                        typeOfBusinessList = this.controller.getTypeOfBusinessAsList();
                        Utils.showList(typeOfBusinessList, "Type of Business");
                        selectedTypeOfBusiness = null;
                        while (selectedTypeOfBusiness == null) {
                            Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
                            selectedTypeOfBusiness = TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);
                            if (selectedTypeOfBusiness == null) {
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        sellOrRent = selectedTypeOfBusiness;


                        this.controller.createAnnouncement(sellOrRent,posTypeOfProperty,bedrooms,bathrooms, parkingSpaces, (ArrayList<String>) availableEquipments,hasBasement,hasLoft,
                                sunExposure1,area,location,distance,price,photographs,agentResp);

                    default:
                        System.out.println("invalid!");
                        break;
                }
            }
    }
} */
