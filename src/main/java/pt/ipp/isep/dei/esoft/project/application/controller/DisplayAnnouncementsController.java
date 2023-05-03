package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

/**
 * The type Display announcements controller.
 */
public class DisplayAnnouncementsController {
    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    /**
     * Get available fields list.
     *
     * @return the list
     */
    public List<List<Object>> getAvailableFields(){
        return this.announcementRepository.getAvailableFields();
    }

    /**
     * Get announcements list.
     *
     * @param typeOfBusiness   the type of business
     * @param typeOfProperty   the type of property
     * @param numberOfBedrooms the number of bedrooms
     * @return the list
     */
    public List<Announcement> getAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        return announcementRepository.getAnnouncements(typeOfBusiness, typeOfProperty, numberOfBedrooms);
    }

    /**
     * Get all visible announcements list.
     *
     * @return the list
     */
    public List<Announcement> getAllVisibleAnnouncements(){
        return announcementRepository.getAllVisibleAnnouncements();
    }

}
