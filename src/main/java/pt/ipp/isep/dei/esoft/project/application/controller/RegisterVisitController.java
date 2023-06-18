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


 /**
  * The type Register visit controller.
  */
 public class RegisterVisitController {

    private  ScheduleRepository scheduleRepository = Repositories.getInstance().getScheduleRepository();
    private  VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();
    private  EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authRepository = Repositories.getInstance().getAuthenticationRepository();

     /**
      * Instantiates a new Register visit controller.
      */
     public RegisterVisitController() {
        this.scheduleRepository = scheduleRepository;
        this.visitRepository = visitRepository;
    }

     /**
      * Gets schedule for agent.
      *
      * @param agentName the agent name
      * @return the schedule for agent
      */
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

     /**
      * Register visit.
      *
      * @param scheduledVisit       the scheduled visit
      * @param opinionAboutBusiness the opinion about business
      * @param rating               the rating
      */
     public void registerVisit(Schedule scheduledVisit, String opinionAboutBusiness, Rating rating) {
        Visit visit = new Visit(scheduledVisit, opinionAboutBusiness, rating);
        visitRepository.addVisit(visit);
    }

   /* public String getCurrentAgentName() {
        return authRepository.getCurrentUserSession().getUserName();

    } */

     /**
      * Gets current agent.
      *
      * @return the current agent
      */
     public String getCurrentAgent() {
         pt.isep.lei.esoft.auth.UserSession userSession = authRepository.getCurrentUserSession();
         if (userSession.getUserRoles() == Role.AGENT) {
             return userSession.getUserName();
         } else {
             throw new IllegalStateException("Current user is not an employee (agent).");
         }
     }

     /**
      * Gets employee by name.
      *
      * @param employeeName the employee name
      * @return the employee by name
      */
     public Employee getEmployeeByName(String employeeName) {
         return employeeRepository.findByEmail(employeeName);
     }



}
