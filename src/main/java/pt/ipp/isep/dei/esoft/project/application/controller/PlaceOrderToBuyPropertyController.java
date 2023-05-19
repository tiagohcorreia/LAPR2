package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;

public class PlaceOrderToBuyPropertyController {

    private PlaceOrderToBuyPropertyRepository orderRepository;

    public PlaceOrderToBuyPropertyController(PlaceOrderToBuyPropertyRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public String createOrder(Double orderAmount, Announcement announcement) {

        Order newOrder = new Order(orderAmount, announcement);

        try {


            return newOrder.toString();

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }

    }
}
