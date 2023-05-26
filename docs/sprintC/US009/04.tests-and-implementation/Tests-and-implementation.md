# US 009 - Sends a message to schedule a visit

# 4. Tests 

**Pre-Tests:** To simplify and not repeat the same code in all tests, I created a "Schedule" that will run before each test.

	Schedule schedule;
    Property property;
    Announcement announcement;
    AnnouncementDTO announcementDTO;
    City city;

    @BeforeEach
    void setup(){
        ArrayList<String> photographs = new ArrayList<String>();
        photographs.add("photo1");
        city=new City("Porto");
        LocalDate day = LocalDate.of(2023, 06, 20);
        LocalTime beginHour = LocalTime.of(12,30,0);
        LocalTime endHour = LocalTime.of(13,30,0);
        property= new Land(123,city,123,photographs);
        pt.ipp.isep.dei.esoft.project.domain.model.Employee e1 = new pt.ipp.isep.dei.esoft.project.domain.model.Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
        announcement= new Announcement(true,1231,121,TypeOfBusiness.SELL,property,e1);
        announcementDTO = new AnnouncementDTO(123,TypeOfBusiness.SELL,property,e1);
        schedule= new Schedule("vitor",1234567891,announcementDTO,day,beginHour,endHour,"no more notes",false);
    }

**Test 1:** Check if empty name fails

	@Test
    @DisplayName("Ensure that a schedule without a name fails")
    void EnsureEmptyNameFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setName("");
        });
    }

**Test 2:** Check if null name fails

	 @DisplayName("Ensure Null Name Fails")
    @Test
    void EnsureNullNameFails() {

        assertThrows(NullPointerException.class, () -> {
            schedule.setName(null);
        });
    }

**Test 3:** Check if negative phone number fails

	 @DisplayName("Ensure Negative Phone Number Fails")
    @Test
    void EnsureNegativePhoneNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setPhoneNumber(-12345678);
        });
    }

**Test 4:** Check phone number with less than 10 digits fails

	 @DisplayName("Ensure Telephone Number with 9 digits fails")
    @Test
    void EnsureTelephoneNumberWith9DigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setPhoneNumber(111111111);

        });
    }
**Test 5:** Check if end hour of a visit before begin hour fails. 

	@DisplayName("Ensure endHour before beginHour fails")
    @Test
    void EnsurEndHourBeforeBeginHourFails() {

        assertThrows(IllegalArgumentException.class, () -> {
            schedule.setEndHour(LocalTime.of(10,30,0));
        });
    }




# 5. Construction (Implementation)

## Class AnnouncementMapper

```java
public class Schedule {
    private String name;
    private int phoneNumber;
    private AnnouncementDTO announcementDTO;
    private LocalDate day;
    private LocalTime beginHour;
    private LocalTime endHour;

    private String note;
    private boolean status; //the schedule needs to be confirmed (true)

    public Schedule(String name, int phoneNumber, AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginHour,LocalTime endHour, String note, boolean status) {
        this.name = setName(name);
        this.phoneNumber = setPhoneNumber(phoneNumber);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
        this.day = setDay(day);
        this.beginHour = setBeginHour(beginHour);
        this.endHour = setEndHour(endHour);
        this.note=setNote(note);
        this.status=setStatus(status);
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getBeginHour() {
        return beginHour;
    }
    public LocalTime getEndHour() {
        return endHour;
    }

    public String getNote() {
        return note;
    }
    public boolean getStatus(){
        return status;
    }

    public String setName(String name) {
        if (name == null) {

            throw new NullPointerException("Your name can't be null, please insert again.");

        } else if (name.trim().isEmpty()) {

            throw new IllegalArgumentException("Your name must be filled.");

        }
        return this.name = name;
    }
    public Integer setPhoneNumber(int phoneNumber) {
        if (phoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (Integer.toString(phoneNumber).trim().length() != 10) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");
        }
        return this.phoneNumber = phoneNumber;
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    public LocalDate setDay(LocalDate day) {
        if (day.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("You can’t schedule a visit for a day in the past.");
        }
        return this.day = day;
    }

    public LocalTime setBeginHour(LocalTime beginHour) {
        return this.beginHour = beginHour;
    }
    public LocalTime setEndHour(LocalTime endHour) {
        if (endHour.isBefore(beginHour)){
            throw new IllegalArgumentException("The time the visit ends must be after the time the visit begins.");
        }
        return this.endHour = endHour;
    }

    public String setNote(String note) {
        return this.note = note;
    }

    public boolean setStatus(boolean status) {
        return this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return phoneNumber == schedule.phoneNumber && day == schedule.day && note == schedule.note && beginHour == schedule.beginHour && endHour == schedule.endHour && Objects.equals(name, schedule.name) && Objects.equals(announcementDTO, schedule.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, announcementDTO, day, beginHour,endHour, note);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", phoneNumber= " + phoneNumber +
                ", announcementDTO= " + announcementDTO +
                ", day= " + day +
                ", beginHour= " + beginHour +
                ", endHour= " + endHour +
                ", note= " + note +
                '}';
    }

}

```
## Class ScheduleVisitController 

```java
public class ScheduleVisitController {

    private ScheduleRepository scheduleRepository;
    private AnnouncementRepository announcementRepository = new AnnouncementRepository();
    private AnnouncementMapper announcementMapper;

    public ScheduleVisitController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.getAllVisibleAnnouncements();

        return AnnouncementMapper.convert(announcements);
    }

    public String createSchedule(String name, int phoneNumber, Integer posAnnouncement, LocalDate day, LocalTime beginHour, LocalTime endHour, String note) {
        Schedule schedule = new Schedule(name,phoneNumber, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement),day,beginHour,endHour,note,false);

        try {

            this.scheduleRepository.saveSchedule(schedule);
            return schedule.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }

    public boolean validateScheduleHour(AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginTime, LocalTime endTime) {
        boolean isOverlap = false;
        for(Schedule schedule : scheduleRepository.getScheduleList()) {

            if (beginTime.isBefore(schedule.getEndHour()) && endTime.isAfter(schedule.getBeginHour())) {
                isOverlap = true;
                throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");

            } else if (beginTime.equals(schedule.getBeginHour()) || endTime.equals(schedule.getEndHour())) {
                isOverlap = true;

                throw new IllegalArgumentException("That hour is already scheduled, please insert data again.");
            }

            if (schedule.getAnnouncementDTO().equals(announcementDTO) && schedule.getDay().equals(day) && isOverlap==false) {
                return true;
            }
        }
        return true;
    }
    public AnnouncementDTO getAnnouncementDTO(int posAnnouncement) {
        return AnnouncementMapper.getAnnouncementDTOById(posAnnouncement);
    }
}
```


## Class ScheduleVisitUI

```java
public class ScheduleVisitUI implements Runnable{
    private ScheduleVisitController controller= new ScheduleVisitController(new ScheduleRepository());

    public ScheduleVisitUI(ScheduleVisitController scheduleVisitController) {
    }

    @Override
    public void run() {
        boolean success= true;
        while (success==true){

            //name
            String name= Utils.readLineFromConsole("Insert your name:");

            //phoneNumber
            int phoneNumber=Utils.readIntegerFromConsole("Insert your phone number:");

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.announcementDTOList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property");


            //Day
            String stringDay = Utils.readLineFromConsole("Insert the day you want to schedule: (yyyy-mm-dd)");
            LocalDate day = LocalDate.parse(stringDay);


            //Begin Hour
            System.out.println("Insert the time you want to start the visit");
            int beginHour=Utils.readIntegerFromConsole("Hour :");
            int begunMin=Utils.readIntegerFromConsole("Minute:");
            int beginSec=Utils.readIntegerFromConsole("Second :");
            LocalTime beginTime = LocalTime.of(beginHour,begunMin,beginSec);

            //End Hour
            System.out.println("Insert the time you want to end the visit");
            int endHour=Utils.readIntegerFromConsole("Hour :");
            int endMin=Utils.readIntegerFromConsole("Minute :");
            int endSec=Utils.readIntegerFromConsole("Second:");
            LocalTime endTime = LocalTime.of(endHour,endMin,endSec);

            //Extra note
            String note= Utils.readLineFromConsole("Insert a note for the agent:");

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {
                    if (controller.validateScheduleHour(controller.getAnnouncementDTO(posAnouncement),day,beginTime,endTime)==true){
                        this.controller.createSchedule(name,phoneNumber, posAnouncement,day,beginTime,endTime, note);
                        System.out.println("Schedule message confirmed");
                        success = false;
                    } else{
                        System.out.println("Please insert Schedule data again");
                    }


                } catch (IllegalArgumentException e) {

                    System.err.println(e.getMessage());

                } catch (NullPointerException e) {

                    System.err.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println(e.getMessage());

                }




            } else {

                System.err.println("Operation Canceled");
            }

        }
    }
}

```
## Class ScheduleRepository

```java
public class ScheduleRepository {
    public static List<Schedule> scheduleList = new ArrayList<>();
    public boolean saveSchedule(Schedule schedule){
        if(validateSchedule(schedule)) {
            return addSchedule(schedule);
        }
        return false;
    }
    public boolean validateSchedule(Schedule schedule){
        for(Schedule schedule1: scheduleList) {

            if(schedule.equals(schedule)) {
                return false;
            }
        }
        return true;
    }

    public boolean addSchedule(Schedule schedule){
        if(schedule != null && validateSchedule(schedule)) {

            return this.scheduleList.add(schedule);
        }
        return false;
    }

    public List<Schedule> getScheduleList() {

        return new ArrayList<>(scheduleList);
    }

    public String getScheduleListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Schedule schedule: this.scheduleList) {

            stringBuilder.append("-").append(schedule.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
```

## Class AnnouncementDTO

```java
public class AnnouncementDTO {
    private float price;
    private TypeOfBusiness typeOfBusiness;
    private Property property;
    private Employee agent;

    /**
     * The Announcement dt os.
     */
    List<AnnouncementDTO> announcementDTOs = new ArrayList<>();


    /**
     * Instantiates a new Announcement dto.
     *
     * @param price          the price
     * @param typeOfBusiness the type of business
     * @param property       the property
     * @param agent          the agent
     */
    public AnnouncementDTO(float price, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.price = price;
        this.typeOfBusiness = typeOfBusiness;
        this.property = property;
        this.agent = agent;
    }

    /**
     * Instantiates a new Announcement dto.
     */
    public AnnouncementDTO() {

    }

    /**
     * Instantiates a new Announcement dto.
     *
     * @param announcement the announcement
     */
    public AnnouncementDTO(Announcement announcement) {

        this.price = announcement.getPrice();
        this.typeOfBusiness = announcement.getTypeOfBusiness();
        this.property = announcement.getProperty();
        this.agent = announcement.getAgent();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Announcement {");
        sb.append("Price: ").append(price);
        sb.append(", Type Of Business: ").append(typeOfBusiness);
        sb.append(", Property: ").append(property);
        sb.append(", Agent: ").append(agent);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Gets announcement.
     *
     * @return the announcement
     */
    public AnnouncementDTO getAnnouncement() {

        return null;
    }

}
```

## Class AnnouncementMapper

```java
public class AnnouncementMapper {

    private static List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

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

```
# 6. Integration and Demo 

* A new option on the client menu options was added. (option 2)


# 7. Observations

N/A





