package pt.ipp.isep.dei.esoft.project.domain.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.application.controller.ValidateScheduleController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleRepositoryTest {
    static ScheduleRepository scheduleRepository;
    private AuthenticationRepository authenticationRepository;
    ScheduleVisitController scheduleVisitController;
    ValidateScheduleController validateScheduleController;
    private EmployeeRepository employeeRepository;
    AnnouncementDTO announcementDTO;
    AnnouncementDTO announcementDTO2;
    LocalDate day;
    LocalTime beginHour;
    LocalTime endHour;

    LocalDate day2;
    LocalTime beginHour2;
    LocalTime endHour2;
    LocalTime beginHour3;
    LocalTime endHour3;
    AuthFacade authenticationFacade= new AuthFacade();;
    Schedule scheduleToAdd;
    Employee e1;
    Employee e2;
    Schedule schedule1;
    Schedule schedule2;
    Schedule schedule3;
    @BeforeAll
    static void setup() {
        scheduleRepository = Repositories.getInstance().getScheduleRepository();

    }

    @BeforeEach
    void init() {
        employeeRepository = Repositories.getInstance().getEmployeeRepository();
        scheduleVisitController = new ScheduleVisitController();
        validateScheduleController = new ValidateScheduleController();
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
        beginHour3 = LocalTime.of(16, 30, 0);
        endHour3 = LocalTime.of(17, 30, 0);
        Property property = new Land(123, new Location(), 123, photographs);
        e1 = new Employee("vitor", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);
        e2 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e2@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);

        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e1, owner);
        Announcement announcement2 = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e2, owner);

        announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e1);
        announcementDTO2 = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e2);
        schedule1 = new Schedule("vitor", 1234567891, announcementDTO, day, beginHour, endHour, "no more notes", false, false);
        schedule2 = new Schedule("vitor2", 1224567891, announcementDTO2, day, beginHour, endHour, "no more notes2", false, false);
    }

    @Test
    void getRequestScheduleListByResponsibleAgent() {
        scheduleRepository.addSchedule(schedule1);
        scheduleRepository.addSchedule(schedule2);
        List<Schedule> expected= new ArrayList<>();
        expected.add(schedule1);
        List<Schedule> result= scheduleRepository.getRequestScheduleListByResponsibleAgent(e1);

        assertEquals(expected, result);


    }
}