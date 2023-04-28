package app.ui.console;

import app.ui.console.menu.AdminUI;
import app.ui.console.menu.AgentUI;
import app.ui.console.menu.OwnerUI;
import app.ui.console.utils.Utils;

public class ChooseRoleUI implements Runnable {

    @Override
    public void run() {

        System.out.println("1.Administrator");
        System.out.println("2.Owner");
        System.out.println("1.Agent");

        Integer option = Utils.readIntegerFromConsole("Choose your role");

        switch (option) {

            case 1:
                AdminUI adminUI = new AdminUI();
                adminUI.run();

            case 2:
                //TO DO - Create a UI for the owner
                OwnerUI ownerUI = new OwnerUI();
                ownerUI.run();

            case 3:
                //TO
                AgentUI AgentUI = new AgentUI();
                AgentUI.run();
        }
    }
}
