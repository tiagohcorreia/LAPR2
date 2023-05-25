package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnouncementMapper {

    private static List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

    public static List<AnnouncementDTO> convert(List<Announcement> announcementList) {

        return announcementList.stream().map(AnnouncementDTO::new).collect(Collectors.toList());
    }

    public List<AnnouncementDTO> toDto(List<Announcement> announcementList) {

        List<AnnouncementDTO> dtoList = new ArrayList<>();

        for (Announcement announcement : announcementList) {

            dtoList.add(toDtoAnnouncement(announcement));
        }
        return dtoList;
    }

    public List<AnnouncementDTO> getAllAnnouncements() {

        List<AnnouncementDTO> allAnnouncements = new ArrayList<>();

        for (AnnouncementDTO announcementDTO : allAnnouncements) {

            allAnnouncements.add(announcementDTO.getAnnouncement());
        }
        return allAnnouncements;
    }

    public static AnnouncementDTO getAnnouncementDTOById(int id) {

        if (id >= 0 && id < announcementDTOList.size()) {

            return announcementDTOList.get(id);
        }

        return null;
    }

    public AnnouncementDTO toDtoAnnouncement(Announcement announcement) {
        return new AnnouncementDTO();
    }
}


