package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AnnouncementRequestsController;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ScheduleVisitUI implements Runnable {

    private final ScheduleVisitController controller;
    public ScheduleVisitUI() {
        this.controller = new ScheduleVisitController();
    }




    @Override
    public void run() {
        boolean success = true;
        while (success == true) {

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.getAnnouncementsList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property")-1;
            AnnouncementDTO announcement = controller.getAnnouncementByPos(posAnouncement);

            //Day
            String stringDay = Utils.readLineFromConsole("Insert the day you want to schedule: (yyyy-mm-dd)");
            LocalDate day = LocalDate.parse(stringDay);


            //Begin Hour
            System.out.println("Insert the time you want to start the visit");
            int beginHour = Utils.readIntegerFromConsole("Hour :");
            int begunMin = Utils.readIntegerFromConsole("Minute:");
            int beginSec = Utils.readIntegerFromConsole("Second :");
            LocalTime beginTime = LocalTime.of(beginHour, begunMin, beginSec);

            //End Hour
            System.out.println("Insert the time you want to end the visit");
            int endHour = Utils.readIntegerFromConsole("Hour :");
            int endMin = Utils.readIntegerFromConsole("Minute :");
            int endSec = Utils.readIntegerFromConsole("Second:");
            LocalTime endTime = LocalTime.of(endHour, endMin, endSec);

            //Extra note
            String note = Utils.readLineFromConsole("Insert a note for the agent:");

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {
                    if (controller.validateScheduleHour(announcement, day, beginTime, endTime) == true) {
                        this.controller.createSchedule(announcement, day, beginTime, endTime, note);
                        System.out.println("Announcement:\n" + announcement);
                        System.out.println("Day: " + day);
                        System.out.println("Begin Time: " + beginTime);
                        System.out.println("End Hour: " + endTime);
                        System.out.println("Note: " + note);
                        System.out.println();
                        System.out.println("Schedule message confirmed");
                        success = false;

                    } else {
                        System.out.println("Please insert Schedule data again");
                    }


                } catch (IllegalArgumentException e) {

                    System.err.println(e.getMessage());

                } catch (NullPointerException e) {

                    System.err.println(e.getMessage());

                } catch (DateTimeParseException e) {

                    e.getStackTrace();

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

            } else {

                System.err.println("Operation Canceled");
            }

        }
    }
}
