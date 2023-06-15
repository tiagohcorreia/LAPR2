package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule {
    private String name;
    private int phoneNumber;
    private AnnouncementDTO announcementDTO;
    private LocalDate day;
    private LocalTime beginHour;
    private LocalTime endHour;

    private String noteFromAgent;
    private boolean status; //the schedule is visible
    private boolean agentAproved;
    private boolean clientApproval;
    private String noteFromClient;

    public Schedule(String name, int phoneNumber, AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginHour, LocalTime endHour, String note, boolean status, boolean aproved) {
        this.name = setName(name);
        this.phoneNumber = setPhoneNumber(phoneNumber);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
        this.day = setDay(day);
        this.beginHour = setBeginHour(beginHour);
        this.endHour = setEndHour(endHour);
        this.noteFromAgent = setNote(note);
        this.status = setStatus(status);
        this.agentAproved = setAproved(aproved);

    }

    public Schedule(String name, int phoneNumber, AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginHour, LocalTime endHour, String noteFromAgent, boolean status, boolean agentAproved, boolean clientApproval, String noteFromClient) {
        this.name = setName(name);
        this.phoneNumber = setPhoneNumber(phoneNumber);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
        this.day = setDay(day);
        this.beginHour = setBeginHour(beginHour);
        this.endHour = setEndHour(endHour);
        this.noteFromAgent = setNote(noteFromAgent);
        this.status = setStatus(status);
        this.agentAproved = setAproved(agentAproved);
        this.clientApproval = false;
        this.noteFromClient = "";
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getBeginHour() {
        return beginHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public String getNoteFromAgent() {
        return noteFromAgent;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean getAgentAproved() {
        return agentAproved;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isAgentAproved() {
        return agentAproved;
    }

    public boolean isClientApproval() {
        return clientApproval;
    }

    public String getNoteFromClient() {
        return noteFromClient;
    }

    public String setName(String name) {
        if (name == null) {

            throw new NullPointerException("Your name can't be null, please insert again.");

        } else if (name.trim().isEmpty()) {

            throw new IllegalArgumentException("Your name must be filled.");

        }
        return this.name = name;
    }

    public Integer setPhoneNumber(int phoneNumber) {
        if (phoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (Integer.toString(phoneNumber).trim().length() != 10) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");
        }
        return this.phoneNumber = phoneNumber;
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    public LocalDate setDay(LocalDate day) {
        if (day.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You can’t schedule a visit for a day in the past.");
        }
        return this.day = day;
    }

    public LocalTime setBeginHour(LocalTime beginHour) {
        return this.beginHour = beginHour;
    }

    public LocalTime setEndHour(LocalTime endHour) {
        if (endHour.isBefore(beginHour)) {
            throw new IllegalArgumentException("The time the visit ends must be after the time the visit begins.");
        }
        return this.endHour = endHour;
    }

    public String setNote(String note) {
        return this.noteFromAgent = note;
    }

    public boolean setStatus(boolean status) {
        return this.status = status;
    }

    public boolean setAproved(boolean aproved) {
        return this.agentAproved = aproved;
    }

    public void setNoteFromAgent(String noteFromAgent) {
        this.noteFromAgent = noteFromAgent;
    }

    public void setAgentAproved(boolean agentAproved) {
        this.agentAproved = agentAproved;
    }

    public void setClientApproval(boolean clientApproval) {
        this.clientApproval = clientApproval;
    }

    public void setNoteFromClient(String noteFromClient) {
        this.noteFromClient = noteFromClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return phoneNumber == schedule.phoneNumber && status == schedule.status && agentAproved == schedule.agentAproved && clientApproval == schedule.clientApproval && Objects.equals(name, schedule.name) && Objects.equals(announcementDTO, schedule.announcementDTO) && Objects.equals(day, schedule.day) && Objects.equals(beginHour, schedule.beginHour) && Objects.equals(endHour, schedule.endHour) && Objects.equals(noteFromAgent, schedule.noteFromAgent) && Objects.equals(noteFromClient, schedule.noteFromClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, announcementDTO, day, beginHour, endHour, noteFromAgent, status, agentAproved, clientApproval, noteFromClient);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schedule{");
        sb.append("name='").append(name).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", announcementDTO=").append(announcementDTO);
        sb.append(", day=").append(day);
        sb.append(", beginHour=").append(beginHour);
        sb.append(", endHour=").append(endHour);
        sb.append(", noteFromAgent='").append(noteFromAgent).append('\'');
        sb.append(", status=").append(status);
        sb.append(", agentAproved=").append(agentAproved);
        sb.append(", clientApproval=").append(clientApproval);
        sb.append(", noteFromClient='").append(noteFromClient).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /*@Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", phoneNumber= " + phoneNumber +
                ", announcementDTO= " + announcementDTO +
                ", day= " + day +
                ", beginHour= " + beginHour +
                ", endHour= " + endHour +
                ", note= " + noteFromAgent +
                '}';
    }*/



}
