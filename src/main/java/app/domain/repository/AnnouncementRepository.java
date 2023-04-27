package app.domain.repository;

import app.domain.model.Announcement;
import app.domain.model.Employee;
import app.domain.model.Property;
import app.domain.shared.TypeOfBusiness;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {
    List<Announcement> announcements = new ArrayList<>();

    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getListing());
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

    public List<Announcement> getAllVisibleListings() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getListing());
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
                if (announcement.getProperty().getClass().getSimpleName().equals("Land") && true){
                //if (announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(300);
                    //availableFields.get(2).add(announcement.getProperty().getBedrooms());
                }
            }
        }
        return availableFields;
    }

    public List<Announcement> getListings(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            Announcement gotAnnouncement = announcement.getListing(typeOfBusiness, typeOfProperty, numberOfBedrooms);
            if(gotAnnouncement != null){
                matchingAnnouncements.add(gotAnnouncement);
            }
        }
        return matchingAnnouncements;
    }

}
