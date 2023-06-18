package pt.ipp.isep.dei.esoft.project.domain.mappers;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;


/**
 * The type Announcement request mapper.
 */
public class AnnouncementRequestMapper {

    /**
     * To dto announcement request dto.
     *
     * @param announcement the announcement
     * @return the announcement request dto
     */
    public AnnouncementRequestDTO toDto(Announcement announcement) {
        AnnouncementRequestDTO dto = new AnnouncementRequestDTO();
        dto.setDate(announcement.getDate());
        dto.setStatus(announcement.getStatus());
        dto.setPrice(announcement.getPrice());
        dto.setTypeOfBusiness(announcement.getTypeOfBusiness());
        dto.setProperty(announcement.getProperty());

        return dto;
    }

    /**
     * To entity announcement.
     *
     * @param dto the dto
     * @return the announcement
     */
    public Announcement toEntity(AnnouncementRequestDTO dto) {
        Announcement announcement = new Announcement();
        announcement.setPrice(dto.getPrice());
        announcement.setTypeOfBusiness(dto.getTypeOfBusiness());
        announcement.setProperty(dto.getProperty());
        return announcement;
    }


}
