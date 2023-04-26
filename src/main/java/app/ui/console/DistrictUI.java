package app.ui.console;

import app.controller.CityController;
import app.controller.DistrictController;
import app.domain.model.City;
import app.domain.model.District;

import java.util.Scanner;

public class DistrictUI {
    private final DistrictController districtController;
    private final CityController cityController;
    private final Scanner scanner;

    public DistrictUI(DistrictController districtController, CityController cityController) {
        this.districtController = districtController;
        this.cityController = cityController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nDistrict Menu:");
            System.out.println("1. Add District");
            System.out.println("2. Find District");
            System.out.println("3. List Districts");
            System.out.println("4. Add City to District");
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
                case 4:
                    addCityToDistrict();
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

    private void addCityToDistrict() {
        System.out.println("Enter the district name:");
        String districtName = scanner.nextLine();

        System.out.println("Enter the city name:");
        String cityName = scanner.nextLine();

        City city = cityController.findCityByName(cityName);

        if (city == null) {
            System.out.println("City not found. Creating a new city.");
            cityController.addCity(cityName);
            city = cityController.findCityByName(cityName);
        }

        districtController.addCityToDistrict(districtName, city);
        System.out.println("City added to district successfully.");
    }
}