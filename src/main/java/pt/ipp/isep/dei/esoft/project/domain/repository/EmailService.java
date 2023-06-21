package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Client;

public class EmailService {
    public void sendNotification(Client client, String message) {
        // Logic to send an email
        // You would use a library or service to send emails in a real application.

        // For now, we just print out the "email"
        System.out.println("Sending email to: " + client.getEmail());
        System.out.println("Message: " + message);
    }


    public void sendEmail(String email, String purchaseOrderNotification, String emailContent) {
    }
}
