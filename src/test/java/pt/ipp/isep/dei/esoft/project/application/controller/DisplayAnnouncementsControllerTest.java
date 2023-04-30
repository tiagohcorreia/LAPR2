package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfProperty;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Display announcements controller test.
 */
class DisplayAnnouncementsControllerTest {

    /**
     * The constant defaultProprty.
     */
//    private static String url = "http:\\\\photograps.server";
//    private static List<String> phot = new ArrayList<>();
//    phot.push
    public static final Property defaultProprty = new House(
            (float)10.3,
            new City(),
            20,
            new ArrayList<>(),
            3,
            2,
            2,
            new ArrayList<>(),
            true,false,SunExposure.NORTH);
    /**
     * The constant defaultEmployee.
     */
    public static final Employee defaultEmployee = new Employee("Joao",
            123123123,
            123456789,
            "Somewhere",
            "email@mail.com",1234567890, Role.AGENT, Agency.AGENCY1);
    /**
     * The constant defaultAnnouncement.
     */
    public static final Announcement defaultAnnouncement = new Announcement(
            true,
            20,
            5,
            TypeOfBusiness.RENT,
            defaultProprty,
            defaultEmployee);

    /**
     * The Announcements list.
     */
    List<Announcement> announcementsList = new ArrayList<>();


    /**
     * Ensure get available fields.
     */
    @Test
    void ensureGetAvailableFields() {
        DisplayAnnouncementsController controller = new DisplayAnnouncementsController();
        //Arrange
        //Get Repository
        Repositories repositories = Repositories.getInstance();
        AnnouncementRepository announcementRepository = new AnnouncementRepository();

        //Create announcements
        List<Announcement> mockAnnouncements = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //Employee newAgent=new Employee();
            Announcement newAnnouncement = new Announcement(
                    //(i%2==0) ? true:false,
                    true,
                    (float) ((float) i*0.5),
                    10,
                    ((i%3==0) ?
                            TypeOfBusiness.SELL
                            :
                            TypeOfBusiness.RENT),
                defaultProprty,
                defaultEmployee);

            mockAnnouncements.add(newAnnouncement);
        }

        for (Announcement announcement:mockAnnouncements){
            announcementRepository.save(announcement);
        }

        List<List<Object>> availableFields = announcementRepository.getAvailableFields();
        //Act
        for (Announcement announcement:mockAnnouncements){
            controller.getAvailableFields();
        }
        List<List<Object>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
        //for (int i = 0; i < 10; i++) {
            //expected.get(0).add(0,mockAnnouncements.get(0).getTypeOfBusiness());

        //}
        expected.get(0).add(TypeOfBusiness.SELL);
        expected.get(0).add(TypeOfBusiness.RENT);
        expected.get(1).add("House");
        expected.get(2).add(3);


        assertIterableEquals(
                expected.get(0),
                availableFields.get(0));
        assertIterableEquals(
                expected.get(1),
                availableFields.get(1));
        assertIterableEquals(
                expected.get(2),
                availableFields.get(2));

    }

    /**
     * Gets announcements.
     */
    @Test
    void getAnnouncements() {
    }

    /**
     * Gets all visible announcements.
     */
    @Test
    void getAllVisibleAnnouncements() {
    }
}