package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleVisitController {

    private ScheduleRepository scheduleRepository;
    private AnnouncementRepository announcementRepository = new AnnouncementRepository();
    private AnnouncementMapper announcementMapper;

    public ScheduleVisitController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.getAllVisibleAnnouncements();

        return AnnouncementMapper.convert(announcements);
    }

    public String createSchedule(String name, int phoneNumber, Integer posAnnouncement, LocalDate day, LocalTime beginHour, LocalTime endHour, String note) {
        Schedule schedule = new Schedule(name,phoneNumber, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement),day,beginHour,endHour,note,false);

        try {

            this.scheduleRepository.saveSchedule(schedule);
            return schedule.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }
}
