package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterVisitController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.model.Visit;
import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * The type Register visit ui.
 */
public class RegisterVisitUI implements Runnable {

    private final RegisterVisitController controller;

    /**
     * Instantiates a new Register visit ui.
     */
    public RegisterVisitUI() {
        this.controller = new RegisterVisitController();

    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        String agentName = controller.getCurrentAgent();
        Employee agent = controller.getEmployeeByName(agentName);

        System.out.println("=== Visit Registration ===");

        List<Schedule> scheduleList = controller.getScheduleForAgent(agent);

        System.out.println("Available Visits:");
        displayScheduleList(scheduleList);


        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter the index of the visit to register: ");
                int selectedIndex = scanner.nextInt();

                if (selectedIndex >= 0 && selectedIndex < scheduleList.size()) {
                    Schedule selectedSchedule = scheduleList.get(selectedIndex);

                    System.out.println("Enter your opinion about the business: ");
                    String opinionAboutBusiness = scanner.next();

                    System.out.println("Enter the rating (1-5): ");
                    for (Rating rating : Rating.values()) {
                        System.out.println(rating.ordinal() + ". " + rating.name());
                    }
                    int selectedRating = scanner.nextInt();
                    Rating[] ratings = Rating.values();

                    if (selectedRating >= 0 && selectedRating < ratings.length) {
                        Rating selectedRating2 = ratings[selectedRating];
                        controller.registerVisit(selectedSchedule, opinionAboutBusiness, selectedRating2);
                        System.out.println("Visit registered successfully.");
                        validInput = true; // A entrada foi válida, sair do loop
                    } else {
                        throw new IllegalArgumentException("Invalid rating selected.");
                    }
                } else {
                    throw new IndexOutOfBoundsException("Invalid index.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Limpar a entrada inválida do scanner
            }

        }

    }

    private void displayScheduleList(List<Schedule> scheduleList) {
        for (int i = 0; i < scheduleList.size(); i++) {
            Schedule schedule = scheduleList.get(i);
            System.out.println("Index: " + i + ", Schedule: " + schedule.toString());
        }

    }


}

