package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterPropertyController;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.ReadResponseOfAppointmentRequestGUI;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable {

    public ClientUI() {

    }

    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Display listed properties", new DisplayAnnouncementsUI()));
        options.add(new MenuItem("Place an order to purchase the property", new PlaceOrderToBuyPropertyUI()));
        options.add(new MenuItem("Schedule a visit to your future property", new ScheduleVisitUI()));
        options.add(new MenuItem("Read Response of an appointment request", new ReadResponseOfAppointmentRequestGUI()));
        options.add(new MenuItem("Listing a Property", new RegisterPropertyUI(new RegisterPropertyController(new AnnouncementRepository()))));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
