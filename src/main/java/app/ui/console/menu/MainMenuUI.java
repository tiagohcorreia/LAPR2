package app.ui.console.menu;

import app.ui.console.ChooseRoleUI;
import app.ui.console.DevTeamUI;
import app.ui.console.UnregisteredUserUI;
import app.ui.console.authorization.AuthenticationUI;
import app.ui.console.utils.Utils;


import java.util.ArrayList;
import java.util.List;

public class MainMenuUI implements Runnable {

    public MainMenuUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do Login", new AuthenticationUI()));
        options.add(new MenuItem("Choose the role for the session", new ChooseRoleUI()));
        options.add(new MenuItem("Use application as a unregistered user", new UnregisteredUserUI()));
        options.add(new MenuItem("Know the Development Team", new DevTeamUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

}
