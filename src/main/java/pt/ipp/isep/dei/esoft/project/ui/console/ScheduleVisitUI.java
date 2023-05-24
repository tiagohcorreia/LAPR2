package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.PlaceOrderToBuyPropertyController;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

public class ScheduleVisitUI implements Runnable{
    private ScheduleVisitController controller= new ScheduleVisitController(new ScheduleRepository());
    public ScheduleVisitUI(ScheduleVisitController controller) {
        this.controller = controller;
    }
    @Override
    public void run() {
        boolean success= true;
        while (success==true){

        }
    }
}
