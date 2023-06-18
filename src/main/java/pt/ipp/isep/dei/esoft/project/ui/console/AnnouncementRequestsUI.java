package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.application.controller.AnnouncementRequestsController;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.NotificationService;

import java.util.List;
import java.util.Scanner;


/**
 * The type Announcement requests ui.
 */
public class AnnouncementRequestsUI implements Runnable{

    private Scanner scanner;

    private final AnnouncementRequestsController controller;


    /**
     * Instantiates a new Announcement requests ui.
     */
    public AnnouncementRequestsUI() {
                this.controller = new AnnouncementRequestsController();
            }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        Employee agent = controller.getCurrentAgent();
        String agentName = agent.getName();

        System.out.print("======Requests======\n\n ");

        if (controller.isEmployee(agentName)) {

            List<AnnouncementRequestDTO> announcements = controller.getAnnouncementRequests(agent);
            if (!announcements.isEmpty()) {
             System.out.println("=== Announcement Requests ===\n\n");
            for (int i = 0; i < announcements.size(); i++) {
                System.out.println("Index: " + i);
                System.out.println(announcements.get(i).toString());
            }


                System.out.print("Enter the index of the announcement to view details: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                AnnouncementRequestDTO announcement = controller.getAnnouncementByIndex(index, agent);
                if (announcement != null) {
                    System.out.println("=== Announcement Details ===\n\n");
                    System.out.println(announcement);

                    System.out.println("Choose an option:");
                    System.out.println("1. Accept");
                    System.out.println("2. Reject");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    Client owner = announcement.getOwner();


                    switch (choice) {
                        case 1:
                            System.out.print("Enter the commission: ");
                            float commission = scanner.nextFloat();
                            scanner.nextLine();
                            controller.acceptAnnouncementRequest(index, commission, agent);
                            System.out.println("Announcement accepted and saved.");
                            break;
                        case 2:
                            System.out.print("Enter the reason for rejection: ");
                            String reason = scanner.nextLine();
                            controller.rejectAnnouncementRequest(index, reason, agent);


                            String subject = "Rejection of Announcement";
                            String message = "Dear " + owner.getName() + "\nYour announcement has been rejected for the following reason: " + reason;
                            NotificationService notificationService = new NotificationService();
                            notificationService.sendNotification(owner.getEmail(), subject, message);

                            System.out.println("Announcement rejected and reason saved.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } else {
                    System.out.println("Invalid announcement index.");
                }
            } else {
                System.out.println("No announcement requests for the agent.");
            }
        } else {
            System.out.println("Invalid agent name.");
        }
    }

}




