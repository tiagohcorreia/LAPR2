 package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.model.Visit;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;


 public class RegisterVisitController {

    private  ScheduleRepository scheduleRepository = Repositories.getInstance().getScheduleRepository();
    private  VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();
    private  EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authRepository = Repositories.getInstance().getAuthenticationRepository();

    public RegisterVisitController() {
        this.scheduleRepository = scheduleRepository;
        this.visitRepository = visitRepository;
    }

    public List<Schedule> getScheduleForAgent( Employee agentName) {
        List<Schedule> scheduleList = scheduleRepository.getRequestScheduleListByResponsibleAgent(agentName);
        List<Schedule> filteredVisits = new ArrayList<>();

        for (Schedule scheduled : scheduleList) {
            AnnouncementDTO announcementDTO = scheduled.getAnnouncementDTO();
            String visitAgentName = announcementDTO.getAgent().getName();

            if (visitAgentName.equals(agentName)) {
                filteredVisits.add(scheduled);
            }
        }

        return filteredVisits;
    }

    public void registerVisit(Schedule scheduledVisit, String opinionAboutBusiness, Rating rating) {
        Visit visit = new Visit(scheduledVisit, opinionAboutBusiness, rating);
        visitRepository.addVisit(visit);
    }

   /* public String getCurrentAgentName() {
        return authRepository.getCurrentUserSession().getUserName();

    } */

     public String getCurrentAgent() {
         pt.isep.lei.esoft.auth.UserSession userSession = authRepository.getCurrentUserSession();
         if (userSession.getUserRoles() == Role.AGENT) {
             return userSession.getUserName();
         } else {
             throw new IllegalStateException("Current user is not an employee (agent).");
         }
     }

     public Employee getEmployeeByName(String employeeName) {
         return employeeRepository.findByEmail(employeeName);
     }



}
