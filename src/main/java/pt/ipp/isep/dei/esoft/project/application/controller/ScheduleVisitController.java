package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;

import static pt.ipp.isep.dei.esoft.project.domain.shared.PasswordGenerator.generatePassword;

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


    public List<Schedule> getRequestScheduleListByResponsibleAgent(){
        String agentName=String.valueOf(authenticationRepository.getCurrentUserSession().getUserName());
        pt.ipp.isep.dei.esoft.project.domain.model.Employee agent= employeeRepository.findByName(agentName);
        return scheduleRepository.getRequestScheduleListByResponsibleAgent(agent);
    }
    public boolean addConfirmedSchedule(int schedulePos){
        if (schedulePos>=0 && schedulePos< scheduleRepository.schedulesByResposibleAgent.size()){
            Schedule schedule= scheduleRepository.schedulesByResposibleAgent.get(schedulePos);
            scheduleRepository.writeObjectScheduleRequest();
            return scheduleRepository.addConfirmedSchedule(schedule);
        }else {
            return false;
        }
    }
    public boolean addRejectedSchedule(int schedulePos){
        if (schedulePos>=0 && schedulePos< scheduleRepository.schedulesByResposibleAgent.size()){
            Schedule schedule= scheduleRepository.schedulesByResposibleAgent.get(schedulePos);
            scheduleRepository.writeObjectScheduleRequest();
            return scheduleRepository.addRejectedSchedule(schedule);
        }else {
            return false;
        }
    }


}
