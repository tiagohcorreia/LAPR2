package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import javafx.application.Platform;
import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Main menu ui.
 */
public class MainMenuUI implements Runnable {

    /**
     * Instantiates a new Main menu ui.
     */
    public MainMenuUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Login", new AuthenticationUI()));
        options.add(new MenuItem("Unregistered user", new UnregisteredUserUI()));
        options.add(new MenuItem("Development Team", new DevTeamUI()));

        int option = 0;
        do {

            option = Utils.showAndSelectIndex(options, "\n\n=============== Real Estate USA ===============");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
            /*
            if(option == 0){
                try {
                    Platform.exit();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
             */
        } while (option != -1);
        Platform.exit();
    }


}
