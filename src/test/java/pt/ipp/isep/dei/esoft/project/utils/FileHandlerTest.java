package pt.ipp.isep.dei.esoft.project.utils;

import pt.ipp.isep.dei.esoft.project.utils.FileHandler;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    private static final String FILEPATH = "FileHandlerTestFile.csv";


    File generateTestFile() throws FileNotFoundException {
        String testString = generateCSVString();
        File file = new File(FILEPATH);
        PrintWriter writer = new PrintWriter(file);
        writer.write(testString);
        writer.close();
        return file;
    }

    String generateCSVString(){
        String testString = new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append("L" + (i+1) + "E" + (j+1) + ",");
            }
            sb.append("\n");
        }
        testString = sb.toString();
        return testString;
    }

    List<List<String>> CSVStringToList(String csv){
        List<List<String>> csvAsList = new ArrayList<>();
        String[] lines = csv.split("\n");
        for (String line: lines) {
            String[] elements = line.split(",");
            csvAsList.add(new ArrayList<>());
            for (String element: elements)
                csvAsList.get(csvAsList.size()-1).add(element);
        }
        return csvAsList;
    }

    @Test
    void ensureReadFileWorks() throws FileNotFoundException {
        //Arrange
        File file = generateTestFile();

        //Act
        File resultFile = FileHandler.readFile(FILEPATH);

        //Assert
        assertEquals(file, resultFile);
    }

    @Test
    void ensureReadCSVWorks() throws FileNotFoundException {
        //Arrange
        File testfile = generateTestFile();
        String testString = generateCSVString();
        List<?> testCSVList = CSVStringToList(testString);

        //Act
        List<?> readData = FileHandler.readCSV(testfile);

        //Assert
        assertEquals(readData, testCSVList);

    }
}