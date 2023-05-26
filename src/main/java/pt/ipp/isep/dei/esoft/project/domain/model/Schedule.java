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

    private String note;
    private boolean status; //the schedule needs to be confirmed (true)

    public Schedule(String name, int phoneNumber, AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginHour,LocalTime endHour, String note, boolean status) {
        this.name = setName(name);
        this.phoneNumber = setPhoneNumber(phoneNumber);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
        this.day = setDay(day);
        this.beginHour = setBeginHour(beginHour);
        this.endHour = setEndHour(endHour);
        this.note=setNote(note);
        this.status=setStatus(status);
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

    public String getNote() {
        return note;
    }
    public boolean getStatus(){
        return status;
    }

    public String setName(String name) {
        return this.name = name;
    }
    public Integer setPhoneNumber(int phoneNumber) {
        return this.phoneNumber = phoneNumber;
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    public LocalDate setDay(LocalDate day) {
        return this.day = day;
    }

    public LocalTime setBeginHour(LocalTime beginHour) {
        return this.beginHour = beginHour;
    }
    public LocalTime setEndHour(LocalTime endHour) {
        return this.endHour = endHour;
    }

    public String setNote(String note) {
        return this.note = note;
    }

    public boolean setStatus(boolean status) {
        return this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return phoneNumber == schedule.phoneNumber && day == schedule.day && note == schedule.note && beginHour == schedule.beginHour && endHour == schedule.endHour && Objects.equals(name, schedule.name) && Objects.equals(announcementDTO, schedule.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, announcementDTO, day, beginHour,endHour, note);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", phoneNumber= " + phoneNumber +
                ", announcementDTO= " + announcementDTO +
                ", day= " + day +
                ", beginHour= " + beginHour +
                ", endHour= " + endHour +
                ", note= " + note +
                '}';
    }
}
