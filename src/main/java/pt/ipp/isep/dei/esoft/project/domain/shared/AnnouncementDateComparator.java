package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;

public class AnnouncementDateComparator implements Comparator<Announcement>{
    @Override
    public int compare(Announcement o1, Announcement o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}

