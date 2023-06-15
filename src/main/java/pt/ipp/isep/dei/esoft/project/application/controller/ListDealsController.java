package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.collections.ObservableList;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

public class ListDealsController {
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();


    public static List<Announcement> getDeals() {
        return announcementRepository.getSoldAnnouncements();

    }
}
