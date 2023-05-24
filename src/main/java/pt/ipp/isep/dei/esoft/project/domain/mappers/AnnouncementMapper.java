package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnouncementMapper {

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

        List<AnnouncementDTO> allVisibleAnnouncements = new ArrayList<>();

        for (AnnouncementDTO announcementDTO : allVisibleAnnouncements) {

            allVisibleAnnouncements.add(announcementDTO.getAnnouncement());
        }
        return allVisibleAnnouncements;
    }

    public AnnouncementDTO toDtoAnnouncement(Announcement announcement) {
        return new AnnouncementDTO();
    }
}


