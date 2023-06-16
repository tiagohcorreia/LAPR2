package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

public class AnalyseDealsController {
    Repositories repositories = Repositories.getInstance();
    PurchaseOrderRepository purchaseOrderRepository= repositories.getPurchaseOrderRepository();

    public List<Order> getApartmentsAndHouses(){
        List<Order> orderList= purchaseOrderRepository.getAll();
        List<Order> housesAndApartmentsList= purchaseOrderRepository.getAll();
        for (Order order : orderList) {
            if (order.getAnnouncementDTO().getProperty().getClass().toString().equals("House") || order.getAnnouncementDTO().getProperty().getClass().toString().equals("Apartment")) {
                housesAndApartmentsList.add(order);
            }
        }
        return housesAndApartmentsList;
    }
}
