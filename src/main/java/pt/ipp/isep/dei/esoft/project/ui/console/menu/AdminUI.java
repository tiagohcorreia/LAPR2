package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterEmployeeRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateTaskUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterEmployeeUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.SpecifyStatesDistrictsCitiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin ui.
 */
public class AdminUI implements Runnable {
    /**
     * Instantiates a new Admin ui.
     */
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Task", new CreateTaskUI()));
        options.add(new MenuItem("Specify states, districts or cities", new SpecifyStatesDistrictsCitiesUI()));
        options.add(new MenuItem("Register Employee ", new RegisterEmployeeUI(new RegisterEmployeeController(new RegisterEmployeeRepository()))));
        options.add(new MenuItem("Option 3 ", new ShowTextUI("You have chosen Option C.")));
        //options.add(new MenuItem("Import from legacy system ", new ImportFromLegacyUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
