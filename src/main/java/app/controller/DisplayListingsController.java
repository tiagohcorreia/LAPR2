package app.controller;

import app.domain.model.Announcement;
import app.domain.repository.AnnouncementRepository;
import app.domain.repository.Repositories;

import java.util.List;

public class DisplayListingsController {
    Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getListingRepository();

    public List<List<Object>> getAvailableFields(){
        return this.announcementRepository.getAvailableFields();
    }

    public List<Announcement> getListings(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        return announcementRepository.getListings(typeOfBusiness, typeOfProperty, numberOfBedrooms);
    }

    public List<Announcement> getAllVisibleListings(){
        return announcementRepository.getAllVisibleListings();
    }

}
