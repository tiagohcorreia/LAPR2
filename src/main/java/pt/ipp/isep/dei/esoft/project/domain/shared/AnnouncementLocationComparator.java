package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;

import java.util.Comparator;

/**
 * The type Announcement location comparator.
 */
public class AnnouncementLocationComparator implements Comparator<Announcement> {
    @Override
    public int compare(Announcement o1, Announcement o2) {
        //return CharSequence.compare(o1.getProperty().getLocation().getStreet(), o2.getProperty().getLocation().getStreet());
        //return CharSequence.compare(o1.getProperty().getLocation().getCity().getName(), o2.getProperty().getLocation().getCity().getName());
        return CharSequence.compare(o1.getProperty().getLocation().getStreet(), o2.getProperty().getLocation().getStreet());
    }
}
