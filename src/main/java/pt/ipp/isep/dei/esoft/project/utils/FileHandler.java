package pt.ipp.isep.dei.esoft.project.utils;

import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import javax.management.InvalidAttributeValueException;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String DELIMITER = ",";

    public static File readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        if (!file.exists())
            throw new FileNotFoundException("File not found.");
        else if(!file.isFile() || !file.canRead())
            throw new IllegalArgumentException("The selected file is invalid.");
        else
            return file;
    }

    public static List<?> readCSV(File file) throws InvalidAttributeValueException, InvalidFileTypeException {
        //Check if the filename ends with ".csv"
        String[] filepath = file.getAbsolutePath().split("\\.");
        String extension = filepath[filepath.length-1];
        if(!extension.equalsIgnoreCase("csv"))
            throw new InvalidFileTypeException("Selected file is not a CSV file");

        List<List<String>> csv = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter(DELIMITER);
            while (sc.hasNextLine()) {
                List<String> thisLine = new ArrayList<>();
                String line = sc.nextLine();
                String[] lineElements = line.split(",");
                Collections.addAll(thisLine, lineElements);
                csv.add(thisLine);
            }
        } finally {
            return csv;
        }
    }

    public static boolean csvIsEmpty(List<?> csv){
        return (csv.size() == 0)? true : false;
    }

    public static boolean appendToFile(String filepath, String content){
        File file = new File(filepath);
        try {
            Writer writer = new FileWriter(file, true);
            try{
                writer.write(content);
            } catch (Exception e){
                writer.close();
                return false;
            } finally {
                writer.close();
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean createFile(String filepath, String content) {
        File file = new File(filepath);
        try {
            Writer writer = new FileWriter(file);
            try {
                writer.write(content);
            } finally {
                writer.close();
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean deleteFile(String filepath) throws FileNotFoundException {
        File file = readFile(filepath);
        return file.delete();
    }
}
