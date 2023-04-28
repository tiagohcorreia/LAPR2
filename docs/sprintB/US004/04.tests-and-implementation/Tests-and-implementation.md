# US 004 - Request a listing property

# 4. Tests 

**Test 1:** Check if the area of a property is negative, fails

	@DisplayName("Ensure House area <0 Fails")
    @Test
    void EnsureNegativePropertyAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("photo1");
            ArrayList<String> equipment= new ArrayList<>();
            equipment.add("equipment1");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setArea(-1);

        });
    }

**Test 2:** Check that it is not possible to create an empty photographs array

	@DisplayName("Ensure House photographs array empty Fails")
    @Test
    void EnsureNullPhotosArrayFails(){

        assertThrows(NullPointerException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setPhotographs(null);
        });
    }
**Test 3:** Check that it is not possible to insert a negative distance of the center 

	@DisplayName("Ensure House Distance of the center <0 Fails")
    @Test
    void EnsureNullHouseAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setCityCentreDistance(-1);
        });
    }

**Test 4:** Check that it is not possible to create an empty equipment array

	@DisplayName("Ensure that null equipment Fails")
    @Test
    void EnsureNullHouseEquipmentFails(){

        assertThrows(NullPointerException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setEquipment(null);
        });
    }

**Test 5:** Check that it is not possible to insert a number of parking spaces negative

	@DisplayName("Ensure that number of parking spaces <0 Fails")
    @Test
    void EnsureNegativeHouseParkingSpacesFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfParkingSpaces(-1);
        });
    }
**Test 6:** Check that it is not possible to insert a number of bedrooms

	@DisplayName("Ensure that number of bedrooms <0 Fails")
    @Test
    void EnsureNegativeHouseBedroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfBedrooms(-1);
        });
    }
    
**Test 7:** Check that it is not possible to insert a number of bathrooms

    @DisplayName("Ensure that number of bathrooms <0 Fails")
    @Test
    void EnsureNegativeHouseBathroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfBathrooms(-1);
        });
    }


    

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class Property

```java
package app.domain.model;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Property {

    private static final float DEFAULT_AREA = 1;
    private static final City DEFAULT_LOCATION = new City();
    private static final float DEFAULT_CITY_CENTER_DISTANCE = 10;
    private static final ArrayList<String> DEFAULT_PHOTOGRAPHS = new ArrayList<>();

    private float area;
    City location;
    float cityCentreDistance;
    private ArrayList<String> photographs;


    //Full constructor
    public Property(float area, City location, float cityCentreDistance, ArrayList<String> photographs) {

        this.area = setArea(area);
        this.cityCentreDistance = setCityCentreDistance(cityCentreDistance);
        this.location = location;
        this.photographs = setPhotographs(photographs);
    }

    //Default constructor
    public Property(){
        this.area = DEFAULT_AREA;
        this.location = DEFAULT_LOCATION;
        this.cityCentreDistance = DEFAULT_CITY_CENTER_DISTANCE;
        this.photographs = DEFAULT_PHOTOGRAPHS;
    }

    //Copy constructor
    public Property(Property anotherProperty){
        this.setArea(anotherProperty.getArea());
        this.setLocation(anotherProperty.getLocation());
        this.setCityCentreDistance(anotherProperty.getCityCentreDistance());
        this.setPhotographs(anotherProperty.getPhotographs());
    }

    // Getters and Setters

    public float getArea() {
        return area;
    }

    public City getLocation() {
        return location;
    }

    public float getCityCentreDistance() {
        return cityCentreDistance;
    }

    public ArrayList<String> getPhotographs() {
        return photographs;
    }

    public int getNumberOfBedrooms(){ return -1; }


    public float setArea(float area) {

        if (area<=0){
            throw new IllegalArgumentException("Please insert an area >0");
        }
        return area;
    }

    public void setLocation(City location) {
        this.location = location;
    }


    public float setCityCentreDistance(float cityCentreDistance) {
        if (cityCentreDistance<=0){
            throw new IllegalArgumentException("Please insert a distance >0");
        }
        return cityCentreDistance;
    }

    public ArrayList<String> setPhotographs(ArrayList<String> photographs) {
        if (photographs.isEmpty() && photographs.size()>30){
            throw new IllegalArgumentException("Please insert at least 1 photograph and a maximum of 30 photographs");
        }else if (photographs == null) {
            throw new NullPointerException("You need to insert at least 1 photograph");
        }
        return photographs;
    }



    //ToString()
    @Override
    public String toString() {
        return " area=" + area +
                ", address='" + location + '\'' +
                ", cityCentreDistance=" + cityCentreDistance +
                ", photographs=" + photographs;
    }
    //equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Float.compare(property.area, area) == 0 && Float.compare(property.cityCentreDistance, cityCentreDistance) == 0 && Objects.equals(location, property.location) && Objects.equals(photographs, property.photographs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, location, cityCentreDistance, photographs);
    }
}

```


## Class House

```java
package app.domain.model;

import app.domain.shared.SunExposure;

import java.util.ArrayList;

public class House extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    private boolean hasBasement;
    private boolean hasInhabitableLoft;
    SunExposure sunExposure;

    public House(float area, City location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment, boolean hasBasement, boolean hasInhabitableLoft, SunExposure sunExposure) {
        super(area, location, cityCentreDistance, photographs);
        this.numberOfBedrooms=setNumberOfBedrooms(numberOfBedrooms);
        this.numberOfBathrooms=setNumberOfBathrooms(numberOfBathrooms);
        this.numberOfParkingSpaces=setNumberOfParkingSpaces(numberOfParkingSpaces);
        this.equipment=setEquipment(equipment);
        this.hasBasement=hasBasement;
        this.hasInhabitableLoft=hasInhabitableLoft;
        this.sunExposure=sunExposure;
    }
    // Getters and Setters
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }



    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }



    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }



    public ArrayList<String> getEquipment() {
        return equipment;
    }



    public boolean isHasBasement() {
        return hasBasement;
    }



    public boolean isHasInhabitableLoft() {
        return hasInhabitableLoft;
    }



    public SunExposure getSunExposure() {
        return sunExposure;
    }

    public int setNumberOfBedrooms(int numberOfBedrooms) {
        if (numberOfBedrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBedrooms;
    }
    public int setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBathrooms;
    }
    public int setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        if (numberOfParkingSpaces<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfParkingSpaces;
    }
    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }
    public void setHasInhabitableLoft(boolean hasInhabitableLoft) {

        this.hasInhabitableLoft = hasInhabitableLoft;
    }
    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }
    public ArrayList<String> setEquipment(ArrayList<String> equipment) {
        if (equipment == null) {
            throw new NullPointerException("You need to insert at least 1 equipment.");
        }
        return equipment;
    }



    //toString()

    @Override
    public String toString() {
        return "House{" +super.toString()+
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                ", hasBasement=" + hasBasement +
                ", hasInhabitableLoft=" + hasInhabitableLoft +
                ", sunExposure=" + sunExposure +
                '}';
    }


}

```

## Class Apartment

```java
package app.domain.model;

import java.util.ArrayList;

public class Apartment extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private ArrayList<String> equipment;

    //Constructor
    public Apartment(float area, City location, float cityCentreDistance, ArrayList<String> photographs, int numberOfBedrooms,int numberOfBathrooms, int numberOfParkingSpaces, ArrayList<String> equipment) {
        super(area, location, cityCentreDistance, photographs);
        this.numberOfBedrooms=numberOfBedrooms;
        this.numberOfBathrooms=numberOfBathrooms;
        this.numberOfParkingSpaces=numberOfParkingSpaces;
        this.equipment=equipment;

    }

    //Getters and Setters

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }



    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }



    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }



    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public int setNumberOfBedrooms(int numberOfBedrooms) {
        if (numberOfBedrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBedrooms;
    }
    public int setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfBathrooms;
    }
    public int setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        if (numberOfParkingSpaces<0){
            throw new IllegalArgumentException("Please insert a number >=0");
        }
        return numberOfParkingSpaces;
    }

    public ArrayList<String> setEquipment(ArrayList<String> equipment) {
        if (equipment == null) {
            throw new NullPointerException("You need to insert at least 1 equipment.");
        }
        return equipment;
    }

    //ToString

    @Override
    public String toString() {
        return "Apartment{" +super.toString()+
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfParkingSpaces=" + numberOfParkingSpaces +
                ", equipment=" + equipment +
                '}';
    }
}

```

## Class Land

```java
package app.domain.model;

import java.util.ArrayList;

public class Land extends Property{

    public Land(float area, City location, float cityCentreDistance, ArrayList<String> photographs) {
        super(area, location, cityCentreDistance, photographs);
    }

    @Override
    public String toString() {
        return "Land{"+super.toString()+
                "}";
    }
}

```

## Class RegisterPropertyUI

```java
package app.ui.console;

import app.controller.RegisterPropertyController;
import app.domain.model.City;
import app.domain.model.Employee;

import app.domain.shared.SunExposure;
import app.domain.shared.TypeOfBusiness;
import app.domain.shared.TypeOfProperty;
import app.ui.console.utils.Utils;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterPropertyUI implements Runnable {

    private RegisterPropertyController controller;

    public RegisterPropertyUI(RegisterPropertyController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        TypeOfBusiness sellOrRent;
        TypeOfProperty typeProperty;
        int numberOfBedrooms=0;
        int numberOfBathrooms=0;
        int numberOfParkingSpaces=0;
        ArrayList<String> equipmentList = new ArrayList();
        int numberEquipment=1;
        String equipment="";
        boolean hasBasement=false;
        boolean hasInhabitalLoft=false;
        SunExposure sunExposure=null;
        int area;
        City location;
        int cityCenterDistance;
        float price;
        ArrayList<String> photographs = new ArrayList();
        String photo;
        int numberPhotos=1;
        String agent;
        Employee choosedAgent;


        //Type of property
        List<TypeOfProperty> x = this.controller.getTypeOfPropertyAsList();
        Utils.showList(x,"Type of Property");
        Integer posTypeOfProperty = Utils.readIntegerFromConsole("Choose the type of property: ");
        typeProperty= TypeOfProperty.getTypeOfPropertyById(posTypeOfProperty);

        //area in m2
        area = Utils.readIntegerFromConsole("Insert area in m2: ");

        //Location

        String city = Utils.readLineFromConsole("Insert the city:");
        location= this.controller.getCity(city);


        //area in m2
        cityCenterDistance = Utils.readIntegerFromConsole("Insert the distance from the centre: ");

        //Photographs
        numberPhotos=Utils.readIntegerFromConsole("Insert how many photos you want to add: ");
        for (int i=0;i<numberPhotos;i++){
            photo = Utils.readLineFromConsole("Insert the path of the photo "+i+1+": ");
            photographs.add(photo);
        }

        if (posTypeOfProperty== 1 || posTypeOfProperty==2){

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
        if (posTypeOfProperty==1) {

            int hasBasementInt = Utils.readIntegerFromConsole("The house has a basement? \n0. NO\n1. YES");
            if (hasBasementInt==0){hasBasement=false;}else{hasBasement=true;}
            int hasInhabitalLoftInt = Utils.readIntegerFromConsole("The house has an inhabitalLoft? \n0. NO\n1. YES");
            if (hasInhabitalLoftInt==0){hasInhabitalLoft=false;}else{hasInhabitalLoft=true;}

            //SunExposure
            List<SunExposure> y = this.controller.getSunExposureAsList();
            Utils.showList(y,"SunExposure");
            Integer posSunExposure = Utils.readIntegerFromConsole("Choose the sunExposure: ");
            sunExposure= SunExposure.getSunExposureById(posSunExposure);
        }


        //price
        price= (float) Utils.readDoubleFromConsole("Insert the price of the property: ");

        //agent
        String agentsList = this.controller.getAgent().toString();
        agent = Utils.readLineFromConsole("Insert the Name of the responsible agent: ");
        choosedAgent= this.controller.getEmployee(agent);

        //Sell or Rent a property
        List<TypeOfBusiness> z = this.controller.getTypeOfBusinessAsList();
        Utils.showList(z,"Type of Business");
        Integer posTypeOfBusiness = Utils.readIntegerFromConsole("Choose the Type of Business: ");
        sellOrRent= TypeOfBusiness.getTypeOfBusinessById(posTypeOfBusiness);

        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if(optValidation == 1) {


            this.controller.createAnnouncement(sellOrRent,posTypeOfProperty,numberOfBedrooms,numberOfBathrooms, numberOfParkingSpaces, equipmentList,hasBasement,hasInhabitalLoft,
                    sunExposure,area,location,cityCenterDistance,price,photographs,choosedAgent);

            System.out.println("Type of Business: " + sellOrRent);
            System.out.println("Type of property: " + typeProperty);
            if (posTypeOfProperty==1 || posTypeOfProperty==2){

                System.out.println("Number of bedrooms: " + numberOfBedrooms);
                System.out.println("Number of bathrooms: "+ numberOfBathrooms);
                System.out.println("Number of parking spaces: "+ numberOfParkingSpaces);
                System.out.println("Equipment available: " + equipmentList);

            }
            if (posTypeOfProperty==1) {
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

```

## Class RegisterPropertyController

```java
package app.controller;

import app.domain.model.*;
import app.domain.repository.*;
import app.domain.shared.SunExposure;
import app.domain.shared.TypeOfBusiness;
import app.domain.shared.TypeOfProperty;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterPropertyController {
    private AnnouncementRepository announcementRepository;
    Repositories repositories = Repositories.getInstance();
    RegisterEmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    StateRepository stateRepository=repositories.getStateRepository();
    DistrictRepository districtRepository=repositories.getDistrictRepository();
    CityRepository cityRepository=repositories.getCityRepository();
    public RegisterPropertyController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public void createAnnouncement(TypeOfBusiness sellOrRent, int posTypeOfProperty, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                                   ArrayList<String> equipmentList,boolean hasBasement, boolean hasInhabitalLoft, SunExposure sunExposure,
                                   int area, City location, int cityCentreDistance, float price, ArrayList<String> photographs, Employee agent) {

        if (posTypeOfProperty==2){
            Property property= new Apartment(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        } else if (posTypeOfProperty==1) {
            Property property= new House(area,location,cityCentreDistance,photographs,numberOfBedrooms,numberOfBathrooms,numberOfParkingSpaces,equipmentList,hasBasement,hasInhabitalLoft,sunExposure);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }else {
            Property property= new Land(area,location,cityCentreDistance,photographs);
            Announcement announcement= new Announcement(false,price,0 ,sellOrRent,property,agent);
            this.announcementRepository.createAnnouncement(announcement);
        }

    }
    public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeRepository.getEmployeeList()) {

            if(employee.getRole().equals(Role.AGENT)) {
                agent.add(employee);
            }
        }
        return agent;

    }
    public Employee getEmployee(String name){
        return employeeRepository.getEmployee(name);
    }

    public City getCity(String city){
        return cityRepository.findByName(city);
    }

    public List<SunExposure> getSunExposureAsList() {
        return Arrays.stream(SunExposure.values()).toList();
    }

    public List<TypeOfProperty> getTypeOfPropertyAsList() {
        return Arrays.stream(TypeOfProperty.values()).toList();
    }

    public List<TypeOfBusiness> getTypeOfBusinessAsList() {
        return Arrays.stream(TypeOfBusiness.values()).toList();
    }
}

```

## Class AnnouncementRepository

```java
package app.domain.repository;

import app.domain.model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {
    List<Announcement> announcements = new ArrayList<>();

    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getAnnouncement());
    }

    public boolean createAnnouncement (Announcement announcement) {

        if(validateAnnouncement(announcement)) {

            return addAnnouncement(announcement);
        }
        return false;
    }
    public boolean validateAnnouncement(Announcement announcement) {

        for(Announcement announcement1 : announcements) {

            if(announcement.equals(announcement)) {

                return false;
            }
        }
        return true;
    }

    public boolean addAnnouncement(Announcement announcement) {

        if(announcement != null && validateAnnouncement(announcement)) {

            return this.announcements.add(announcement);
        }
        return false;
    }

    public List<Announcement> getAllVisibleAnnouncements() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getAnnouncement());
            }
        }
        return allVisibleAnnouncements;
    }

    public List<List<Object>> getAvailableFields(){
        List<List<Object>> availableFields = new ArrayList<>();
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());

        //TO-FIX
        for(Announcement announcement : announcements){
            if ( announcement != null && announcement.isVisible()){
                if (!availableFields.get(0).contains(announcement.getTypeOfBusiness())){
                    availableFields.get(0).add(announcement.getTypeOfBusiness());
                }
                if (!availableFields.get(1).contains(announcement.getProperty().getClass().getSimpleName())){
                    availableFields.get(1).add(announcement.getProperty().getClass().getSimpleName());
                }
                if (!announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    //if (announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(announcement.getProperty().getNumberOfBedrooms());
                    //availableFields.get(2).add(announcement.getProperty().getBedrooms());
                }
            }
        }
        return availableFields;
    }

    public List<Announcement> getAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            Announcement gotAnnouncement = announcement.getAnnouncement(typeOfBusiness, typeOfProperty, numberOfBedrooms);
            if(gotAnnouncement != null){
                matchingAnnouncements.add(gotAnnouncement);
            }
        }
        return matchingAnnouncements;
    }

}

```
# 6. Integration and Demo 

* A new option on the Owner menu options was added.


# 7. Observations

N/A






