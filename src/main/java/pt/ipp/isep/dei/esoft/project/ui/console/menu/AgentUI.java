
package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterPropertyController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.PublishAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterPropertyUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgentUI implements Runnable{

    private Scanner scanner;

    public AgentUI() {



    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        System.out.println("Welcome, Agent!\n Select an option:");
        options.add(new MenuItem("Publish announcement",  new PublishAnnouncementUI(new PublishAnnouncementController(new AnnouncementRepository(), new AuthenticationController()),new AuthenticationController())));
        options.add(new MenuItem("Exit", (Runnable) new MainMenuUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, ":");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

