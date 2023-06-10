package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.util.List;

public class ValidateScheduleController {

    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();

    public ValidateScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
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
