
package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterPropertyController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.PublishAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.PurchaseOrderUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterPropertyUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Agent ui.
 */
public class AgentUI implements Runnable{

    private Scanner scanner;

    /**
     * Instantiates a new Agent ui.
     */
    public AgentUI() {



    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        System.out.println("=============== Real Estate USA ===============\n ");
        options.add(new MenuItem("Publish announcement",  new PublishAnnouncementUI()));
        options.add(new MenuItem("List and manage purchase orders", new PurchaseOrderUI())); // nova opção no menu
        options.add(new MenuItem("Exit", (Runnable) new MainMenuUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n                     Menu\n");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

