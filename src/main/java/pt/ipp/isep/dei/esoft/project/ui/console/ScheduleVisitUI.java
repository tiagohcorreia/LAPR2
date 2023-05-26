package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleVisitUI implements Runnable{
    private ScheduleVisitController controller= new ScheduleVisitController(new ScheduleRepository());
    @Override
    public void run() {
        boolean success= true;
        while (success==true){

            //name
            String name= Utils.readLineFromConsole("Insert your name:");

            //phoneNumber
            int phoneNumber=Utils.readIntegerFromConsole("Insert your phone number:");

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.announcementDTOList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property");


            //Day
            //LocalDate day = "2023-07-2";

            //Begin Hour
            //LocalTime beginHour = Utils.readIntegerFromConsole("Insert the begin hour of the visit(24h format): ");

            String note= Utils.readLineFromConsole("Insert a note for agent:");

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    //this.controller.createSchedule(name,phoneNumber, posAnouncement,day,beginHour,endHour, note);
                    success = false;

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                System.out.println("Name: " + name);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Announcement Number:\n" + posAnouncement);
                //System.out.println("Day: " + day);
                //System.out.println("Begin Hour: " + beginHour+"h");
                //System.out.println("End Hour: " + beginHour+1+"h");
                System.out.println("End Hour: " + note);
            } else {

                System.err.println("Operation Canceled");
            }

        }
    }
}
