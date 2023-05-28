package pt.ipp.isep.dei.esoft.project.utils;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import java.io.File;
import java.util.*;

import static pt.ipp.isep.dei.esoft.project.utils.FileHandler.CSV_DELIMITER;

public class CsvHandler {
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
    private static final int COLUMN_PROPERTY_NUMBER_PARKING = 11;
    private static final int COLUMN_PROPERTY_EQUIPMENT_HEATING = 12;
    private static final int COLUMN_PROPERTY_EQUIPMENT_AIRCON = 13;
    private static final int COLUMN_PROPERTY_BASEMENT = 14;
    private static final int COLUMN_PROPERTY_LOFT = 15;
    private static final int COLUMN_PROPERTY_SUN_EXPOSURE = 16;
    //private static final int COLUMN_PROPERTY_REQUESTED_PRICE = 17;
    private static final int COLUMN_PROPERTY_PRICE = 18;

    private static final int COLUMN_ANNOUNCEMENT_PRICE = 19;
    private static final int COLUMN_ANNOUNCEMENT_COMMISSION = 20;
    //...
    private static final int COLUMN_ANNOUNCEMENT_TYPE_SALE = 24;

    private static final int COLUMN_BRANCH_ID = 25;
    private static final int COLUMN_BRANCH_NAME = 26;
    private static final int COLUMN_BRANCH_LOCATION = 27;
    private static final int COLUMN_BRANCH_PHONE = 28;
    private static final int COLUMN_BRANCH_EMAIL = 29;

    static StateRepository stateRepository = Repositories.getInstance().getStateRepository();
    static CityRepository cityRepository = Repositories.getInstance().getCityRepository();
    static BranchRepository branchRepository = Repositories.getInstance().getBranchRepository();
    static ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();





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
            sc.useDelimiter(CSV_DELIMITER);
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
            return csv.remove(0);
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
            //Property property = parsePropertyData((List<?>) line);
            Announcement announcement = parseAnnouncementData((List<?>) line);

            try{
                success = (branchRepository.saveBranch(branch) && success);
                success = (clientRepository.add(client));
                success = (announcementRepository.save(announcement));
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

        return null;
    }

    private static Announcement parseAnnouncementData(List<?> line){

        return null;
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

}
