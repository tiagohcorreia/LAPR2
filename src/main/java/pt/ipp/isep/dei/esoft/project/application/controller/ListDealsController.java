package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.DealsDto;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.shared.SortingOrder;

import java.util.ArrayList;
import java.util.List;

public class ListDealsController {
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

//    public static List<Announcement> getDeals() {
//        List<DealsDto> deals = new ArrayList<>();
//        List<Announcement> announcements = new ArrayList<>();
//        announcements.addAll(announcementRepository.getSoldAnnouncements());
//        //announcements.sort(new AnnouncementDateComparator());
//        AnnouncementRepository.sortAnnouncements(announcements, "date", SortingOrder.DESCENDING);
//
//        return announcements;
//    }
    public static List<DealsDto> getDeals() {
        List<DealsDto> deals = new ArrayList<>();
        List<Announcement> announcements = announcementRepository.getSoldAnnouncements();
        for (Announcement a:
             announcements) {
            DealsDto newDto = new DealsDto(a);
            deals.add(newDto);
        }
        //announcements.sort(new AnnouncementDateComparator());
        //AnnouncementRepository.sortAnnouncements(announcements, "date", SortingOrder.DESCENDING);
        return deals;
    }

    public static void sortDealsByDate(List<DealsDto> dealsDtoList, SortingOrder sortingOrder){
        DealsDto.sortDealsByDate(dealsDtoList, sortingOrder);
    }

    public static void sortDealsWithAlgorithm(List<DealsDto> dealsDtoList, String algorithm, SortingOrder sortingOrder){
        DealsDto.sortDealsWithAlgorithm(dealsDtoList, algorithm, sortingOrder);
    }

//    public static List<Announcement> sortByAreaWithAlgorithm(List<Announcement> announcements, String sortingAlgorithm, SortingOrder sortingorder){
//        return AnnouncementRepository.sortByAreaWithAlgoritm(announcements, sortingAlgorithm, sortingorderorder);
//    }
}
