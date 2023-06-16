package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class AnalyseDealsController {
    Repositories repositories = Repositories.getInstance();
    PurchaseOrderRepository purchaseOrderRepository= repositories.getPurchaseOrderRepository();

    public List<Order> getApartmentsAndHouses() {
        List<Order> orderList = purchaseOrderRepository.getAll();
        List<Order> housesAndApartmentsList = purchaseOrderRepository.getAll();
        for (Order order : orderList) {
            if (order.getAnnouncementDTO().getProperty().getClass().toString().equals("House") || order.getAnnouncementDTO().getProperty().getClass().toString().equals("Apartment")) {
                housesAndApartmentsList.add(order);
            }
        }
        return housesAndApartmentsList;
    }

    private void simpleLinearRegression(int choice) {
        List<Order> housesAndapartmentsList = getApartmentsAndHouses();
        SimpleRegression regression = new SimpleRegression();
        if (choice ==1){
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getArea(), order.getOrderAmount());
            }
        } else if (choice==2) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getCityCentreDistance(), order.getOrderAmount());
            }
        }else if (choice==3) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfBedrooms(), order.getOrderAmount());
            }
        }else if (choice==4) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfBathrooms(), order.getOrderAmount());
            }
        }else if (choice==5) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfParkingSpaces(), order.getOrderAmount());
            }
        }
        double slope = regression.getSlope();
        double intercept = regression.getIntercept();
    }

}
