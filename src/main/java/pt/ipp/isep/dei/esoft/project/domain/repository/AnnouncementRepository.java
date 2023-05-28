package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Announcement repository.
 */
public class AnnouncementRepository {
    /**
     * The Announcements.
     */
    List<Announcement> announcements = new ArrayList<>();
    List<Announcement> publishedAnnouncements = new ArrayList<>();
     List<Announcement> requestedAnnouncements = new ArrayList<>();
    List<Announcement> soldAnnouncements = new ArrayList<>();
    List<Announcement> rentedAnnouncements = new ArrayList<>();
     List<Announcement> pendentAnnouncements = new ArrayList<>();
    List<Announcement> rejectedAnnouncements = new ArrayList<>();

    /**
     * Save boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */


    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getAnnouncement());
    }

    public void saveAnnouncement(Announcement announcement) {
        AnnouncementStatus status = announcement.getStatus();
        switch (status) {
            case PUBLISHED:
                publishedAnnouncements.add(announcement);
                break;
            case REQUESTED:
                requestedAnnouncements.add(announcement);
                break;
            case SOLD:
                soldAnnouncements.add(announcement);
                break;
            case RENTED:
                rentedAnnouncements.add(announcement);
                break;
            case PENDENT:
                pendentAnnouncements.add(announcement);
                break;
            case REJECTED:
                rejectedAnnouncements.add(announcement);
                break;
        }
        announcements.add(announcement);
    }

    public List<Announcement> getPublishedAnnouncements() {
        return publishedAnnouncements;
    }

    public List<Announcement> getRequestedAnnouncements() {
        return requestedAnnouncements;
    }

    public List<Announcement> getSoldAnnouncements() {
        return soldAnnouncements;
    }

    public List<Announcement> getRentedAnnouncements() {
        return rentedAnnouncements;
    }

    public List<Announcement> getPendentAnnouncements() {
        return pendentAnnouncements;
    }

    public List<Announcement> getRejectedAnnouncements() {
        return rejectedAnnouncements;
    }

    public List<Announcement> getAllAnnouncements() {
        return announcements;
    }


/**
 * Create announcement boolean.
 *
 * @param announcement the announcement
 * @return the boolean
 */
    public boolean createAnnouncement (Announcement announcement) {

        if(validateAnnouncement(announcement)) {

            return addAnnouncement(announcement);
        }
        return false;
    }

    /**
     * Checks if the announcement to be saved is a duplicate.
     *
     * @param announcement the announcement to be saved
     * @return true if successful, false otherwise
     */
    public boolean validateAnnouncement(Announcement announcement) {
        for(Announcement i : announcements) {
            if(announcement.equals(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add announcement boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */
    public boolean addAnnouncement(Announcement announcement) {

        if(announcement != null && validateAnnouncement(announcement)) {

            return announcements.add(announcement.getAnnouncement());
        }
        return false;
    }


    /**
     * Gets all visible announcements.
     *
     * @return the all visible announcements
     */
   /* public List<Announcement> getAllVisibleAnnouncements() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getAnnouncement());
            }
        }
        return allVisibleAnnouncements;
    }

    */



    /**
     * Get available fields list.
     *
     * @return the list
     */
    public List<List<Object>> getAvailableFields(){
        List<List<Object>> availableFields = new ArrayList<>();
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());

        //TO-FIX
        for(Announcement announcement : announcements){
            if ( announcement != null && announcement.getStatus() == AnnouncementStatus.PUBLISHED){
                if (!availableFields.get(0).contains(announcement.getTypeOfBusiness())){
                    availableFields.get(0).add(announcement.getTypeOfBusiness());
                }
                if (!availableFields.get(1).contains(announcement.getProperty().getClass().getSimpleName().toUpperCase())){
                    availableFields.get(1).add(announcement.getProperty().getClass().getSimpleName().toUpperCase());
                }
                if (!announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(announcement.getProperty().getNumberOfBedrooms());
                }
            }
        }
        return availableFields;
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
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            Announcement gotAnnouncement = announcement.getAnnouncement(typeOfBusiness, typeOfProperty, numberOfBedrooms);
            if(gotAnnouncement != null){
                matchingAnnouncements.add(gotAnnouncement);
            }
        }
        return matchingAnnouncements;
    }

    public List<Announcement> getRequestsByAgentName(String agentName) {
        List<Announcement> agentRequests = new ArrayList<>();

        for (Announcement announcement : announcements) {
            if (announcement.getStatus() == AnnouncementStatus.REQUESTED && announcement.getAgent().equals(agentName)) {
                agentRequests.add(announcement);
            }
        }

        return agentRequests;
    }
}




