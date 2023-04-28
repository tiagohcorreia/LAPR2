package app.domain.shared;

import app.domain.model.Announcement;

import java.util.Comparator;

public class AnnouncementLocationComparator implements Comparator<Announcement> {
    @Override
    public int compare(Announcement o1, Announcement o2) {
        return CharSequence.compare(o1.getProperty().getLocation().getName(), o2.getProperty().getLocation().getName());
    }
}
