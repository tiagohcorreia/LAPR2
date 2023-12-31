package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CityController;
import pt.ipp.isep.dei.esoft.project.application.controller.DistrictController;
import pt.ipp.isep.dei.esoft.project.application.controller.StateController;
import pt.ipp.isep.dei.esoft.project.domain.repository.CityRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.DistrictRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.StateRepository;

import java.util.Scanner;

/**
 * The type Specify states districts cities ui.
 */
public class SpecifyStatesDistrictsCitiesUI implements Runnable {

    @Override
    public void run() {
        CityRepository cityRepository = new CityRepository();
        DistrictRepository districtRepository = new DistrictRepository();
        StateRepository stateRepository = new StateRepository();

        CityController cityController = new CityController(cityRepository);
        DistrictController districtController = new DistrictController(districtRepository);
        StateController stateController = new StateController(stateRepository);

        CityUI cityUI = new CityUI(cityController);
        DistrictUI districtUI = new DistrictUI(districtController, cityController);
        StateUI stateUI = new StateUI(stateController, districtController);
        DisplayAnnouncementsUI displayAnnouncementsUI = new DisplayAnnouncementsUI();

        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Welcome to the Real State USA Company System!");
            System.out.println("Choose an option:");
            System.out.println("1. Manage Cities");
            System.out.println("2. Manage Districts");
            System.out.println("3. Manage States");
            System.out.println("4. Display listings");
            System.out.println("0. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    cityUI.run();
                    break;
                case 2:
                    districtUI.run();
                    break;
                case 3:
                    stateUI.run();
                    break;
                case 4:
                    displayAnnouncementsUI.run();
                    break;
                case 0:
                   return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
