package app.ui.console;

import app.controller.RegisterPropertyController;
import app.domain.model.Employee;
import app.domain.shared.SunExposure;
import app.ui.console.utils.Utils;
import org.apache.commons.lang3.ObjectUtils;


import java.util.ArrayList;
import java.util.Objects;

public class RegisterPropertyUI implements Runnable {

    private RegisterPropertyController controller;

    public RegisterPropertyUI(RegisterPropertyController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        String sellOrRent;
        String typeProperty;
        int numberOfBedrooms=0;
        int numberOfBathrooms=0;
        int numberOfParkingSpaces=0;
        ArrayList<String> equipmentList = new ArrayList();
        int numberEquipment=1;
        String equipment="";
        boolean hasBasement=false;
        boolean hasInhabitalLoft=false;
        boolean sunExposure=false;
        int area;
        String location;
        int cityCenterDistance;
        double price;
        ArrayList<String> photographs = new ArrayList();
        String photo;
        int numberPhotos=1;
        String agent;
        Employee choosedAgent;


        //Type of property
        typeProperty = Utils.readLineFromConsole("Insert the type of property: (A)partment, (H)ouse or (L)and : ");

        //area in m2
        area = Utils.readIntegerFromConsole("Insert area in m2: ");

        //Location
        location = Utils.readLineFromConsole("Insert the location: ");

        //area in m2
        cityCenterDistance = Utils.readIntegerFromConsole("Insert the distance from the centre: ");

        //Photographs
        numberPhotos=Utils.readIntegerFromConsole("Insert how many photos you want to add: ");
        for (int i=0;i<numberPhotos;i++){
            photo = Utils.readLineFromConsole("Insert the path of the photo "+i+1+": ");
            photographs.add(photo);
        }

        if (typeProperty=="A" || typeProperty=="H"){

            //Number of bedrooms
            numberOfBedrooms = Utils.readIntegerFromConsole("Insert Number of bedrooms: ");

            //Number of  bathrooms
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert Number of bathrooms: ");

            //Number of parking spaces
            numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert Number of Parking Spaces: ");

            //Equipment Available
            numberEquipment=Utils.readIntegerFromConsole("Insert how many equipments you want to add: ");
            for (int i=0;i<numberEquipment;i++){
                equipment = Utils.readLineFromConsole("Insert the equipment: ");
                equipmentList.add(equipment);
            }
        }
        if (typeProperty=="H") {

            int hasBasementInt = Utils.readIntegerFromConsole("The house has a basement? \n0. NO\n1. YES");
            if (hasBasementInt==0){hasBasement=false;}else{hasBasement=true;}
            int hasInhabitalLoftInt = Utils.readIntegerFromConsole("The house has an inhabitalLoft? \n0. NO\n1. YES");
            if (hasInhabitalLoftInt==0){hasInhabitalLoft=false;}else{hasInhabitalLoft=true;}
            int sunExposureInt = Utils.readIntegerFromConsole("The house has sun exposure?\n0. NO\n1. YES");
            if (sunExposureInt==0){sunExposure=false;}else{sunExposure=true;}
        }


        //price
        price=Utils.readDoubleFromConsole("Insert the price of the property: ");

        //agent
        String agentsList = this.controller.getAgent().toString();
        agent = Utils.readLineFromConsole("Insert the Name of the responsible agent: ");
        choosedAgent= this.controller.getEmployee(agent);

        //Sell or Rent a property
        sellOrRent = Utils.readLineFromConsole("Insert 'S' if you want to sell a property. Insert 'R' if you want rent a property: ");

        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if(optValidation == 1) {

            this.controller.createAnnouncement(sellOrRent,typeProperty,numberOfBedrooms,numberOfBathrooms, numberOfParkingSpaces, equipmentList,hasBasement,hasInhabitalLoft,
                    sunExposure,area,location,cityCenterDistance,price,photographs,choosedAgent);

            System.out.println("(S)ell or (R)ent: " + sellOrRent);
            System.out.println("Type of property: " + typeProperty);
            if (typeProperty=="A" || typeProperty=="H"){

                System.out.println("Number of bedrooms: " + numberOfBedrooms);
                System.out.println("Number of bathrooms: "+ numberOfBathrooms);
                System.out.println("Number of parking spaces: "+ numberOfParkingSpaces);
                System.out.println("Equipment available: " + equipmentList);
            }
            if (typeProperty=="H") {
                System.out.println("The house has basement? " + hasBasement);
                System.out.println("The house has inhabital loft? " + hasInhabitalLoft);
                System.out.println("The house has sun exposure? " + sunExposure);
            }
            System.out.println("Area: " + area+" m2");
            System.out.println("Location: "+ location);
            System.out.println("Distance of Centre: "+ cityCenterDistance);
            System.out.println("Price: "+ price);
            System.out.println("Responsible Agent: "+ choosedAgent.getName());

        } else {
            System.err.println("Operation Canceled!");
        }

    }
}
