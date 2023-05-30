package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;


public class AnnouncementRequestsController {
    private AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    private EmployeeRepository employeeRepository=Repositories.getInstance().getEmployeeRepository();;

    private AuthenticationController authenticationController;


    public Employee getEmployee(String name) {
        for (Employee employee : employeeRepository.getEmployeeList()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee; // Retorna o funcionário correspondente ao nome fornecido
            }
        }
        return null; // Nenhum funcionário corresponde ao nome fornecido
    }

    // ...

    public boolean isEmployee(String agentName) {
        Employee agent = getEmployee(agentName); // Obtenha o objeto Employee correspondente ao nome
        return agent != null; // Verifica se o objeto Employee foi encontrado
    }


    public List<Announcement> getAnnouncementRequests(Employee agent) {
        List<Announcement> requestsForAgent = new ArrayList<>();
        for (Announcement announcement : this.announcementRepository.getAllAnnouncements()) {
            if (announcement.getStatus() == AnnouncementStatus.REQUESTED && announcement.getAgent().equals(agent)) {
                requestsForAgent.add(announcement);
            }
        }

        Collections.sort(requestsForAgent, Comparator.comparing(Announcement::getDate).reversed());

        return requestsForAgent;
    }
    public Announcement getAnnouncementByIndex(int index, Employee agent) {
        List<Announcement> announcements = getAnnouncementRequests(agent);
        if (index >= 0 && index < announcements.size()) {
            return announcements.get(index);
        }
        return null;
    }


        public void acceptAnnouncementRequest(int index, float commission, Employee agent) {
            Announcement announcement = getAnnouncementByIndex(index, agent);
            if (announcement != null) {
                announcement.setCommission(commission);
                announcement.setStatus(AnnouncementStatus.PUBLISHED);
                this.announcementRepository.saveAnnouncement(announcement);
            }
        }

            public void rejectAnnouncementRequest(int index, String reason, Employee agent) {
                Announcement announcement = getAnnouncementByIndex(index, agent);
                if (announcement != null) {
                    announcement.setRejectionReason(reason);
                    announcement.setStatus(AnnouncementStatus.REJECTED);
                    this.announcementRepository.saveAnnouncement(announcement);
                }
            }

}