package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

/**
 * The type Place order to buy property controller.
 */
public class PlaceOrderToBuyPropertyController {

    private AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    private AnnouncementMapper announcementMapper;
    private PlaceOrderToBuyPropertyRepository orderRepository = Repositories.getInstance().getOrderToBuyPropertyRepository();

    private AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

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

        boolean status = false;

        Order newOrder = new Order(orderAmount, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement), status);

        try {

            this.orderRepository.saveOrder(newOrder);
            this.orderRepository.writeObject();
            System.out.println(newOrder);
            return newOrder.toString();

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }

    }

    /**
     * Show selected announcement announcement dto.
     *
     * @param posAnnouncement the pos announcement
     * @return the announcement dto
     */
    public AnnouncementDTO showSelectedAnnouncement(int posAnnouncement) {

        for (int i = 0; i < announcementDTOList().size(); i++) {

            if (posAnnouncement >= 0 && posAnnouncement < announcementDTOList().size() && posAnnouncement == i) {

                return announcementDTOList().get(posAnnouncement);
            }
        }
        return null;
    }
}
