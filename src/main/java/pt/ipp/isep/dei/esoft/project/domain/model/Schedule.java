package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * The type Schedule.
 */
public class Schedule implements Serializable {
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

    /**
     * Instantiates a new Schedule.
     *
     * @param name            the name
     * @param phoneNumber     the phone number
     * @param announcementDTO the announcement dto
     * @param day             the day
     * @param beginHour       the begin hour
     * @param endHour         the end hour
     * @param note            the note
     * @param status          the status
     * @param aproved         the aproved
     */
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

    /**
     * Instantiates a new Schedule.
     *
     * @param name            the name
     * @param phoneNumber     the phone number
     * @param announcementDTO the announcement dto
     * @param day             the day
     * @param beginHour       the begin hour
     * @param endHour         the end hour
     * @param noteFromAgent   the note from agent
     * @param status          the status
     * @param agentAproved    the agent aproved
     * @param clientApproval  the client approval
     * @param noteFromClient  the note from client
     */
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

    /**
     * Instantiates a new Schedule.
     */
    public Schedule() {

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets announcement dto.
     *
     * @return the announcement dto
     */
    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public LocalDate getDay() {
        return day;
    }

    /**
     * Gets begin hour.
     *
     * @return the begin hour
     */
    public LocalTime getBeginHour() {
        return beginHour;
    }

    /**
     * Gets end hour.
     *
     * @return the end hour
     */
    public LocalTime getEndHour() {
        return endHour;
    }

    /**
     * Gets note from agent.
     *
     * @return the note from agent
     */
    public String getNoteFromAgent() {
        return noteFromAgent;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Gets agent aproved.
     *
     * @return the agent aproved
     */
    public boolean getAgentAproved() {
        return agentAproved;
    }

    /**
     * Is status boolean.
     *
     * @return the boolean
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Is agent aproved boolean.
     *
     * @return the boolean
     */
    public boolean isAgentAproved() {
        return agentAproved;
    }

    /**
     * Is client approval boolean.
     *
     * @return the boolean
     */
    public boolean isClientApproval() {
        return clientApproval;
    }

    /**
     * Gets note from client.
     *
     * @return the note from client
     */
    public String getNoteFromClient() {
        return noteFromClient;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public String setName(String name) {
        if (name == null) {

            throw new NullPointerException("Your name can't be null, please insert again.");

        } else if (name.trim().isEmpty()) {

            throw new IllegalArgumentException("Your name must be filled.");

        }
        return this.name = name;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     * @return the phone number
     */
    public Integer setPhoneNumber(int phoneNumber) {
        if (phoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (Integer.toString(phoneNumber).trim().length() != 10) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");
        }
        return this.phoneNumber = phoneNumber;
    }

    /**
     * Sets announcement dto.
     *
     * @param announcementDTO the announcement dto
     * @return the announcement dto
     */
    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    /**
     * Sets day.
     *
     * @param day the day
     * @return the day
     */
    public LocalDate setDay(LocalDate day) {
        if (day.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You can’t schedule a visit for a day in the past.");
        }
        return this.day = day;
    }

    /**
     * Sets begin hour.
     *
     * @param beginHour the begin hour
     * @return the begin hour
     */
    public LocalTime setBeginHour(LocalTime beginHour) {
        return this.beginHour = beginHour;
    }

    /**
     * Sets end hour.
     *
     * @param endHour the end hour
     * @return the end hour
     */
    public LocalTime setEndHour(LocalTime endHour) {
        if (endHour.isBefore(beginHour)) {
            throw new IllegalArgumentException("The time the visit ends must be after the time the visit begins.");
        }
        return this.endHour = endHour;
    }

    /**
     * Sets note.
     *
     * @param note the note
     * @return the note
     */
    public String setNote(String note) {
        return this.noteFromAgent = note;
    }

    /**
     * Sets status.
     *
     * @param status the status
     * @return the status
     */
    public boolean setStatus(boolean status) {
        return this.status = status;
    }

    /**
     * Sets aproved.
     *
     * @param aproved the aproved
     * @return the aproved
     */
    public boolean setAproved(boolean aproved) {
        return this.agentAproved = aproved;
    }

    /**
     * Sets note from agent.
     *
     * @param noteFromAgent the note from agent
     */
    public void setNoteFromAgent(String noteFromAgent) {
        this.noteFromAgent = noteFromAgent;
    }

    /**
     * Sets agent aproved.
     *
     * @param agentAproved the agent aproved
     */
    public void setAgentAproved(boolean agentAproved) {
        this.agentAproved = agentAproved;
    }

    /**
     * Sets client approval.
     *
     * @param clientApproval the client approval
     */
    public void setClientApproval(boolean clientApproval) {
        this.clientApproval = clientApproval;
    }

    /**
     * Sets note from client.
     *
     * @param noteFromClient the note from client
     */
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
