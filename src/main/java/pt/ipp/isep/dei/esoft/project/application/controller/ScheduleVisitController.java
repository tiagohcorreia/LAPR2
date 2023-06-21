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
public class  ScheduleVisitController {

    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    private ClientRepository clientRepository= repositories.getClientRepository();
    AuthenticationController authenticationController;
    private AnnouncementMapper announcementMapper;

    public ScheduleVisitController() {
        this.scheduleRepository = scheduleRepository;
        this.announcementMapper = new AnnouncementMapper();
        authenticationController = new AuthenticationController();
    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.readObject();

        return AnnouncementMapper.convert(announcements);
    }

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

    public AnnouncementDTO getAnnouncementByPos(int posAnnouncement) {
        List<AnnouncementDTO> announcements= getAnnouncementsList();
        return announcements.get(posAnnouncement);
    }

    public List<AnnouncementDTO> getAnnouncementsList() {
        List<AnnouncementDTO> dtoList = new ArrayList<>();
        for (Announcement announcement : this.announcementRepository.readObject()) {
            AnnouncementDTO dto = this.announcementMapper.toDto2(announcement);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
