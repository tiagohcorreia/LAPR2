package pt.ipp.isep.dei.esoft.project.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;

import org.junit.jupiter.api.Test;

import javax.management.InvalidAttributeValueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    private static final String CSV_FILE_FILEPATH = "example_csv_file.csv";
    private static final String TEST_FILE_FILEPATH = "example_file.txt";
    private static final String TEST_FILE_2_FILEPATH = "example_file_2.txt";
    private static final String EMPTY_FILE_FILEPATH = "empty_file.txt";
    private static final List<List<String>> data = new ArrayList<>();

    private static final String EXAMPLE_LINE_1 = "This is a, test file!";
    private static final String EXAMPLE_LINE_2 = "And something else...";


    //private final File csvFile = generateTestFile();

//    public FileHandlerTest(){
//        //final File csvFile = generateTestFile();
//
//        //Generate files
//        FileHandler.createFile(CSV_FILE_FILEPATH, generateCSVString());
//        FileHandler.createFile(TEST_FILE_FILEPATH,"This is a, test file!");
//        FileHandler.createFile(EMPTY_FILE_FILEPATH,"");
//
//        //Generate CSV data as list of string lists
//        List<List<String>> data = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            List<String> line = new ArrayList<>();
//            for (int j = 0; j < 10; j++) {
//                line.add("L"+(i+1)+"E"+(j+1));
//            }
//            data.add(line);
//        }
//    }

    @BeforeAll
    static void arrange(){
        //Generate files
        FileHandler.createFile(CSV_FILE_FILEPATH, generateCSVString());
        FileHandler.createFile(TEST_FILE_FILEPATH,EXAMPLE_LINE_1);
        FileHandler.createFile(TEST_FILE_2_FILEPATH,EXAMPLE_LINE_1 + "\n" + EXAMPLE_LINE_2);
        FileHandler.createFile(EMPTY_FILE_FILEPATH,"");

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
            FileHandler.deleteFile(CSV_FILE_FILEPATH);
            FileHandler.deleteFile(TEST_FILE_FILEPATH);
            FileHandler.deleteFile(TEST_FILE_2_FILEPATH);
            FileHandler.deleteFile(EMPTY_FILE_FILEPATH);
    }



    private File generateTestFile() throws FileNotFoundException {
        String testString = generateCSVString();
        File file = new File(CSV_FILE_FILEPATH);
        PrintWriter writer = new PrintWriter(file);
        writer.write(testString);
        writer.close();
        return file;
    }

    private static String generateCSVString(){
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

    private List<List<String>> CSVStringToList(String csv){
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
        //File file = generateTestFile();

        //Act
        File resultFile = FileHandler.readFile(CSV_FILE_FILEPATH);

        //Assert
        assertEquals(new File(CSV_FILE_FILEPATH), resultFile);
        //assertEquals(file, resultFile);
    }


    @Test
    void ensureReadCSVThrowsInvalidFileTypeException() throws FileNotFoundException {
        //Arrange
        FileHandler.createFile(TEST_FILE_FILEPATH,"This is a, test file!");
        File file = FileHandler.readFile(TEST_FILE_FILEPATH);

        //Act & Assert
        assertThrows(InvalidFileTypeException.class, () -> {
            List<?> csv = FileHandler.readCSV(file);
        });
    }

    @Test
    void ensureReadCSVThrowsFileIsEmptyException(){
        //Arrange


    }

    @Test
    void ensureReadFileThrowsFileNotFoundException(){
        //Act & Assert
        assertThrows(FileNotFoundException.class, () -> {
            File file = FileHandler.readFile("testfile.example");
        });
    }

    @Test
    void ensureReadFileThrowsInvalidArgumentException(){
        //Arrange
        String userDirectory = System.getProperty("user.dir");

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            File file = FileHandler.readFile(userDirectory);
        });
    }


    @Test
    void ensureReadCSVWorks() throws InvalidFileTypeException, InvalidAttributeValueException {
        //Arrange
        //File testfile = generateTestFile();
        //String testString = generateCSVString();
        //List<?> testCSVList = CSVStringToList(testString);

        //Act
        //List<?> readData = FileHandler.readCSV(CSV_FILE_FILEPATH);

        //Assert
        //assertEquals(readData, testCSVList);

        //Arrange
        File csvFile = new File(CSV_FILE_FILEPATH);



        //List<?> data = FileHandler.readCSV(csvFile);

        //Act & Assert
        assertEquals(FileHandler.readCSV(csvFile), this.data);
    }

    @Test
    void ensureAppendToFileWorks() throws IOException {
        //Arrange
        File f1 = new File(TEST_FILE_FILEPATH);
        File f2 = new File(TEST_FILE_2_FILEPATH);

        //Act
        FileHandler.appendToFile(TEST_FILE_FILEPATH, "\n"+EXAMPLE_LINE_2);
        //f1.equals(f2);


        //Assert
        //assertEquals(FileHandler.readFile(TEST_FILE_FILEPATH), FileHandler.readFile(TEST_FILE_2_FILEPATH));
        assertEquals(-1L, Files.mismatch(f1.toPath(), f2.toPath()));
    }
}