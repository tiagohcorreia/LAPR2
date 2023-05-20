package pt.ipp.isep.dei.esoft.project.utils;

import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static pt.ipp.isep.dei.esoft.project.utils.FileHandler.CSV_DELIMITER;

public interface CsvHandler {
    public static List<?> readCSV(File file) throws InvalidFileTypeException {
        //Check if the filename ends with ".csv"
        String[] filepath = file.getAbsolutePath().split("\\.");
        String extension = filepath[filepath.length-1];
        if(!extension.equalsIgnoreCase("csv"))
            throw new InvalidFileTypeException("Selected file is not a CSV file");

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
        } finally {
            return csv;
        }
    }

    public static boolean csvIsEmpty(List<?> csv){
        return csv.size() == 0;
    }

}
