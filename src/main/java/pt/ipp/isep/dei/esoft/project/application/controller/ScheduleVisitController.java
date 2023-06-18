package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Schedule visit controller.
 */
public class ScheduleVisitController {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    private ClientRepository clientRepository= repositories.getClientRepository();
    /**
     * The Authentication controller.
     */
    AuthenticationController authenticationController;
    private AnnouncementMapper announcementMapper;

    /**
     * Instantiates a new Schedule visit controller.
     */
    public ScheduleVisitController() {
        this.scheduleRepository = scheduleRepository;
        this.announcementMapper = new AnnouncementMapper();
        authenticationController = new AuthenticationController();
    }

    /**
     * Announcement dto list list.
     *
     * @return the list
     */
    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.readObject();

        return AnnouncementMapper.convert(announcements);
    }

    /**
     * Create schedule string.
     *
     * @param announcement the announcement
     * @param day          the day
     * @param beginHour    the begin hour
     * @param endHour      the end hour
     * @param note         the note
     * @return the string
     */
    public String createSchedule(AnnouncementDTO announcement, LocalDate day, LocalTime beginHour, LocalTime endHour, String note) {
        pt.ipp.isep.dei.esoft.project.application.session.UserSession userSession = authenticationController.getCurrentSession();
        String clientEmail= userSession.getUserEmail();
        Client client= clientRepository.findByEmail(clientEmail);
        String name= client.getName();
        long phoneNumber= client.getTelephoneNumber();
        Schedule schedule = new Schedule(name, (int) phoneNumber, announcement,day,beginHour,endHour,note,false,false);

        try {

            this.scheduleRepository.saveSchedule(schedule);
            this.scheduleRepository.writeObjectScheduleRequest();
            return schedule.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }

    /**
     * Validate schedule hour boolean.
     *
     * @param announcementDTO the announcement dto
     * @param day             the day
     * @param beginTime       the begin time
     * @param endTime         the end time
     * @return the boolean
     */
    public boolean validateScheduleHour(AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginTime, LocalTime endTime) {
        boolean isOverlap = false;
        for(Schedule schedule : scheduleRepository.getScheduleList()) {
            if (schedule.getAnnouncementDTO().equals(announcementDTO) && schedule.getDay().equals(day)){
                if (beginTime.isBefore(schedule.getEndHour()) && endTime.isAfter(schedule.getBeginHour())) {
                    isOverlap = true;
                    throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");

                } else if (beginTime.equals(schedule.getBeginHour()) || endTime.equals(schedule.getEndHour())) {
                    isOverlap = true;

                    throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");
                }else return true;
            }

        }
        return true;
    }

    /**
     * Gets announcement by pos.
     *
     * @param posAnnouncement the pos announcement
     * @return the announcement by pos
     */
    public AnnouncementDTO getAnnouncementByPos(int posAnnouncement) {
        List<AnnouncementDTO> announcements= getAnnouncementsList();
        return announcements.get(posAnnouncement);
    }

    /**
     * Gets announcements list.
     *
     * @return the announcements list
     */
    public List<AnnouncementDTO> getAnnouncementsList() {
        List<AnnouncementDTO> dtoList = new ArrayList<>();
        for (Announcement announcement : this.announcementRepository.readObject()) {
            AnnouncementDTO dto = this.announcementMapper.toDto2(announcement);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
