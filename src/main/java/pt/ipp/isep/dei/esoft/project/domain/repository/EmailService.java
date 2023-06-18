package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Client;

/**
 * The type Email service.
 */
public class EmailService {
    /**
     * Send notification.
     *
     * @param client  the client
     * @param message the message
     */
    public void sendNotification(Client client, String message) {
        // Logic to send an email
        // You would use a library or service to send emails in a real application.

        // For now, we just print out the "email"
        System.out.println("Sending email to: " + client.getEmail());
        System.out.println("Message: " + message);
    }


}
