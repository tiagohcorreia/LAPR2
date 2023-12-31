package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;



public class AnnouncementRequestsController implements Serializable {
    public  AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    public EmployeeRepository employeeRepository=Repositories.getInstance().getEmployeeRepository();;

    private AuthenticationController authenticationController=new AuthenticationController();


    public AnnouncementRequestMapper announcementRequestMapper = new AnnouncementRequestMapper();




    public Employee getCurrentAgent() {

        pt.ipp.isep.dei.esoft.project.application.session.UserSession userSession = authenticationController.getCurrentSession();
        String agentEmail= String.valueOf(userSession.getUserEmail());
        Employee agent= employeeRepository.findByEmail(agentEmail);

        return agent;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employeeRepository.getEmployeeList()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null; //
    }


    public boolean isEmployee(String agentName) {
        Employee agent = getEmployee(agentName);
        return agent != null;
    }


    public List<AnnouncementRequestDTO> getAnnouncementRequests(Employee agent) {
        List<AnnouncementRequestDTO> requestsForAgent = new ArrayList<>();
        for (Announcement announcement : this.announcementRepository.readObject()) {
            if (announcement.getStatus() == AnnouncementStatus.REQUESTED && announcement.getAgent().equals(agent)) {
                AnnouncementRequestDTO dto = this.announcementRequestMapper.toDto(announcement);
                requestsForAgent.add(dto);
            }
        }

        Collections.sort(requestsForAgent, Comparator.comparing(AnnouncementRequestDTO::getDate).reversed());

        return requestsForAgent;
    }

    public AnnouncementRequestDTO getAnnouncementByIndex(int index, Employee agent) {
        List<AnnouncementRequestDTO> announcements = getAnnouncementRequests(agent);
        if (index >= 0 && index < announcements.size()) {
            return announcements.get(index);
        }
        return null;
    }

    public void acceptAnnouncementRequest(int index, float commission, Employee agent) {
        AnnouncementRequestDTO dto = getAnnouncementByIndex(index, agent);
        if (dto != null) {
            Announcement announcement = this.announcementRequestMapper.toEntity(dto);
            announcement.setCommission(commission);
            announcement.setStatus(AnnouncementStatus.PUBLISHED);
            this.announcementRepository.saveAnnouncement(announcement);
            this.announcementRepository.writeObject();
        }
    }

    public void rejectAnnouncementRequest(int index, String reason, Employee agent) {
        AnnouncementRequestDTO dto = getAnnouncementByIndex(index, agent);
        if (dto != null) {
            Announcement announcement = this.announcementRequestMapper.toEntity(dto);
            announcement.setStatus(AnnouncementStatus.REJECTED);
            this.announcementRepository.saveAnnouncement(announcement);
            this.announcementRepository.writeObject();
        }
    }



}
