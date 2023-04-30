package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.StateController;
import pt.ipp.isep.dei.esoft.project.application.controller.DistrictController;
import pt.ipp.isep.dei.esoft.project.domain.model.State;
import pt.ipp.isep.dei.esoft.project.domain.model.District;

import java.util.Scanner;

/**
 * The type State ui.
 */
public class StateUI {
    private final StateController stateController;
    private final DistrictController districtController;
    private final Scanner scanner;

    /**
     * Instantiates a new State ui.
     *
     * @param stateController    the state controller
     * @param districtController the district controller
     */
    public StateUI(StateController stateController, DistrictController districtController) {
        this.stateController = stateController;
        this.districtController = districtController;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Run.
     */
    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nState Menu:");
            System.out.println("1. Add State");
            System.out.println("2. Find State");
            System.out.println("3. List States");
            System.out.println("4. Add District to State");
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
                case 4:
                    addDistrictToState();
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

    private void addDistrictToState() {
        System.out.println("Enter the state name:");
        String stateName = scanner.nextLine();
        State state = stateController.findStateByName(stateName);
        if (state != null) {
            System.out.println("Enter the district name:");
            String districtName = scanner.nextLine();
            District district = districtController.findDistrictByName(districtName);
            if (district != null) {
                stateController.addDistrictToState(state, district);
                System.out.println("District added to the state successfully.");
            } else {
                System.out.println("District not found.");
            }
        } else {
            System.out.println("State not found.");
        }
    }
}
