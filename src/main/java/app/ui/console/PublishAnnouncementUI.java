package app.ui.console;

import app.controller.PublishAnnouncementController;
import app.domain.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class PublishAnnouncementUI {
    private Scanner scanner;
    private PublishAnnouncementController controller;

    public PublishAnnouncementUI(){
        scanner = new Scanner(System.in);
        controller = new PublishAnnouncementController(AnnouncementRepository);
    }

    public void publishAnnouncement(){

        ArrayList<String> equipmentList = new ArrayList<>();
        String equipment ="";

        System.out.println("Select the property type:\n 1-House\n 2-Apartment\n 3-Land");
        int propertyType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insert area (m2):");
        double area = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Insert the city:");
        String location = this.controller.getCity(city);
        scanner.nextLine();

        System.out.println("Insert the distance from city center (km):");
        double distanceFromCityCenter = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Commission:");
        double commissionValue= scanner.nextDouble();
        scanner.nextLine();

        switch (propertyType){
            case 1:

                System.out.println("Number of bedrooms:");
                int numberOfBedroom = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Number of bathrooms:");
                int numberOfBathrooms = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Parking Spaces:");
                int parkingSpaces = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Number of available equipments:");
                int numberEquipments = scanner.nextInt();
                for(int i = 0; i< numberEquipments; i++){
                    System.out.println("Insert equipment:");
                    equipmentList.add(equipment);
                }
                scanner.nextLine();

                System.out.println("Does the house have a basement? (s/n");
                boolean hasBasement = scanner.nextLine().equalsIgnoreCase("s");
                scanner.nextLine();

                System.out.println("Does the house have a habitable loft ? (s/n");
                boolean hasHabitableLoft = scanner.nextLine().equalsIgnoreCase("s");
                scanner.nextLine();


                System.out.println("Does the house have sun exposure ? (s/n");
                boolean hasSunExposure = scanner.nextLine().equalsIgnoreCase("s");
                scanner.nextLine();

                controller.createHouse(area, location, distanceFromCityCenter, price, commissionValue,
                        numberOfBedroom,numberOfBathrooms,parkingSpaces,equipmentList, hasBasement,hasHabitableLoft,hasSunExposure);
                break;

            case 2:
                System.out.println("Number of bedrooms:");
                numberOfBedroom = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Number of bathrooms:");
                numberOfBathrooms = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Parking Spaces:");
                parkingSpaces = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Number of available equipments:");
                numberEquipments = scanner.nextInt();
                for(int i = 0; i< numberEquipments; i++){
                    System.out.println("Insert equipment:");
                    equipmentList.add(equipment);
                }
                scanner.nextLine();

                controller.createApartment(area, location, distanceFromCityCenter, price, commissionValue,
                        numberOfBedroom,numberOfBathrooms,parkingSpaces,equipmentList);
                break;

            case 3:
                System.out.println("Describe the land:");
                String description = scanner.nextLine();

                controller.createLand(area, location, distanceFromCityCenter, price, commissionValue,
                        description);

            default:
                System.out.println("Invalid property Type");
                break;





        }



    }




}
