package app.ui.console;

import app.controller.RegisterPropertyController;
import app.domain.model.Employee;
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
        int bedrooms=0;
        int bathrooms=0;
        int parking=0;
        ArrayList<String> equipmentList = new ArrayList();
        int numberEquipment=1;
        String equipment="";
        String basement="";
        String inhabitalLoft="";
        String sunExposure="";
        int area;
        String location;
        int centreDistance;
        double price;
        ArrayList<String> photographs = new ArrayList();
        String photo;
        int numberPhotos=1;
        String agent;
        Employee choosedAgent;

        //Sell or Rent a property
        sellOrRent = Utils.readLineFromConsole("Insert 'S' if you want to sell a property. Insert 'R' if you want rent a property: ");

        //Type of property
        typeProperty = Utils.readLineFromConsole("Insert the type of property (A)partment, (H)ouse or (L)and : ");

        if (typeProperty=="A" || typeProperty=="H"){

            //Number of bedrooms
            bedrooms = Utils.readIntegerFromConsole("Insert Number of bedrooms: ");

            //Number of  bathrooms
            bathrooms = Utils.readIntegerFromConsole("Insert Number of bathrooms: ");

            //Number of parking spaces
            parking = Utils.readIntegerFromConsole("Insert Number of Parking Spaces: ");

            //Equipment Available
            numberEquipment=Utils.readIntegerFromConsole("Insert how many equipments you want to add: ");
            for (int i=0;i<numberEquipment;i++){
                equipment = Utils.readLineFromConsole("Insert the equipment: ");
                equipmentList.add(equipment);
            }

        }
        if (typeProperty=="H") {

            basement = Utils.readLineFromConsole("The house has a basement? (Y/N)");
            inhabitalLoft = Utils.readLineFromConsole("The house has an inhabitalLoft? (Y/N)");
            sunExposure = Utils.readLineFromConsole("The house has sun exposure? (Y/N)");
        }

        //area in m2
        area = Utils.readIntegerFromConsole("Insert area in m2: ");

        //Location
        location = Utils.readLineFromConsole("Insert the location: ");

        //area in m2
        centreDistance = Utils.readIntegerFromConsole("Insert the distance of the centre: ");

        //price
        price=Utils.readDoubleFromConsole("Insert the price of the property: ");

        //Photographs
        numberPhotos=Utils.readIntegerFromConsole("Insert how many photos you want to add: ");
        for (int i=0;i<numberPhotos;i++){
            photo = Utils.readLineFromConsole("Insert the path of the photo "+i+1+": ");
            photographs.add(photo);
        }

        //agent
        String agentsList = this.controller.getAgent().toString();
        agent = Utils.readLineFromConsole("Insert the Name of the responsible agent: ");
        choosedAgent= this.controller.getEmployee(agent);


        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if(optValidation == 1) {
            this.controller.createProperty(sellOrRent,typeProperty,bedrooms,bathrooms, parking, equipmentList,basement,inhabitalLoft,
                    sunExposure,area,location,centreDistance,price,photographs,choosedAgent);

            System.out.println("(S)ell or (R)ent: " + sellOrRent);
            System.out.println("Type of property: " + typeProperty);
            if (typeProperty=="A" || typeProperty=="H"){

                System.out.println("Number of bedrooms: " + bedrooms);
                System.out.println("Number of bathrooms: "+ bathrooms);
                System.out.println("Number of parking spaces: "+ parking);
                System.out.println("Equipment available: " + equipmentList);
            }
            if (typeProperty=="H") {
                System.out.println("The house has basement? " + basement);
                System.out.println("The house has inhabital loft? " + inhabitalLoft);
                System.out.println("The house has sun exposure? " + sunExposure);
            }
            System.out.println("Area: " + area+" m2");
            System.out.println("Location: "+ location);
            System.out.println("Distance of Centre: "+ centreDistance);
            System.out.println("Price: "+ price);
            System.out.println("Responsible Agent: "+ agent);

        } else {
            System.err.println("Operation Canceled!");
        }

    }
}
