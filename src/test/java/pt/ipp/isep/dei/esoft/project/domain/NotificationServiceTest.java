package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.NotificationService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;

public class NotificationServiceTest {

    private NotificationService notificationService;

    private static final String RECIPIENT = "Nilsa Gil";
    private static final String SUBJECT = "ANNOUNCEMENT NOTIFICATION";
    private static final String MESSAGE = "Dear client, your announcement was published. ";

    @BeforeEach
    public void setUp() {
        notificationService = new NotificationService();
    }

    @Test
    public void ensureSendNotificationWritesToFile(@TempDir File tempDir) throws IOException {
        File tempFile = new File(tempDir, "notifications.txt");

        notificationService.sendNotification(RECIPIENT, SUBJECT, MESSAGE);

        String expected = String.format("[*]\nRecipient: %s\nSubject: %s\nMessage: %s\n\n", RECIPIENT, SUBJECT, MESSAGE);

        writeToFile(tempFile, expected);

        String actual = readNotificationFromFile(tempFile);

        Assertions.assertEquals(expected, actual);
    }

    private void writeToFile(File file, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    private String readNotificationFromFile(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("The file is empty: " + file.getAbsolutePath());
            }

            while (line != null) {
                sb.append(line).append("\n");
                line = reader.readLine();
            }
        }

        return sb.toString();
    }
    @Test
    public void ensureNotificationServiceSerialization() throws IOException, ClassNotFoundException {

        NotificationService originalService = new NotificationService();

        String filename = "notificationService.ser";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(originalService);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        NotificationService deserializedService = (NotificationService) inputStream.readObject();
        inputStream.close();

        Assertions.assertEquals(originalService, deserializedService);
    }
}
