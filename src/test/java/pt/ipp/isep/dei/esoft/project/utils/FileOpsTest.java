package pt.ipp.isep.dei.esoft.project.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class FileOpsTest {

    //Filepaths
    private static final String CSV_FILE_FILEPATH = "example_csv_file.csv";
    private static final String TEST_FILE_FILEPATH = "example_text_file.txt";
    private static final String TEST_FILE_2_FILEPATH = "example_text_file_2.txt";
    private static final String EMPTY_CSV_FILE_FILEPATH = "empty_file.csv";
    private static final String NONEXISTENT_FILE_FILEPATH = "nofile.xyz";

    //File contents
    private static final String EXAMPLE_LINE_1 = "This is a, test file!";
    private static final String EXAMPLE_LINE_2 = "And something else...";



    @BeforeAll
    static void arrange(){
        //Generate files
        FileOps.createFile(CSV_FILE_FILEPATH, generateCSVString());
        FileOps.createFile(TEST_FILE_FILEPATH, EXAMPLE_LINE_1);
        FileOps.createFile(TEST_FILE_2_FILEPATH,EXAMPLE_LINE_1 + "\n" + EXAMPLE_LINE_2);
        FileOps.createFile(EMPTY_CSV_FILE_FILEPATH,"");

    }


    @AfterAll
    static void cleanup(){
        try {
            FileOps.deleteFile(TEST_FILE_FILEPATH);
            FileOps.deleteFile(TEST_FILE_2_FILEPATH);
            FileOps.deleteFile(EMPTY_CSV_FILE_FILEPATH);
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




    @Test
    void ensureReadFileWorks() throws FileNotFoundException {
        //Act
        File resultFile = FileOps.readFile(CSV_FILE_FILEPATH);

        //Assert
        assertEquals(new File(CSV_FILE_FILEPATH), resultFile);
    }



    @Test
    void ensureReadFileThrowsFileNotFoundException(){
        //Act & Assert
        assertThrows(FileNotFoundException.class, () -> {
            File file = FileOps.readFile("testfile.example");
        });
    }


    @Test
    void ensureReadFileThrowsInvalidArgumentException(){
        //Arrange
        String userDirectory = System.getProperty("user.dir");

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            File file = FileOps.readFile(userDirectory);
        });
    }




    @Test
    void ensureAppendToFileWorks() throws IOException {
        //Arrange
        File f1 = new File(TEST_FILE_FILEPATH);
        File f2 = new File(TEST_FILE_2_FILEPATH);

        //Act
        FileOps.appendToFile(TEST_FILE_FILEPATH, "\n"+EXAMPLE_LINE_2);

        //Assert
        assertEquals(-1L, Files.mismatch(f1.toPath(), f2.toPath()));
    }


    @Test
    void ensureDeleteFileThrowsFileNotFoundException(){
        //Arrange
        assertThrows(FileNotFoundException.class, () -> FileOps.deleteFile(NONEXISTENT_FILE_FILEPATH));
    }

    @Test
    void ensureIsFileEmptyWorks(){
        assertTrue(FileOps.isFileEmpty(new File(EMPTY_CSV_FILE_FILEPATH)));
    }
}