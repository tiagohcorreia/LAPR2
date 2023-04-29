package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.util.Comparator;

public class AnnouncementPriceComparator implements Comparator<Announcement> {
    @Override
    public int compare(Announcement o1, Announcement o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
