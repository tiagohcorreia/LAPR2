package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository {
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<Schedule> confirmedScheduleList = new ArrayList<>();
    public static List<Schedule> schedulesByResposibleAgent= new ArrayList<>();
    public boolean saveSchedule(Schedule schedule){
        if(validateSchedule(schedule)) {
            return addSchedule(schedule);
        }
        return false;
    }
    public boolean validateSchedule(Schedule schedule){
        for(Schedule schedule1: scheduleList) {

            if(schedule.equals(schedule1)) {
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
    public List<Schedule> readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/schedulesRequests.ser"));
            scheduleList = (List<Schedule>) ois.readObject();
            System.out.println(scheduleList);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return scheduleList;
    }

    /**
     * Write object.
     */
    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/schedulesRequests.ser"));
            oos.writeObject(scheduleList);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

    public List<Schedule> getRequestScheduleListByResponsibleAgent(Employee agent){

        for (Schedule schedule:this.scheduleList){
            if (schedule.getAnnouncementDTO().getAgent().equals(agent)){
                schedulesByResposibleAgent.add(schedule);
            }
        }
        return schedulesByResposibleAgent;
    }

    public boolean addConfirmedSchedule(Schedule schedule){
        this.confirmedScheduleList.add(schedule);
        removeScheduleFromRequests(schedule);
        return true;
    }
    public boolean removeScheduleFromRequests(Schedule schedule){
        for(Schedule schedule1: scheduleList) {
            if(schedule.equals(schedule1)) {
                return this.confirmedScheduleList.remove(schedule);
            }
        }
        return false;
    }
}
