package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.ArrayList;
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
     * Instantiates a new Place order to buy property controller.
     */
    public PlaceOrderToBuyPropertyController() {
        this.announcementMapper = new AnnouncementMapper();
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
     * Create order order.
     *
     * @param orderAmount  the order amount
     * @param announcement the announcement
     * @param status       the status
     * @return the order
     */
    public Order createOrder(Double orderAmount, AnnouncementDTO announcement, boolean status) {

        Order newOrder = new Order(orderAmount, announcement, status);

        try {

            this.orderRepository.saveOrder(newOrder);
            this.orderRepository.writeObject();
            System.out.println();
            System.out.println(newOrder);

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }
        return newOrder;
    }


    /**
     * Gets announcement dto.
     *
     * @return the announcement dto
     */
    public List<AnnouncementDTO> getAnnouncementDTO() {

        List<AnnouncementDTO> dtoList = new ArrayList<>();

        for (Announcement announcement : this.announcementRepository.readObject()) {

            AnnouncementDTO dto = this.announcementMapper.toDto2(announcement);
            dtoList.add(dto);
        }
        return dtoList;
    }

    /**
     * Gets announcement by pos.
     *
     * @param posAnnouncement the pos announcement
     * @return the announcement by pos
     */
    public AnnouncementDTO getAnnouncementByPos(int posAnnouncement) {

        List<AnnouncementDTO> announcements = getAnnouncementDTO();

        return announcements.get(posAnnouncement);
    }
}
