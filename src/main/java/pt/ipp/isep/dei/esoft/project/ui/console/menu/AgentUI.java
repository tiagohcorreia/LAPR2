
package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.PublishAnnouncementUI;

import java.util.Scanner;

public class AgentUI{

    private Scanner scanner;


    public AgentUI() {
        Scanner scanner = new Scanner(System.in);


    }

    public void run() {

        boolean exit = false;
        do {
            System.out.println("Hello, Agent");
            System.out.println("1. Publish Announcement");
            System.out.println("2. Exit");
            System.out.println("Select an option:");
            String option = scanner.nextLine();

            switch (option){
                case "1":
                   new PublishAnnouncementUI(new PublishAnnouncementController(new AnnouncementRepository()));
                    break;
                case "2":
                    exit = true;
                default:
                    System.out.println("Invalid option!");
                    break;

            }
        } while (!exit);
        scanner.close();
    }

}

