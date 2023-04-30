package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

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

    /**
     * Save boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */
    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getAnnouncement());
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
     * Validate announcement boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */
    public boolean validateAnnouncement(Announcement announcement) {

        for(Announcement announcement1 : announcements) {

            if(announcement.equals(announcement)) {

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

            return this.announcements.add(announcement);
        }
        return false;
    }


    /**
     * Gets all visible announcements.
     *
     * @return the all visible announcements
     */
    public List<Announcement> getAllVisibleAnnouncements() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getAnnouncement());
            }
        }
        return allVisibleAnnouncements;
    }


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
            if ( announcement != null && announcement.isVisible()){
                if (!availableFields.get(0).contains(announcement.getTypeOfBusiness())){
                    availableFields.get(0).add(announcement.getTypeOfBusiness());
                }
                if (!availableFields.get(1).contains(announcement.getProperty().getClass().getSimpleName())){
                    availableFields.get(1).add(announcement.getProperty().getClass().getSimpleName());
                }
                if (!announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                //if (announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(announcement.getProperty().getNumberOfBedrooms());
                    //availableFields.get(2).add(announcement.getProperty().getBedrooms());
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

}
