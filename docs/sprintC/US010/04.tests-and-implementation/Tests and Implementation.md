# US 010 - As a client, I place an order to purchase the property, submitting the order amount

# 4. Tests 

**Test 1:** Ensure adding a negative order amount fails 

@DisplayName("Ensure adding a negative order amount fails")
@Test
void EnsureAddingNegativeOrderAmountFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            Order order1 = new Order(123, announcementDTO);
            order1.setOrderAmount(-123);
        });
    }

**Test 2:**  

	


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class PlaceOrderToBuyPropertyController

```java
public class PlaceOrderToBuyPropertyController {

    private AnnouncementRepository announcementRepository = new AnnouncementRepository();
    private AnnouncementMapper announcementMapper;
    private PlaceOrderToBuyPropertyRepository orderRepository;

    public PlaceOrderToBuyPropertyController(PlaceOrderToBuyPropertyRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<AnnouncementDTO> announcementDTOList() {

        List<Announcement> announcements = announcementRepository.getAllVisibleAnnouncements();

        return AnnouncementMapper.convert(announcements);
    }

    public String createOrder(Double orderAmount, Integer posAnnouncement) {

        Order newOrder = new Order(orderAmount, AnnouncementMapper.getAnnouncementDTOById(posAnnouncement));

        try {

            this.orderRepository.saveOrder(newOrder);
            return newOrder.toString();

        } catch (Exception e) {

            throw new IllegalArgumentException(e.getMessage().toString());
        }
    }
}

```

## Class PlaceOrderToBuyPropertyUI

```java
public class PlaceOrderToBuyPropertyUI implements Runnable {

    private PlaceOrderToBuyPropertyController controller = new PlaceOrderToBuyPropertyController(new PlaceOrderToBuyPropertyRepository());

    public PlaceOrderToBuyPropertyUI(PlaceOrderToBuyPropertyController controller) {
        //this.controller = controller;
    }

    @Override
    public void run() {

        boolean success = true;

        while(success) {

            //List of anouncements
            List<AnnouncementDTO> x = this.controller.announcementDTOList();
            Utils.showList(x, "Anouncements");
            Integer posAnouncement = Utils.readIntegerFromConsole("Select the anouncement with the desire property");

            //OrderAmount
            Double orderAmount = Utils.readDoubleFromConsole("Insert order amount: ");
            
            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    this.controller.createOrder(orderAmount, posAnouncement);
                    success = false;

                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                System.out.println("Order amount: " + orderAmount);
                System.out.println("Selected Announcement:\n" + posAnouncement.toString());

            } else {

                System.err.println("Operation Canceled");
            }
        }
    }
}

```

## Class PlaceOrderToBuyPropertyRepository

```java
public class PlaceOrderToBuyPropertyRepository {

    public static List<Order> orderList = new ArrayList<>();

    public boolean saveOrder(Order order) {

        if(validateOrder(order)) {

            return addOrder(order);
        }
        return false;
    }

    public boolean addOrder(Order order) {

        if(order != null && validateOrder(order)) {

            return this.orderList.add(order);
        }
        return false;
    }

    public boolean validateOrder(Order order) {

        for(Order order1: orderList) {

            if(order.equals(order)) {

                return false;
            }
        }
        return true;
    }

    public List<Order> getOrderList() {

        return new ArrayList<>(orderList);
    }

    public String getOrdersListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Order order: this.orderList) {

            stringBuilder.append("-").append(order.toString()).append("\n");
        }
        return stringBuilder.toString();
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

        this.orderAmount = setOrderAmount(orderAmount);
        this.announcementDTO = setAnnouncementDTO(announcementDTO);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public AnnouncementDTO getAnnouncementDTO() {
        return announcementDTO;
    }

    public static boolean isStatus() {
        return status;
    }

    public double setOrderAmount(double orderAmount) {

        if (orderAmount < 0) {

            throw new IllegalArgumentException("Order amount must be positive");
        }

        return this.orderAmount;
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return this.announcementDTO = announcementDTO;
    }

    public static void setStatus(boolean status) {
        Order.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderAmount=").append(orderAmount);
        sb.append(", announcementDTO=").append(announcementDTO);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderAmount, orderAmount) == 0 && Objects.equals(announcementDTO, order.announcementDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAmount, announcementDTO);
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
        this.price = price;
        this.typeOfBusiness = typeOfBusiness;
        this.property = property;
        this.agent = agent;
    }

    public AnnouncementDTO() {

    }

    public AnnouncementDTO(Announcement announcement) {

        this.price = announcement.getPrice();
        this.typeOfBusiness = announcement.getTypeOfBusiness();
        this.property = announcement.getProperty();
        this.agent = announcement.getAgent();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AnnouncementDTO{");
        sb.append("price=").append(price);
        sb.append(", typeOfBusiness=").append(typeOfBusiness);
        sb.append(", property=").append(property);
        sb.append(", agent=").append(agent);
        sb.append(", announcementDTOs=").append(announcementDTOs);
        sb.append('}');
        return sb.toString();
    }

    public AnnouncementDTO getAnnouncement() {

        return null;
    }
}

```

## Class AnnouncementMapper

```java
public class AnnouncementMapper {

    private static List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

    public static List<AnnouncementDTO> convert(List<Announcement> announcementList) {

        return announcementList.stream().map(AnnouncementDTO::new).collect(Collectors.toList());
    }

    public List<AnnouncementDTO> toDto(List<Announcement> announcementList) {

        List<AnnouncementDTO> dtoList = new ArrayList<>();

        for (Announcement announcement : announcementList) {

            dtoList.add(toDtoAnnouncement(announcement));
        }
        return dtoList;
    }

    public List<AnnouncementDTO> getAllAnnouncements() {

        List<AnnouncementDTO> allAnnouncements = new ArrayList<>();

        for (AnnouncementDTO announcementDTO : allAnnouncements) {

            allAnnouncements.add(announcementDTO.getAnnouncement());
        }
        return allAnnouncements;
    }

    public static AnnouncementDTO getAnnouncementDTOById(int id) {

        if (id >= 0 && id < announcementDTOList.size()) {

            return announcementDTOList.get(id);
        }

        return null;
    }

    public AnnouncementDTO toDtoAnnouncement(Announcement announcement) {
        return new AnnouncementDTO();
    }
}

```

## Class AnnouncementRepository

```java
public class AnnouncementRepository {
    
    List<Announcement> announcements = new ArrayList<>();
    
    public boolean save(Announcement announcement) {
        return announcements.add(announcement.getAnnouncement());
    }
    
    public boolean createAnnouncement (Announcement announcement) {

        if(validateAnnouncement(announcement)) {

            return addAnnouncement(announcement);
        }
        return false;
    }
    
    public boolean validateAnnouncement(Announcement announcement) {
        for(Announcement i : announcements) {
            if(announcement.equals(i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean addAnnouncement(Announcement announcement) {

        if(announcement != null && validateAnnouncement(announcement)) {

            return announcements.add(announcement.getAnnouncement());
        }
        return false;
    }
    
    public List<Announcement> getAllVisibleAnnouncements() {
        List<Announcement> allVisibleAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            if (announcement.isVisible()){
                allVisibleAnnouncements.add(announcement.getAnnouncement());
            }
        }
        return allVisibleAnnouncements;
    }
    
    public List<List<Object>> getAvailableFields(){
        List<List<Object>> availableFields = new ArrayList<>();
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());
        availableFields.add(new ArrayList<>());

        //TO-FIX
        for(Announcement announcement : announcements){
            if ( announcement != null && announcement.isVisible()){
                if (!availableFields.get(0).contains(announcement.getTypeOfBusiness())){
                    availableFields.get(0).add(announcement.getTypeOfBusiness());
                }
                if (!availableFields.get(1).contains(announcement.getProperty().getClass().getSimpleName().toUpperCase())){
                    availableFields.get(1).add(announcement.getProperty().getClass().getSimpleName().toUpperCase());
                }
                if (!announcement.getProperty().getClass().getSimpleName().equals("Land") && !availableFields.get(2).contains(announcement.getProperty().getNumberOfBedrooms())){
                    availableFields.get(2).add(announcement.getProperty().getNumberOfBedrooms());
                }
            }
        }
        return availableFields;
    }
    
    public List<Announcement> getAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfBedrooms){
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for(Announcement announcement : announcements){
            Announcement gotAnnouncement = announcement.getAnnouncement(typeOfBusiness, typeOfProperty, numberOfBedrooms);
            if(gotAnnouncement != null){
                matchingAnnouncements.add(gotAnnouncement);
            }
        }
        return matchingAnnouncements;
    }

}

```

# 6. Integration and Demo 


* A new option on the client menu options was added.


# 7. Observations

* N/A





