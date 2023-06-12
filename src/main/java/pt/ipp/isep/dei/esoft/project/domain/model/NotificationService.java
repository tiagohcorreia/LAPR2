package pt.ipp.isep.dei.esoft.project.domain.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

    public class NotificationService implements Serializable {
        private static final String NOTIFICATION_FILE = "notifications.txt";

        public void sendNotification(String recipient, String subject, String message) {
            String formattedMessage = formatMessage(recipient, subject, message);
            saveNotificationToFile(formattedMessage);
        }

        private String formatMessage(String recipient, String subject, String message) {
            LocalDateTime timestamp = LocalDateTime.now();
            return String.format("[%s]\nRecipient: %s\nSubject: %s\nMessage: %s\n\n", timestamp, recipient, subject, message);
        }

        private void saveNotificationToFile(String formattedMessage) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTIFICATION_FILE, true))) {
                writer.write(formattedMessage);
                System.out.println("Notification saved to file: " + NOTIFICATION_FILE);
            } catch (IOException e) {
                System.out.println("Failed to save notification to file: " + e.getMessage());
            }
        }
    }


