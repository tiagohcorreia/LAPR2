package app.ui.console;

import app.controller.DistrictController;
import app.domain.model.District;

import java.util.Scanner;

public class DistrictUI {
    private final DistrictController districtController;
    private final Scanner scanner;

    public DistrictUI(DistrictController districtController) {
        this.districtController = districtController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nDistrict Menu:");
            System.out.println("1. Add District");
            System.out.println("2. Find District");
            System.out.println("3. List Districts");
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addDistrict();
                    break;
                case 2:
                    findDistrict();
                    break;
                case 3:
                    listDistricts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addDistrict() {
        System.out.println("Enter the district name:");
        String districtName = scanner.nextLine();
        districtController.addDistrict(districtName);
        System.out.println("District added successfully.");
    }

    private void findDistrict() {
        System.out.println("Enter the district name to search:");
        String districtName = scanner.nextLine();
        District district = districtController.findDistrictByName(districtName);
        if (district != null) {
            System.out.println("District found: " + district);
        } else {
            System.out.println("District not found.");
        }
    }

    private void listDistricts() {
        System.out.println("Districts:");
        for (District district : districtController.getAllDistricts()) {
            System.out.println(district);
        }
    }
}
