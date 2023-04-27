package app.ui.console.menu;

import app.controller.RegisterEmployeeController;
import app.controller.RegisterPropertyController;
import app.domain.repository.AnnouncementRepository;
import app.domain.repository.RegisterEmployeeRepository;
import app.ui.console.RegisterEmployeeUI;
import app.ui.console.RegisterPropertyUI;
import app.ui.console.SpecifyStatesDistrictsCitiesUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class OwnerUI {
    public OwnerUI() {

    }

    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Listing a Property", new RegisterPropertyUI(new RegisterPropertyController(new AnnouncementRepository()))));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
