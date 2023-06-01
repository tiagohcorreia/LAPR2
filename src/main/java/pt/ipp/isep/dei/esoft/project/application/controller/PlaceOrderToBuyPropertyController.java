package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;

import java.util.List;

/**
 * The type Place order to buy property controller.
 */
public class PlaceOrderToBuyPropertyController {

    private AnnouncementRepository announcementRepository = new AnnouncementRepository();
    private AnnouncementMapper announcementMapper;
    private PlaceOrderToBuyPropertyRepository orderRepository = new PlaceOrderToBuyPropertyRepository();

    /**
     * Instantiates a new Place order to buy property controller.
     *
     * @param orderRepository the order repository
     */
    public PlaceOrderToBuyPropertyController(PlaceOrderToBuyPropertyRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    /**
     * Announcement dto list list.
     *
     * @return the list
     */
    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.readObject();

        return AnnouncementMapper.convert(announcements);
    }

    /**
     * Create order string.
     *
     * @param orderAmount     the order amount
     * @param posAnnouncement the pos announcement
     * @return the string
     */
    public String createOrder(Double orderAmount, Integer posAnnouncement) {

        Order newOrder = new Order(orderAmount, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement));

        try {

            this.orderRepository.saveOrder(newOrder);
            this.orderRepository.writeObject();

            return newOrder.toString();

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }

    }

    /*public String listSelectedAnnouncement() {


    }*/
}
