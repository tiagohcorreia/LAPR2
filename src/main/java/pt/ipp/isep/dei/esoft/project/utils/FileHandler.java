package pt.ipp.isep.dei.esoft.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileHandler {

    private static final String FIELD_DELIMITER = ",";
    private static final String LINE_DELIMITER = "\n";
    private static final String DELIMITER = ",";

    //
    public static File readFile(String filePath) throws FileNotFoundException{
        return new File(filePath);
    }

    public static List<?> readCSV(File file) throws FileNotFoundException {
        List<List<String>> csv = new ArrayList<>();
        Scanner sc = new Scanner(file);
        sc.useDelimiter(DELIMITER);
        while (sc.hasNextLine()){
            List<String> thisLine = new ArrayList<>();
            String line = sc.nextLine();
            String[] lineElements = line.split(",");
            for(String element: lineElements){
                thisLine.add(element);
            }
            csv.add(thisLine);
        }
        sc.close();
        return csv;
    }
}
