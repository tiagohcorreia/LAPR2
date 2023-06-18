package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository {
    private List<Schedule> scheduleList = new ArrayList<>();

    public boolean saveSchedule(Schedule schedule) {
        if (validateSchedule(schedule)) {
            return addSchedule(schedule);
        }
        return false;
    }

    public boolean validateSchedule(Schedule schedule) {
        for (Schedule schedule1 : scheduleList) {
            if (schedule.equals(schedule1)) {
                return false;
            }
        }
        return true;
    }

    public boolean addSchedule(Schedule schedule) {
        if (schedule != null && validateSchedule(schedule)) {
            return scheduleList.add(schedule);
        }
        return false;
    }

    public List<Schedule> getScheduleList() {
        return new ArrayList<>(scheduleList);
    }

    public String getScheduleListAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Schedule schedule : scheduleList) {
            stringBuilder.append("-").append(schedule.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Schedule> readObjectScheduleRequest() {
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

    public void writeObjectScheduleRequest() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/schedulesRequests.ser"));
            oos.writeObject(scheduleList);
            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<Schedule> getRequestScheduleListByResponsibleAgent(Employee agent) {
        List<Schedule> schedulesByResposibleAgent = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getAnnouncementDTO().getAgent().equals(agent) && !schedule.getStatus()) {
                schedulesByResposibleAgent.add(schedule);
            }
        }
        return schedulesByResposibleAgent;
    }

    public boolean addConfirmedSchedule(Schedule schedule) {
        for (Schedule schedule1 : scheduleList) {
            if (schedule1.equals(schedule)) {
                schedule1.setStatus(true);
                schedule1.setAproved(true);
                return true;
            }
        }
        return false;
    }

    public boolean addRejectedSchedule(Schedule schedule) {
        for (Schedule schedule1 : scheduleList) {
            if (schedule1.equals(schedule)) {
                schedule1.setStatus(true);
                schedule1.setAproved(false);
                return true;
            }
        }
        return false;
    }
}