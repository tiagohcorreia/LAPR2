package pt.ipp.isep.dei.esoft.project.domain.dto;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.shared.DealsDtoDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.shared.SortingOrder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class DealsDto {
    private static PlaceOrderToBuyPropertyRepository orderRepository = Repositories.getInstance().getOrderToBuyPropertyRepository();
    private static EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    private Announcement announcement;
    private Order order;



    public DealsDto(Announcement announcement, Order order) {
        this.announcement = announcement;
        this.order = order;
    }

    public DealsDto(Announcement announcement){
        this.announcement = announcement;

        for (Order o:
             orderRepository.getOrderList()) {
            if(o.getAnnouncementDTO().getProperty().equals(announcement.getProperty()))
                this.order = o;
        }
    }

//    public DealsDto(List<Announcement> announcementList){
//        List
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
//            sb.append(announcement.toString());
//            sb.append(order.getOrderAmount());
//            sb.append(announcement.getAgent().getBranch().getID());
//            sb.append(announcement.getAgent().getBranch().getName());
//            sb.append(announcement.getAgent().getName());
            sb.append(announcement.getDate().toString());
            sb.append("\t");
            sb.append(order.getOrderAmount());
            sb.append("\t\t");
            sb.append(announcement.getOwner().getName());
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public LocalDate getDate(){
        return this.announcement.getDate();
    }

    public Double getPrice(){
        return this.order.getOrderAmount();
    }

    public static void sortDealsByDate(List<DealsDto> dealsDtoList, SortingOrder sortingOrder){
                dealsDtoList.sort(new DealsDtoDateComparator());
                if (sortingOrder.equals(SortingOrder.DESCENDING))
                    Collections.reverse(dealsDtoList);
    }

    public static void sortDealsWithAlgorithm(List<DealsDto> dealsDtoList, String algorithm, SortingOrder sortingOrder){
        if (algorithm.toLowerCase().equals("bubble sort")){
            sortDealsWithBubbleSort(dealsDtoList, sortingOrder);
        } else {
            sortDealsWithInsertionSort(dealsDtoList, sortingOrder);
        }
    }

    public static void sortDealsWithBubbleSort(List<DealsDto> dealsDtoList, SortingOrder sortingOrder){

    }
    public static void sortDealsWithInsertionSort(List<DealsDto> dealsDtoList, SortingOrder sortingOrder){

    }


}
