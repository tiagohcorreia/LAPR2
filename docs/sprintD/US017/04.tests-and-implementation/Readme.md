# US 017 - List all deals made

# 5. Construction (Implementation)


## Class CreateTaskController 

```java
public class ListDealsController {
    static AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();


    public static List<Announcement> getDeals() {
        List<Announcement> announcements = new ArrayList<>();
        announcements.addAll(announcementRepository.getSoldAnnouncements());
        AnnouncementRepository.sortAnnouncements(announcements, "date", SortingOrder.DESCENDING);
        return announcements;
    }
    
    public static List<Announcement> sortByAreaWithAlgorithm(List<Announcement> announcements, String sortingAlgorithm, SortingOrder sortingorder){
        return AnnouncementRepository.sortByAreaWithAlgoritm(announcements, sortingAlgorithm, sortingorderorder);
    }
}
```


## Class AnnouncementRepository

```java
public class AnnouncementRepository {
    List<Announcement> soldAnnouncements = new ArrayList<>();
    
    public List<Announcement> getSoldAnnouncements() { return soldAnnouncements; }

    public static void sortAnnouncements(List<Announcement> announcements, String property, SortingOrder sortingOrder){
        announcements.sort(new AnnouncementDateComparator());
        if (sortingOrder.equals(SortingOrder.DESCENDING))
            Collections.reverse(announcements);
    }
}
```





