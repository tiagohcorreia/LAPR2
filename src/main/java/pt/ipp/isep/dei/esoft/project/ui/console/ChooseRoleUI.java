package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.ui.console.menu.AdminUI;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.OwnerUI;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.UnregisteredUserUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Choose role ui.
 */
public class ChooseRoleUI implements Runnable {

    @Override
    public void run() {

        System.out.println("1.Administrator");
        System.out.println("2.Owner");
        System.out.println("3.Agent");
        System.out.println("4.Unregistered User");


        int option = Utils.readIntegerFromConsole("Choose your role");

        switch (option) {

            case 1:
                AdminUI adminUI = new AdminUI();
                adminUI.run();
                break;
            case 2:
                //TO DO - Create a UI for the owner
                OwnerUI ownerUI = new OwnerUI();
                ownerUI.run();
                break;
            case 3:
                //TO DO - Create a UI for the agent

                break;
            case 4:
                UnregisteredUserUI unregisteredUserUI = new UnregisteredUserUI();
                unregisteredUserUI.run();
                break;
        }
    }
}
