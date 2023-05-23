package pt.ipp.isep.dei.esoft.project.domain.dto;

import pt.ipp.isep.dei.esoft.project.domain.mappers.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnnouncementDTO {
    private float price;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;

    private AnnouncementRepository announcementRepository;

    List<AnnouncementDTO> announcementDTOs = new ArrayList<>();


    public AnnouncementDTO(float price, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.price = price;
        this.typeOfBusiness = typeOfBusiness;
        this.property = property;
        this.agent = agent;
    }

    public AnnouncementDTO() {

    }

    public AnnouncementDTO(Announcement announcement) {

        this.price = announcement.getPrice();
        this.typeOfBusiness = announcement.getTypeOfBusiness();
        this.property = announcement.getProperty();
        this.agent = announcement.getAgent();
    }

    public static List<AnnouncementDTO> convert(List<Announcement> announcements) {
        return announcements.stream().map(AnnouncementDTO :: new).collect(Collectors.toList());
    }

    /*public AnnouncementDTO selectAnnouncementByNumber(int selectedNumber) {

        Map<Integer, AnnouncementDTO> announcementMap = new HashMap<>();

        AnnouncementMapper mapper = new AnnouncementMapper();

        List<AnnouncementDTO> announcementDTOs = mapper.toDTOList(getAllVisibleAnnouncements());

        for (int i = 0; i < announcementDTOs.size(); i++) {
            announcementMap.put(i + 1, announcementDTOs.get(i));
        }

        return announcementMap.get(selectedNumber);
    }*/

}
