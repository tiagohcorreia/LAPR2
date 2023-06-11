package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
public class ScheduleVisitController {

    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    private AnnouncementMapper announcementMapper;

    public ScheduleVisitController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.readObject();

        return AnnouncementMapper.convert(announcements);
    }

    public String createSchedule(String name, int phoneNumber, Integer posAnnouncement, LocalDate day, LocalTime beginHour, LocalTime endHour, String note) {
        Schedule schedule = new Schedule(name,phoneNumber, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement),day,beginHour,endHour,note,false,false);

        try {

            this.scheduleRepository.saveSchedule(schedule);
            this.scheduleRepository.writeObjectScheduleRequest();
            return schedule.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }

    public boolean validateScheduleHour(AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginTime, LocalTime endTime) {
        boolean isOverlap = false;
        for(Schedule schedule : scheduleRepository.getScheduleList()) {

            if (beginTime.isBefore(schedule.getEndHour()) && endTime.isAfter(schedule.getBeginHour())) {
                isOverlap = true;
                throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");

            } else if (beginTime.equals(schedule.getBeginHour()) || endTime.equals(schedule.getEndHour())) {
                isOverlap = true;

                throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");
            }

            if (schedule.getAnnouncementDTO().equals(announcementDTO) && schedule.getDay().equals(day) && isOverlap==false) {
                return true;
            }
        }
        return true;
    }

    public AnnouncementDTO getAnnouncementDTO(int posAnnouncement) {
        return AnnouncementMapper.getAnnouncementDTOById(posAnnouncement);
    }


}
