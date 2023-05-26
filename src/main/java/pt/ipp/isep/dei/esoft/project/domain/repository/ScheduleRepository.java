package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository {
    public static List<Schedule> scheduleList = new ArrayList<>();
    public boolean saveSchedule(Schedule schedule){
        if(validateSchedule(schedule)) {
            return addSchedule(schedule);
        }
        return false;
    }
    public boolean validateSchedule(Schedule schedule){
        for(Schedule schedule1: scheduleList) {

            if(schedule.equals(schedule)) {
                return false;
            }
        }
        return true;
    }

    public boolean addSchedule(Schedule schedule){
        if(schedule != null && validateSchedule(schedule)) {

            return this.scheduleList.add(schedule);
        }
        return false;
    }

    public List<Schedule> getScheduleList() {

        return new ArrayList<>(scheduleList);
    }

    public String getScheduleListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Schedule schedule: this.scheduleList) {

            stringBuilder.append("-").append(schedule.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
