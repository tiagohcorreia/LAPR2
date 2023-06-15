package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScheduleVisitControllerTest {
    static ScheduleRepository scheduleRepository;
    ScheduleVisitController scheduleVisitController;
    AnnouncementDTO announcementDTO;
    LocalDate day;
    LocalTime beginHour;
    LocalTime endHour;

    LocalDate day2;
    LocalTime beginHour2;
    LocalTime endHour2;
    Schedule scheduleNotOverlap;
    @BeforeAll
    static void setup() {
        scheduleRepository = Repositories.getInstance().getScheduleRepository();
    }

    @BeforeEach
    void init() {
        scheduleVisitController = new ScheduleVisitController(scheduleRepository);

        Branch branch = new Branch();
        ArrayList<String> photographs = new ArrayList<String>();
        photographs.add("photo1");
        City city = new City("Porto");
        day = LocalDate.of(2024, 06, 20);
        beginHour = LocalTime.of(12, 30, 0);
        endHour = LocalTime.of(13, 30, 0);
        day2 = LocalDate.of(2024, 06, 20);
        beginHour2 = LocalTime.of(14, 30, 0);
        endHour2 = LocalTime.of(15, 30, 0);
        Property property = new Land(123, new Location(), 123, photographs);
        Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e1, owner);

        announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e1);
        scheduleRepository.addSchedule(new Schedule("vitor", 1234567891, announcementDTO, day, beginHour, endHour, "no more notes", false, false));
        scheduleNotOverlap= new Schedule("vitor2",1234567891, announcementDTO, day2, beginHour2, endHour2, "no more notes", false, false);
    }

    @DisplayName("Ensure the schedule time overlap fails")
    @Test
    void validateScheduleHourOverlap() {
        assertThrows(IllegalArgumentException.class, () -> {
            scheduleVisitController.validateScheduleHour(announcementDTO, day, beginHour, endHour);
        });
    }

    @DisplayName("Ensure the schedule time not overlap")
    @Test
    void validateScheduleHourNotOverlap() {
        boolean expected= true;
        boolean actual=scheduleVisitController.validateScheduleHour(announcementDTO, day2, beginHour2, endHour2);
        assertEquals(expected,actual);

    }
}
