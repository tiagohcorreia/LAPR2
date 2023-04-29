package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

public class DisplayAnnouncementsController {
    Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();

    public List<List<Object>> getAvailableFields(){
        return this.announcementRepository.getAvailableFields();
    }

    public List<Announcement> getAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        return announcementRepository.getAnnouncements(typeOfBusiness, typeOfProperty, numberOfBedrooms);
    }

    public List<Announcement> getAllVisibleAnnouncements(){
        return announcementRepository.getAllVisibleAnnouncements();
    }

}
