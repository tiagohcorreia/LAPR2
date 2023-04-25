package app.ui.console;

import app.controller.StateController;
import app.domain.model.State;

import java.util.Scanner;

public class StateUI {
    private final StateController stateController;
    private final Scanner scanner;

    public StateUI(StateController stateController) {
        this.stateController = stateController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nState Menu:");
            System.out.println("1. Add State");
            System.out.println("2. Find State");
            System.out.println("3. List States");
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addState();
                    break;
                case 2:
                    findState();
                    break;
                case 3:
                    listStates();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addState() {
        System.out.println("Enter the state name:");
        String stateName = scanner.nextLine();
        stateController.addState(stateName);
        System.out.println("State added successfully.");
    }

    private void findState() {
        System.out.println("Enter the state name to search:");
        String stateName = scanner.nextLine();
        State state = stateController.findStateByName(stateName);
        if (state != null) {
            System.out.println("State found: " + state);
        } else {
            System.out.println("State not found.");
        }
    }

    private void listStates() {
        System.out.println("States:");
        for (State state : stateController.getAllStates()) {
            System.out.println(state);
        }
    }
}

