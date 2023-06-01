package pt.ipp.isep.dei.esoft.project.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    Schedule schedule;
    Property property;
    Announcement announcement;
    AnnouncementDTO announcementDTO;

    City city;

    @BeforeEach
    void setup(){
        ArrayList<String> photographs = new ArrayList<String>();
        photographs.add("photo1");
        city=new City("Porto");
        LocalDate day = LocalDate.of(2023, 06, 20);
        LocalTime beginHour = LocalTime.of(12,30,0);
        LocalTime endHour = LocalTime.of(13,30,0);
        property= new Land(123,new Location(),123,photographs);
        pt.ipp.isep.dei.esoft.project.domain.model.Employee e1 = new pt.ipp.isep.dei.esoft.project.domain.model.Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
        announcement= new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED,1231,121,TypeOfBusiness.SELL,property,e1);
        announcementDTO = new AnnouncementDTO(123,TypeOfBusiness.SELL,property,e1);
        schedule= new Schedule("vitor",1234567891,announcementDTO,day,beginHour,endHour,"no more notes",false, false);
    }
    @Test
    @DisplayName("Ensure that a schedule without a name fails")
    void EnsureEmptyNameFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setName("");
        });
    }
    @DisplayName("Ensure Null Name Fails")
    @Test
    void EnsureNullNameFails() {

        assertThrows(NullPointerException.class, () -> {
            schedule.setName(null);
        });
    }

    @DisplayName("Ensure Negative Phone Number Fails")
    @Test
    void EnsureNegativePhoneNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setPhoneNumber(-12345678);
        });
    }
    @DisplayName("Ensure Telephone Number with 9 digits fails")
    @Test
    void EnsureTelephoneNumberWith9DigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setPhoneNumber(111111111);

        });
    }

    @DisplayName("Ensure endHour before beginHour fails")
    @Test
    void EnsurEndHourBeforeBeginHourFails() {

        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setEndHour(LocalTime.of(10,30,0));
        });
    }

}