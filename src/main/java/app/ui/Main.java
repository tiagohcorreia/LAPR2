package app.ui;

import app.controller.CityController;
import app.controller.DistrictController;
import app.controller.StateController;
import app.domain.repository.CityRepository;
import app.domain.repository.DistrictRepository;
import app.domain.repository.StateRepository;
import app.ui.console.CityUI;
import app.ui.console.DistrictUI;
import app.ui.console.StateUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CityRepository cityRepository = new CityRepository();
        DistrictRepository districtRepository = new DistrictRepository();
        StateRepository stateRepository = new StateRepository();

        CityController cityController = new CityController(cityRepository);
        DistrictController districtController = new DistrictController(districtRepository);
        StateController stateController = new StateController(stateRepository);

        CityUI cityUI = new CityUI(cityController);
        DistrictUI districtUI = new DistrictUI(districtController);
        StateUI stateUI = new StateUI(stateController);

        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Bem-vindo ao Sistema de Gerenciamento Geográfico!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar Cidades");
            System.out.println("2. Gerenciar Distritos");
            System.out.println("3. Gerenciar Estados");
            System.out.println("4. Sair");

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
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
    

