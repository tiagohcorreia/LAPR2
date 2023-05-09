package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Unregistered user ui.
 */
public class UnregisteredUserUI implements Runnable {
    /**
     * Instantiates a new Unregistered user ui.
     */
    public UnregisteredUserUI() {

    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();

        options.add(new MenuItem("Display listed properties", new DisplayAnnouncementsUI()));
        options.add(new MenuItem("Register as client", new RegisterUserUI()));
        //options.add(new MenuItem("Specify states, districts or cities", new SpecifyStatesDistrictsCitiesUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nUnregistered User Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
