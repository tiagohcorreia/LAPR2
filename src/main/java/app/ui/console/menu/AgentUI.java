package app.ui.console.menu;

import app.controller.PublishAnnouncementController;
import app.domain.repository.AnnouncementRepository;
import app.ui.console.PublishAnnouncementUI;

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
                   new PublishAnnouncementUI();
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
