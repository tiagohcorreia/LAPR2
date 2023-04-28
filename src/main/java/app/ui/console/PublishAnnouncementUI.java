package app.ui.console;

import app.controller.PublishAnnouncementController;

import java.util.Scanner;

public class PublishAnnouncementUI {

    private Scanner scanner;
    private PublishAnnouncementController controller;

    public PublishAnnouncementUI(){
        scanner = new Scanner(System.in);
        controller = new PublishAnnouncementController();
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
                    publishAnnouncement();
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

    private void publishAnnouncement(){}
}
