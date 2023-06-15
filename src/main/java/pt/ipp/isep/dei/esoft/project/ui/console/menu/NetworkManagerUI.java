package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.ListDealsGUI;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagerUI implements Runnable {


    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("List All Employees", new ListAllEmplyeesUI()));
        //options.add(new MenuItem("List all deals made", new ListDealsGUI()));
        options.add(new MenuItem("List all deals made", new ListDealsGUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nNetwork Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
