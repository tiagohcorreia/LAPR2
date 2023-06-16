package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.collections.ObservableList;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.shared.SortingOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDealsController {
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();


    public static List<Announcement> getDeals() {
        List<Announcement> announcements = new ArrayList<>();
        announcements.addAll(announcementRepository.getSoldAnnouncements());
        //announcements.sort(new AnnouncementDateComparator());
        AnnouncementRepository.sortAnnouncements(announcements, "date", SortingOrder.DESCENDING);
        return announcements;
    }

//    public static List<Announcement> sortByAreaWithAlgorithm(List<Announcement> announcements, String sortingAlgorithm, SortingOrder sortingorder){
//        return AnnouncementRepository.sortByAreaWithAlgoritm(announcements, sortingAlgorithm, sortingorderorder);
//    }
}
