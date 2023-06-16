# US 010 - As a client, I place an order to purchase the property, submitting the order amount

# 4. Tests

**Test 1:** Ensure adding a negative order amount fails

@Test
void EnsureAddingNegativeOrderAmountFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            Order order1 = new Order(123, announcementDTO);
            order1.setOrderAmount(-123);
        });
    }

**Test 2:** Ensure duplicate order fails

@Test
void EnsureAddingNegativeOrderAmountFails() {

        assertThrows(DuplicateDataException.class, () -> {

            Branch branch = new Branch();
            Employee agent = new Employee("Employee", 987654321, 987654321, "Porto", "employee@this.app", "9876543210", Role.AGENT, branch);
            Location location = new Location();
            Property property = new Land(12, location, 12, new ArrayList<>());
            AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, agent);
            boolean status = false;

            Order o1 = new Order(123, announcementDTO, status);
            placeOrderToBuyPropertyRepository.validateOrder(o1);

            Order o2 = new Order(123, announcementDTO, status);
            placeOrderToBuyPropertyRepository.validateOrder(o2);
        });
    }

**Test 3:** Ensure validate works

@Test
void EnsureValidateWorks() {

            Branch branch = new Branch();
            Employee agent = new Employee("Employee", 987654321, 987654321, "Porto", "employee@this.app", "9876543210", Role.AGENT, branch);
            Location location = new Location();
            Property property = new Land(12, location, 12, new ArrayList<>());
            AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, agent);
            boolean status = false;

            Order o1 = new Order(123, announcementDTO, status);
            placeOrderToBuyPropertyRepository.validateOrder(o1);

            assertTrue(validateOrder(o1));
    }

**Test 4:** Ensure add order works

@Test
void EnsureAddOrderWorks() {

            Branch branch = new Branch();
            Employee agent = new Employee("Employee", 987654321, 987654321, "Porto", "employee@this.app", "9876543210", Role.AGENT, branch);
            Location location = new Location();
            Property property = new Land(12, location, 12, new ArrayList<>());
            AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, agent);
            boolean status = false;

            Order o1 = new Order(123, announcementDTO, status);

            assertFalse(addOrder(o1));
    }

**Test 5:** Ensure save order works

@Test
void EnsureValidateWorks() {

            Branch branch = new Branch();
            Employee agent = new Employee("Employee", 987654321, 987654321, "Porto", "employee@this.app", "9876543210", Role.AGENT, branch);
            Location location = new Location();
            Property property = new Land(12, location, 12, new ArrayList<>());
            AnnouncementDTO announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, agent);
            boolean status = false;

            Order o1 = new Order(123, announcementDTO, status);

            assertFalse(save(o1));
    }

# 5. Construction (Implementation)

## Class PlaceOrderToBuyPropertyController

```java
public class PlaceOrderToBuyPropertyController {

    private AnnouncementRepository announcementRepository = new AnnouncementRepository();
    private AnnouncementMapper announcementMapper;
    private PlaceOrderToBuyPropertyRepository orderRepository;

    public PlaceOrderToBuyPropertyController(PlaceOrderToBuyPropertyRepository orderRepository) {

    }

    public List<AnnouncementDTO> announcementDTOList() {

    }

    public String createOrder(Double orderAmount, Integer posAnnouncement) {

    }
}

```

## Class PlaceOrderToBuyPropertyUI

```java
public class PlaceOrderToBuyPropertyUI implements Runnable {

    private PlaceOrderToBuyPropertyController controller = new PlaceOrderToBuyPropertyController(new PlaceOrderToBuyPropertyRepository());

    public PlaceOrderToBuyPropertyUI(PlaceOrderToBuyPropertyController controller) {

    }

    @Override
    public void run() {


    }
}


```

## Class PlaceOrderToBuyPropertyRepository

```java
public class PlaceOrderToBuyPropertyRepository {

    public static List<Order> orderList = new ArrayList<>();

    public boolean saveOrder(Order order) {

    }

    public boolean addOrder(Order order) {

    }

    public boolean validateOrder(Order order) {

    }

    public List<Order> getOrderList() {

    }

    public String getOrdersListAsString() {

    }
}

```

## Class Order

```java
public class Order {

    private double orderAmount;
    private AnnouncementDTO announcementDTO;
    private static boolean status = false;     //True - the order was accepted   False - the order is not accepted

    public Order(double orderAmount, AnnouncementDTO announcementDTO) {

    }

    public double getOrderAmount() {

    }

    public AnnouncementDTO getAnnouncementDTO() {

    }

    public static boolean isStatus() {

    }

    public double setOrderAmount(double orderAmount) {

    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {

    }

    public static void setStatus(boolean status) {

    }

    @Override
    public String toString() {

    }

    @Override
    public boolean equals(Object o) {

    }

    @Override
    public int hashCode() {

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

    List<AnnouncementDTO> announcementDTOs = new ArrayList<>();

    public AnnouncementDTO(float price, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {

    }

    public AnnouncementDTO() {

    }

    public AnnouncementDTO(Announcement announcement) {


    }

    @Override
    public String toString() {

    }

    public AnnouncementDTO getAnnouncement() {

    }
}

```

## Class AnnouncementMapper

```java
public class AnnouncementMapper {

    private static List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

    public static List<AnnouncementDTO> convert(List<Announcement> announcementList) {

    }

    public List<AnnouncementDTO> toDto(List<Announcement> announcementList) {

    }

    public List<AnnouncementDTO> getAllAnnouncements() {

    }

    public static AnnouncementDTO getAnnouncementDTOById(int id) {

    }

    public AnnouncementDTO toDtoAnnouncement(Announcement announcement) {

    }
}

```

## Class AnnouncementRepository

```java
public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public boolean save(Announcement announcement) {

    }

    public boolean createAnnouncement(Announcement announcement) {

    }

    public boolean validateAnnouncement(Announcement announcement) {

    }

    public boolean addAnnouncement(Announcement announcement) {

    }

    public List<Announcement> getAllVisibleAnnouncements() {

    }

    public List<List<Object>> getAvailableFields() {

    }

    public List<Announcement> getAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms) {

    }

}

```

## Class Repositories

```java
public class Repositories {

    AnnouncementRepository announcementRepository = new AnnouncementRepository();

    public AnnouncementRepository getAnnouncementRepository() {

    }

}

```

# 6. Integration and Demo

* A new option on the client menu options was added.

# 7. Observations

* N/A





