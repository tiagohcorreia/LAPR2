package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {
    List<Announcement> announcements = new ArrayList<>();

    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getAnnouncement());
    }

    public boolean createAnnouncement (Announcement announcement) {

        if(validateAnnouncement(announcement)) {

            return addAnnouncement(announcement);
        }
        return false;
    }
    public boolean validateAnnouncement(Announcement announcement) {

        for(Announcement announcement1 : announcements) {

            if(announcement.equals(announcement)) {

                return false;
            }
        }
        return true;
    }

    public boolean addAnnouncement(Announcement announcement) {

        if(announcement != null && validateAnnouncement(announcement)) {

            return this.announcements.add(announcement);
        }
        return false;
    }


    public List<Announcement> getAllVisibleAnnouncements() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getAnnouncement());
            }
        }
        return allVisibleAnnouncements;
    }



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
