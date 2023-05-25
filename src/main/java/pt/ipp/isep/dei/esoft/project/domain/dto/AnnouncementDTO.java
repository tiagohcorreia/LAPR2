package pt.ipp.isep.dei.esoft.project.domain.dto;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDTO {
    private float price;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AnnouncementDTO{");
        sb.append("price=").append(price);
        sb.append(", typeOfBusiness=").append(typeOfBusiness);
        sb.append(", property=").append(property);
        sb.append(", agent=").append(agent);
        sb.append(", announcementDTOs=").append(announcementDTOs);
        sb.append('}');
        return sb.toString();
    }

    public AnnouncementDTO getAnnouncement() {

        return null;
    }

}



