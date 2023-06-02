package pt.ipp.isep.dei.esoft.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ArrayList
        ;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;

/**
 * The type Announcement repository test.
 */
public class AnnouncementRepositoryTest {

    private static final Branch branch = new Branch();

    /**
     * Test save.
     */
    @Test
    public void testSave() {
        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, branch);

        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new Location(),1,photographs), agent);
        assertTrue(repository.save(announcement));
    }

    /**
     * Test create announcement.
     */
    @Test
    public void testCreateAnnouncement() {
        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, branch);
        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new Location(),1,photographs), agent);
        assertTrue(repository.createAnnouncement(announcement));
    }

    /**
     * Test validate announcement.
     */
    @Test
    public void testValidateAnnouncement() {
        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, branch);

        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new Location(),1,photographs), agent);
        assertTrue(repository.validateAnnouncement(announcement));
        repository.save(announcement);
        //assertFalse(repository.validateAnnouncement(announcement));
    }

    /**
     * Test add announcement.
     */
    @Test
    public void testAddAnnouncement() {
        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, branch);

        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new Location(),1,photographs), agent);
        assertTrue(repository.addAnnouncement(announcement));
        assertFalse(repository.addAnnouncement(null));
        //assertFalse(repository.addAnnouncement(announcement));
    }

  /*  @Test
    public void testGetAllVisibleAnnouncements() {

        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);
        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement1 = new Announcement(true, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new City("lisboa"),1,photographs), agent);
        Announcement announcement2 = new Announcement(false, 2, 1.0f, TypeOfBusiness.SELL, new Land(2,new City("lisboa"),2,photographs), agent);
        repository.save(announcement1);
        repository.save(announcement2);
        List<Announcement> visibleAnnouncements = repository.getAllVisibleAnnouncements();
        assertEquals(1, visibleAnnouncements.size());
        assertTrue(visibleAnnouncements.contains(announcement1));
        assertFalse(visibleAnnouncements.contains(announcement2));
    }*/



   /*  @Test
   public void testGetAnnouncements() {


        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);
        ArrayList<String> availableEquipment = new ArrayList<>();
       String  equipment = "bb";
       availableEquipment.add(equipment);
        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);

        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        announcementRepository.addAnnouncement(new Announcement(true, 1.0f,1, TypeOfBusiness.SELL, new Property(new House(1,new City("Porto"),1,photographs,1,1,1,availableEquipment,true,true, SunExposure.NORTH)),agent));
        announcementRepository.addAnnouncement(new Announcement(true, 2.0f,2, TypeOfBusiness.RENT, new Property(new Apartment(2,new City("lisboa"),2,photographs,2,2,3,availableEquipment)) ,agent));
        announcementRepository.addAnnouncement(new Announcement(true, 3.0f, 3,TypeOfBusiness.SELL, new Property(new House(3, new City("coimbra"),3,photographs, 3,3,3,availableEquipment,true,true,SunExposure.NORTH)),agent));
        announcementRepository.addAnnouncement(new Announcement(true,4.0f,4,TypeOfBusiness.RENT, new Property(new Land(4,new City("braga"),4,photographs)),agent));

        List<Announcement> expectedAnnouncements1 = new ArrayList<>();
        expectedAnnouncements1.add(new Announcement(true, 1.0f,1, TypeOfBusiness.SELL, new Property(new House(1,new City("Porto"),1,photographs,1,1,1,availableEquipment,true,true, SunExposure.NORTH)),agent));
        expectedAnnouncements1.add(new Announcement(true, 3.0f, 3,TypeOfBusiness.SELL, new Property(new House(3, new City("coimbra"),3,photographs, 3,3,3,availableEquipment,true,true,SunExposure.NORTH)),agent));

        List<Announcement> expectedAnnouncements2 = new ArrayList<>();
        expectedAnnouncements2.add(new Announcement(true,4.0f,4,TypeOfBusiness.RENT, new Property(new House(4,new City("braga"),4,photographs, 4,4,4,availableEquipment,true,true,SunExposure.NORTH)),agent));
        expectedAnnouncements2.add(new Announcement(true, 2.0f,2, TypeOfBusiness.RENT, new Property(new Apartment(2,new City("lisboa"),2,photographs,2,2,3,availableEquipment)) ,agent));



        List<Announcement> actualAnnouncements1 = announcementRepository.getAnnouncements("RENT", "HOUSE", 4);
        List<Announcement> actualAnnouncements2 = announcementRepository.getAnnouncements("SELL", "HOUSE", 3);


        assertEquals(expectedAnnouncements1, actualAnnouncements1);
        assertEquals(expectedAnnouncements2, actualAnnouncements2);

    }
    */


}