package app.ui.console.menu;

import app.controller.RegisterEmployeeController;
import app.domain.repository.RegisterEmployeeRepository;
import app.ui.console.*;
import app.ui.console.utils.Utils;


import java.util.ArrayList;
import java.util.List;

public class AdminUI implements Runnable {
    public AdminUI() {

    }

    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Register Employee", new RegisterEmployeeUI(new RegisterEmployeeController(new RegisterEmployeeRepository()))));
        options.add(new MenuItem("Specify states, districts or cities", new SpecifyStatesDistrictsCitiesUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
