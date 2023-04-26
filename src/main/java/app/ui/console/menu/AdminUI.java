package app.ui.console.menu;

import app.ui.console.RegisterEmployeeUI;
import app.ui.console.ShowTextUI;
import app.ui.console.utils.Utils;
import app.ui.console.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        //options.add(new MenuItem("Register Employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Option 1 ", new ShowTextUI("You have chosen Option A.")));
        options.add(new MenuItem("Option 2 ", new ShowTextUI("You have chosen Option B.")));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
