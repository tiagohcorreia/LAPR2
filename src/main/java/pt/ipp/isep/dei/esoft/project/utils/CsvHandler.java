package pt.ipp.isep.dei.esoft.project.utils;


import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import java.io.File;
import java.util.*;

import static pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository.getEmployee;


public class CsvHandler {
    public static final String CSV_DELIMITER = ";";

    public static final String LEGACY_AGENT_NAME = "Legacy Agent";

    private static final int COLUMN_OWNER_ID = 0;
    private static final int COLUMN_OWNER_NAME = 1;
    private static final int COLUMN_OWNER_PASSPORT = 2;
    private static final int COLUMN_OWNER_TAX_NUMBER = 3;
    private static final int COLUMN_OWNER_EMAIL = 4;
    private static final int COLUMN_OWNER_PHONE = 5;

    private static final int COLUMN_PROPERTY_TYPE = 6;
    private static final int COLUMN_PROPERTY_AREA = 7;
    private static final int COLUMN_PROPERTY_LOCATION = 8;
    private static final int COLUMN_PROPERTY_CITY_CENTER_DISTANCE = 9;
    private static final int COLUMN_PROPERTY_NUMBER_BEDROOMS = 10;
    private static final int COLUMN_PROPERTY_NUMBER_BATHROOMS = 11;
    private static final int COLUMN_PROPERTY_NUMBER_PARKING = 12;
    private static final int COLUMN_PROPERTY_EQUIPMENT_HEATING = 13;
    private static final int COLUMN_PROPERTY_EQUIPMENT_AIRCON = 14;
    private static final int COLUMN_PROPERTY_BASEMENT = 15;
    private static final int COLUMN_PROPERTY_LOFT = 16;
    private static final int COLUMN_PROPERTY_SUN_EXPOSURE = 17;

    private static final int COLUMN_PROPERTY_PRICE = 18;
    //private static final int COLUMN_PROPERTY_REQUESTED_PRICE = 19;
    private static final int COLUMN_ANNOUNCEMENT_PRICE = 20;
    private static final int COLUMN_ANNOUNCEMENT_COMMISSION = 21;
    private static final int COLUMN_ANNOUNCEMENT_DATE = 22;
    //...
    private static final int COLUMN_ANNOUNCEMENT_TYPE_BUSINESS = 24;

    private static final int COLUMN_BRANCH_ID = 25;
    private static final int COLUMN_BRANCH_NAME = 26;
    private static final int COLUMN_BRANCH_LOCATION = 27;
    private static final int COLUMN_BRANCH_PHONE = 28;
    private static final int COLUMN_BRANCH_EMAIL = 29;

    private static final String CSV_VALUE_YES = "Y";
    private static final String CSV_VALUE_NO = "N";
    private static final String CSV_VALUE_NA = "NA";






    static StateRepository stateRepository = Repositories.getInstance().getStateRepository();
    static CityRepository cityRepository = Repositories.getInstance().getCityRepository();
    static BranchRepository branchRepository = Repositories.getInstance().getBranchRepository();
    static ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    static EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();





    public static List<?> getDataFromCsvFile(File file) throws InvalidFileTypeException {
        //Check if the filename ends with ".csv"
        //String[] filepath = file.getAbsolutePath().split("\\.");
        //String extension = filepath[filepath.length-1];
        //if(!extension.equalsIgnoreCase("csv"))
        //    throw new InvalidFileTypeException("Selected file is not a CSV file");

        extensionIsCsv(file);

        List<List<String>> csv = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter(",");
            //boolean a=sc.hasNext();
            while (sc.hasNextLine()) {
                List<String> thisLine = new ArrayList<>();
                String line = sc.nextLine();
                String[] lineElements = line.split(",");
                Collections.addAll(thisLine, lineElements);
                csv.add(thisLine);
            }
            sc.close();
        } finally {
            csvIsEmpty(csv);
            //Remove the header
            csv.remove(0);
            return csv;
        }
    }

    public static boolean csvIsEmpty(List<?> csv){
        if (csv.size() < 2){
            throw new IllegalArgumentException("The file contains no data.");
        }
        return false;
    }

    private static boolean extensionIsCsv(File file) throws InvalidFileTypeException {
        String[] filepath = file.getAbsolutePath().split("\\.");
        String extension = filepath[filepath.length-1];
        if(!extension.equalsIgnoreCase("csv"))
            throw new InvalidFileTypeException("Selected file is not a CSV file");
        return true;
    }

    public static boolean parseCSV(List<?> csv){
        boolean success = false;
        for (Object line:
             csv) {
            Branch branch = parseBranchData((List<?>) line);
            Client client = parseClientData((List<?>) line);
            Announcement announcement = parseAnnouncementData((List<?>) line);

            try{
                success = branchRepository.saveBranch(branch);
                success = (clientRepository.add(client) && success);
                success = (announcementRepository.save(announcement) && success);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return success;
    }

    private static Branch parseBranchData(List<?> line){
        int branchID = Integer.parseInt(String.valueOf(line.get(COLUMN_BRANCH_ID)));
        String branchName = (String) line.get(COLUMN_BRANCH_NAME);
        String branchLocation = (String) line.get(COLUMN_BRANCH_LOCATION);
        int branchPhoneNumber = Integer.getInteger(String.valueOf(line.get(COLUMN_BRANCH_PHONE)));
        String branchEmail = (String) line.get(COLUMN_BRANCH_EMAIL);

        Location location = parseLocation(branchLocation);

        return branchRepository.createBranch(branchID, branchName, location, branchPhoneNumber, branchEmail);
    }

    private static Client parseClientData(List<?> line){
        int clientID = Integer.parseInt(String.valueOf(line.get(COLUMN_OWNER_ID)));
        String clientName = String.valueOf(line.get(COLUMN_OWNER_NAME));
        String clientPassportNumber = String.valueOf(line.get(COLUMN_OWNER_PASSPORT));
        String clientTaxNumber = String.valueOf(line.get(COLUMN_OWNER_TAX_NUMBER));
        String clientEmail = String.valueOf(line.get(COLUMN_OWNER_EMAIL));
        String clientPhoneNumber = String.valueOf(line.get(COLUMN_OWNER_PHONE));

        return clientRepository.createClient(
                clientName,
                clientEmail,
                Integer.getInteger(clientPassportNumber),
                Integer.getInteger(clientTaxNumber),
                Integer.getInteger(clientPhoneNumber)
        );
    }

    private static Property parsePropertyData(List<?> line){
        String propertyTypeString, locationString;
        int numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces;
        float area, cityCenterDistance;
        boolean hasCentralHeating, hasAirCon, hasBasement, hasInhabitableLoft;
        TypeOfProperty typeOfProperty;
        SunExposure sunExposure;
        ArrayList<String> equipment = new ArrayList<>();

        propertyTypeString = String.valueOf(line.get(COLUMN_PROPERTY_TYPE)).toLowerCase();
        typeOfProperty = TypeOfProperty.valueOf(propertyTypeString);

        locationString = String.valueOf(line.get(COLUMN_PROPERTY_LOCATION));
        Location location = parseLocation(locationString);

        area = Float.valueOf(String.valueOf(line.get(COLUMN_PROPERTY_AREA)));
        cityCenterDistance = Float.valueOf(String.valueOf(line.get(COLUMN_PROPERTY_CITY_CENTER_DISTANCE)));
        sunExposure = SunExposure.valueOf(String.valueOf(line.get(COLUMN_PROPERTY_SUN_EXPOSURE)));


        //if (!typeOfProperty.equals(TypeOfProperty.LAND)) {
            numberOfBedrooms = Integer.getInteger(String.valueOf(COLUMN_PROPERTY_NUMBER_BEDROOMS));
            numberOfBathrooms = Integer.getInteger(String.valueOf(COLUMN_PROPERTY_NUMBER_BATHROOMS));
            numberOfParkingSpaces = Integer.getInteger(String.valueOf(COLUMN_PROPERTY_NUMBER_PARKING));

            hasCentralHeating = String.valueOf(line.get(COLUMN_PROPERTY_EQUIPMENT_HEATING)).equals(CSV_VALUE_YES);
            if (hasCentralHeating) equipment.add("central heating");
            hasAirCon = String.valueOf(line.get(COLUMN_PROPERTY_EQUIPMENT_AIRCON)).equals(CSV_VALUE_YES);
            if (hasAirCon) equipment.add("air conditioner");

            hasBasement = String.valueOf(line.get(COLUMN_PROPERTY_BASEMENT)).equals(CSV_VALUE_YES);
            hasInhabitableLoft = String.valueOf(line.get(COLUMN_PROPERTY_LOFT)).equals(CSV_VALUE_YES);
        //}


        Property property = null;
        switch (typeOfProperty){
            case HOUSE:
                property = Announcement.createProperty(
                        area,
                        location,
                        cityCenterDistance,
                        null,
                        numberOfBedrooms,
                        numberOfBathrooms,
                        numberOfParkingSpaces,
                        equipment,
                        hasBasement,
                        hasInhabitableLoft,
                        sunExposure
                        );
                break;
            case APARTMENT:
                property = Announcement.createProperty(
                        area,
                        location,
                        cityCenterDistance,
                        null,
                        numberOfBedrooms,
                        numberOfBathrooms,
                        numberOfParkingSpaces,
                        equipment
                );
                break;
            case LAND:
                property = Announcement.createProperty(
                        area,
                        location,
                        cityCenterDistance,
                        null
                );
                break;
        }

        return property;
    }

    private static Announcement parseAnnouncementData(List<?> line){
        Date date;
        AnnouncementStatus announcementStatus;
        float price, commission;
        TypeOfBusiness typeOfBusiness;
        Property property;
        Employee employee;

        date = parseYyyyMmDdDate(String.valueOf(line.get(COLUMN_ANNOUNCEMENT_DATE)));
        typeOfBusiness = TypeOfBusiness.valueOf(String.valueOf(line.get(COLUMN_ANNOUNCEMENT_TYPE_BUSINESS)));
        announcementStatus = typeOfBusiness.equals(TypeOfBusiness.SELL) ? AnnouncementStatus.SOLD : AnnouncementStatus.RENTED;
        property = parsePropertyData(line);
        price = Float.parseFloat(String.valueOf(line.get(COLUMN_ANNOUNCEMENT_PRICE)));
        commission = Float.parseFloat(String.valueOf(line.get(COLUMN_ANNOUNCEMENT_COMMISSION))) * (float) 0.01;
        employee = employeeRepository.getEmployee(LEGACY_AGENT_NAME);

        return announcementRepository.createAnnouncement(date,announcementStatus,price,commission,typeOfBusiness,property,employee);
    }



    private static Location parseLocation(String location){
        String fields[]=location.split(",");
        int numberOfFields = fields.length;
        boolean hasDistrictField = (numberOfFields == 5);

        int doorNumber;
        try {
            doorNumber = Integer.parseInt(fields[0].split(" ")[0]);
        } catch (NumberFormatException e){
            doorNumber = -1;
        }

        String street;
        City city;
        int zipCode = 0;

        if(doorNumber != -1){
            street = fields[0].substring(fields[0].indexOf(" ")+1);
        } else {
            street = fields[0];
        }

        String cityName = fields[1];
        String districtName = null;
        String stateName = null;

        if(hasDistrictField){
            districtName = fields[2];
            stateName = fields[3];
            zipCode = Integer.getInteger(fields[4]);
        } else {
            stateName = fields[2];
            zipCode = Integer.getInteger(fields[3]);
        }

        //TODO: associate state with city
        State state;
        state = stateRepository.findByName(stateName);
        if(state == null){
            state = stateRepository.createState(stateName, new ArrayList<>());
            stateRepository.save(state);
        }

        city = cityRepository.findByName(cityName);
        if(city == null) {
            city = cityRepository.createCity(cityName);
            cityRepository.save(city);
        }

        Location locationObj = new Location(doorNumber, street, city, zipCode);

        return locationObj;
    }

    private static Date parseYyyyMmDdDate(String date){
        String splitDate[] = date.split("-");
        return new Date(
                Integer.getInteger(splitDate[2]),
                Integer.getInteger(splitDate[1]),
                Integer.getInteger(splitDate[0])
        );
    }

}
