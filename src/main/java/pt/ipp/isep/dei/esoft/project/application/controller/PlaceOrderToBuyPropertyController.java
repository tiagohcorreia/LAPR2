package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;

import java.util.List;

public class PlaceOrderToBuyPropertyController {

    private AnnouncementRepository announcementRepository;
    private PlaceOrderToBuyPropertyRepository orderRepository;

    public PlaceOrderToBuyPropertyController(PlaceOrderToBuyPropertyRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public PlaceOrderToBuyPropertyController(AnnouncementRepository announcementRepository) {
        //this.announcementRepository = announcementRepository;
    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.getAllVisibleAnnouncements();
        return AnnouncementDTO.convert(announcements);
    }


    public String createOrder(Double orderAmount, Announcement announcement) {

        Order newOrder = new Order(orderAmount, announcement);

        try {

            this.orderRepository.saveOrder(newOrder);
            return newOrder.toString();

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }

    }
}
