package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CityController;
import pt.ipp.isep.dei.esoft.project.domain.model.City;

import java.util.Scanner;

/**
 * The type City ui.
 */
public class CityUI {
    private final CityController cityController;
    private final Scanner scanner;

    /**
     * Instantiates a new City ui.
     *
     * @param cityController the city controller
     */
    public CityUI(CityController cityController) {
        this.cityController = cityController;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Run.
     */
    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nCity Menu:");
            System.out.println("1. Add City");
            System.out.println("2. Find City");
            System.out.println("3. List Cities");
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addCity();
                    break;
                case 2:
                    findCity();
                    break;
                case 3:
                    listCities();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addCity() {
        System.out.println("Enter the city name:");
        String cityName = scanner.nextLine();
        cityController.addCity(cityName);
        System.out.println("City added successfully.");
    }

    private void findCity() {
        System.out.println("Enter the city name to search:");
        String cityName = scanner.nextLine();
        City city = cityController.findCityByName(cityName);
        if (city != null) {
            System.out.println("City found: " + city);
        } else {
            System.out.println("City not found.");
        }
    }

    private void listCities() {
        System.out.println("Cities:");
        for (City city : cityController.getAllCities()) {
            System.out.println(city);
        }
    }
}

