package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Announcement mapper.
 */
public class AnnouncementMapper {

    private static List<AnnouncementDTO> announcementDTOList = new ArrayList<>();
    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    /**
     * Convert list.
     *
     * @param announcementList the announcement list
     * @return the list
     */
    public static List<AnnouncementDTO> convert(List<Announcement> announcementList) {

        return announcementList.stream().map(AnnouncementDTO::new).collect(Collectors.toList());
    }

    /**
     * To dto list.
     *
     * @param announcementList the announcement list
     * @return the list
     */
    public List<AnnouncementDTO> toDto(List<Announcement> announcementList) {

        List<AnnouncementDTO> dtoList = new ArrayList<>();

        for (Announcement announcement : announcementList) {

            dtoList.add(toDtoAnnouncement(announcement));
        }
        return dtoList;
    }

    /**
     * To dto 2 announcement dto.
     *
     * @param announcement the announcement
     * @return the announcement dto
     */
    public AnnouncementDTO toDto2(Announcement announcement) {

        AnnouncementDTO dto = new AnnouncementDTO();
        dto.setPrice(announcement.getPrice());
        dto.setTypeOfBusiness(announcement.getTypeOfBusiness());
        dto.setProperty(announcement.getProperty());
        dto.setAgent(announcement.getAgent());

        return dto;
    }

    /**
     * Gets all announcements.
     *
     * @return the all announcements
     */
    public List<AnnouncementDTO> getAllAnnouncements() {

        List<AnnouncementDTO> allAnnouncements = new ArrayList<>();

        for (AnnouncementDTO announcementDTO : allAnnouncements) {

            allAnnouncements.add(announcementDTO.getAnnouncement());
        }
        return allAnnouncements;
    }

    /**
     * Gets all announcements recent to oldest.
     *
     * @return the all announcements recent to oldest
     */
    public List<AnnouncementDTO> getAllAnnouncementsRecentToOldest() {

        List<AnnouncementDTO> allAnnouncements = new ArrayList<>();
        List<AnnouncementDTO> allAnnouncementsFromRecentToOldest = new ArrayList<>();

        for (AnnouncementDTO announcementDTO : allAnnouncements) {
            allAnnouncements.add(announcementDTO.getAnnouncement());
        }
        for (int i = allAnnouncements.size() - 1; i >= 0; i--) {
            AnnouncementDTO announcementDTO = allAnnouncements.get(i);
            allAnnouncementsFromRecentToOldest.add(announcementDTO);
        }
        return allAnnouncementsFromRecentToOldest;
    }

    /**
     * Gets announcement dto by id.
     *
     * @param id the id
     * @return the announcement dto by id
     */
    public static AnnouncementDTO getAnnouncementDTOById(int id) {

        if (id >= 0 && id < announcementDTOList.size()) {

            return announcementDTOList.get(id);
        }

        return null;
    }

    /**
     * To dto announcement announcement dto.
     *
     * @param announcement the announcement
     * @return the announcement dto
     */
    public AnnouncementDTO toDtoAnnouncement(Announcement announcement) {
        return new AnnouncementDTO();
    }
}


