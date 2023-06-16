# US 002 - Publish announcement

# 4. Tests 

**Test 1:** Check if the announcement is created.



	  @Test
        @Test
    public void ensureAnnouncementIsCreated() {

        Location location = new Location(0, "violets", new City("porto"), 12345);
        Branch branch = new Branch();
        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", "1234567890", Role.AGENT, branch);
        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);
        LocalDate date = LocalDate.of(2024, 4, 27);
        AnnouncementStatus status = AnnouncementStatus.PUBLISHED;
        float price = 100000;
        float commission = 5000;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Land(1000, location, 1000, new ArrayList<>());

        Announcement announcement = new Announcement(date, status, price, commission, typeOfBusiness, property, agent, owner);

        assertNotNull(announcement);
    }




**Test 2:** Verify that commission cannot be negative

	 @Test
    public void ensureCommissionCannotBeNegative() {
        Announcement announcement = new Announcement();
        Assertions.assertThrows(IllegalArgumentException.class, () -> announcement.setCommission(-100));
    }


**Test 3:** Checks if the notification was sent to the owner

public class NotificationServiceTest {

    private NotificationService notificationService;

    private static final String RECIPIENT = "Nilsa Gil";
    private static final String SUBJECT = "ANNOUNCEMENT NOTIFICATION";
    private static final String MESSAGE = "Dear client, your announcement was published. ";

    @BeforeEach
    public void setUp() {
        notificationService = new NotificationService();
    }

    @Test
    public void ensureSendNotificationWritesToFile(@TempDir File tempDir) throws IOException {
        File tempFile = new File(tempDir, "notifications.txt");

        notificationService.sendNotification(RECIPIENT, SUBJECT, MESSAGE);

        String expected = String.format("[*]%nRecipient: %s%nSubject: %s%nMessage: %s%n%n", RECIPIENT, SUBJECT, MESSAGE);

        writeToFile(tempFile, expected);

        String actual = readNotificationFromFile(tempFile);

        Assertions.assertEquals(expected, actual);
    }

    private void writeToFile(File file, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    private String readNotificationFromFile(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("The file is empty: " + file.getAbsolutePath());
            }

            while (line != null) {
                sb.append(line).append("\n");
                line = reader.readLine();
            }
        }

        return sb.toString();
    }
}



# 5. Construction (Implementation)


## Class PublishAnnouncementController 

```java
 public void createAnnouncement(LocalDate date, TypeOfBusiness sellOrRent, int posTypeOfProperty, int bedrooms, int bathrooms, int parkingSpaces,
        ArrayList<String> equipmentList, boolean hasBasement, boolean hasLoft, SunExposure sunExposure,
        int area, Location location, int cityCentreDistance, float commission, float price, ArrayList photographs, Employee agentName, Client owner, int rentalMonths ) {
    

        if (sellOrRent == TypeOfBusiness.SELL) {
        Property property = createProperty(posTypeOfProperty, area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
        Announcement announcement = new Announcement(date, AnnouncementStatus.PUBLISHED, commission, price, sellOrRent, property, agentName, owner);
        this.announcementRepository.createAnnouncement(announcement);
        this.announcementRepository.writeObject();

        } else if (sellOrRent == TypeOfBusiness.RENT) {
        if (rentalMonths != 0 && rentalMonths > 0) {

        Property property = createProperty(posTypeOfProperty, area, location, cityCentreDistance, photographs, bedrooms, bathrooms, parkingSpaces, equipmentList, hasBasement, hasLoft, sunExposure);
        Announcement announcement = new Announcement(date, AnnouncementStatus.PUBLISHED, commission, price, sellOrRent, property, agentName, owner, rentalMonths);
        this.announcementRepository.createAnnouncement(announcement);
        this.announcementRepository.writeObject();

        }
        }
        }
```


## Class Announcemnet

```java
  public Announcement(LocalDate date, AnnouncementStatus status, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent, Client owner) {
        this.setDate(date);
        this.setStatus(status);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
        this.setOwner(owner);
        }

public Announcement(LocalDate date, AnnouncementStatus status, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent, Client owner, int numberOfMonthsRent) {
        this.setDate(date);
        this.setStatus(status);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
        this.setOwner(owner);
        this.setNumberOfMonthsRent(numberOfMonthsRent);
        }

```

## Class NotificationService
```java
 public class NotificationService implements Serializable {
            private static final long serialVersionUID = 1L;
            private static final String NOTIFICATION_FILE = "notifications.txt";

            public void sendNotification(String recipient, String subject, String message) {
                String formattedMessage = formatMessage(recipient, subject, message);
                saveNotificationToFile(formattedMessage);
            }

            private String formatMessage(String recipient, String subject, String message) {
                LocalDateTime timestamp = LocalDateTime.now();
                return String.format("[%s]\nRecipient: %s\nSubject: %s\nMessage: %s\n\n", timestamp, recipient, subject, message);
            }

            private void saveNotificationToFile(String formattedMessage) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTIFICATION_FILE, true))) {
                    writer.write(formattedMessage);
                    System.out.println("Notification saved to file: " + NOTIFICATION_FILE);
                } catch (IOException e) {
                    System.out.println("Failed to save notification to file: " + e.getMessage());
                }
            }


```

# 6. Integration and Demo 

N/A

# 7. Observations

N/A




