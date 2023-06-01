package pt.ipp.isep.dei.esoft.project.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvHandlerTest {
    //Filepaths
    private static final String CSV_FILE_FILEPATH = "example_csv_file.csv";
    private static final String TEST_FILE_FILEPATH = "example_text_file.txt";

    //File contents
    private static final String EXAMPLE_LINE_1 = "This is a, test file!";

    //CSV data
    private static final List<List<String>> data = new ArrayList<>();


    @BeforeAll
    static void arrange(){
        //Generate files
        FileOps.createFile(CSV_FILE_FILEPATH, generateCSVString());
        FileOps.createFile(TEST_FILE_FILEPATH, EXAMPLE_LINE_1);

        //Generate CSV data as list of string lists
        for (int i = 0; i < 10; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                line.add("L"+(i+1)+"E"+(j+1));
            }
            data.add(line);
        }
    }


    @AfterAll
    static void cleanup(){
        try {
            FileOps.deleteFile(TEST_FILE_FILEPATH);
            FileOps.deleteFile(CSV_FILE_FILEPATH);
        } catch (Exception e){
            System.out.println("Couldn't delete test files!");
        }
    }


    private static String generateCSVString(){
        String testString = new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append("L" + (i+1) + "E" + (j+1));
                if (j != 9)
                    sb.append(",");
            }
            sb.append("\n");
        }
        testString = sb.toString();
        return testString;
    }


    private List<List<String>> CSVStringToList(String csv){
        List<List<String>> csvAsList = new ArrayList<>();
        String[] lines = csv.split("\n");
        for (String line: lines) {
            String[] elements = line.split(";");
            csvAsList.add(new ArrayList<>());
            for (String element: elements)
                csvAsList.get(csvAsList.size()-1).add(element);
        }
        return csvAsList;
    }


    @Test
    void ensureReadCSVThrowsInvalidFileTypeException() throws FileNotFoundException {
        //Arrange
        FileOps.createFile(TEST_FILE_FILEPATH,"This is a, test file!");
        File file = FileOps.readFile(TEST_FILE_FILEPATH);

        //Act & Assert
        assertThrows(InvalidFileTypeException.class, () -> {
            List<?> csv = CsvHandler.getDataFromCsvFile(file);
        });
    }


    @Test
    void ensureCsvIsEmptyThrowsIllegalArgumentException() {
        //Arrange
        List<?> csv = new ArrayList<>();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            CsvHandler.csvIsEmpty(csv);
        });
    }


    @Test
    void ensureReadCSVWorks() throws InvalidFileTypeException {
        //Arrange
        File csvFile = new File(CSV_FILE_FILEPATH);
        List<?> dataWithoutHeader = this.data.subList(1,this.data.size());

        //Act & Assert
        assertEquals(dataWithoutHeader,CsvHandler.getDataFromCsvFile(csvFile));
    }

    @Test
    void getDataFromCsvFile() {
    }

    @Test
    void csvIsEmpty() {
    }

    @Test
    void parseCSV() {
    }
}