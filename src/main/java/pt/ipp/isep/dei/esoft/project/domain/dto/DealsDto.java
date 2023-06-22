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

    public DealsDto (DealsDto dealsDto){
        this.announcement = dealsDto.getAnnouncement();
        this.order = dealsDto.getOrder();
    }

//    public DealsDto(List<Announcement> announcementList){
//        List
//    }

    private Announcement getAnnouncement(){
        return this.announcement;
    }

    private Order getOrder(){
        return this.order;
    }

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
        int i = 0;
        int j = 0;
        boolean ordered = true;
        DealsDto temp = null;
        for ( i = 0; i < dealsDtoList.size(); i++) {
            for ( j = 0; j < dealsDtoList.size()-i-1; j++) {
                if(sortingOrder.equals(SortingOrder.ASCENDING)) {
                    if (dealsDtoList.get(j).getPrice() > dealsDtoList.get(j + 1).getPrice()) {
                        ordered = false;
                        temp = new DealsDto(dealsDtoList.get(j));
                        dealsDtoList.set(j, dealsDtoList.get(j + 1));
                        dealsDtoList.set(j + 1, temp);
                    } else {
                        ordered = true;
                    }
                } else {
                    if (dealsDtoList.get(j).getPrice() < dealsDtoList.get(j + 1).getPrice()) {
                        ordered = false;
                        temp = new DealsDto(dealsDtoList.get(j));
                        dealsDtoList.set(j, dealsDtoList.get(j + 1));
                        dealsDtoList.set(j + 1, temp);
                    } else {
                        ordered = true;
                    }
                }
            }
            if(ordered)
                break;
        }
    }
    public static void sortDealsWithInsertionSort(List<DealsDto> dealsDtoList, SortingOrder sortingOrder){
        for (int i = 1; i < dealsDtoList.size(); ++i) {
            DealsDto temp = dealsDtoList.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            if (sortingOrder.equals(SortingOrder.ASCENDING)) {
                while (j >= 0 && dealsDtoList.get(j).getPrice() > temp.getPrice()) {
                    //dealsDtoList.add(j + 1, dealsDtoList.get(j));
                    dealsDtoList.set(j+1, dealsDtoList.get(j));
                    j--;
                }
            }else{
                while (j >= 0 && dealsDtoList.get(j).getPrice() < temp.getPrice()) {
                    //dealsDtoList.add(j + 1, dealsDtoList.get(j));
                    dealsDtoList.set(j+1, dealsDtoList.get(j));
                    j--;
                }
            }
            dealsDtoList.set(j+1, temp);
        }
    }


}
