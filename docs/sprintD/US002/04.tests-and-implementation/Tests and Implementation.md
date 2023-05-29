# US 002 - Publish announcement

# 4. Tests 

**Test 1:** Check if the announcement is created.



	  @Test
    void ensureAnnouncementIsCreated() {
        // Arrange
        boolean visible = true;
        float price = 1000.0f;
        float commission = 50.0f;
        TypeOfBusiness typeOfBusiness = TypeOfBusiness.SELL;
        Property property = new Property();

        Employee agent = new Employee("employee", 123456789, 123456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);

        // Act
        Announcement announcement = new Announcement(visible, price, commission, typeOfBusiness, property, agent);

        // Assert
        Assertions.assertEquals(visible, announcement.isVisible());
        Assertions.assertEquals(price, announcement.getPrice());
        Assertions.assertEquals(commission, announcement.getCommission());
        Assertions.assertEquals(typeOfBusiness, announcement.getTypeOfBusiness());
        Assertions.assertEquals(property, announcement.getProperty());
        Assertions.assertEquals(agent, announcement.getAgent());
    }

	

**Test 2:** Checks if the announcement is saved in the announcement repository

	 @Test
    public void testSave() {
        ArrayList<String> photographs = new ArrayList<>();
        String photo = "aa";
        photographs.add(photo);

        Employee agent = new Employee("emp1", 113456789, 113456789, "as", "employee@this.app", 1234567890, Role.AGENT, Agency.AGENCY1);

        AnnouncementRepository repository = new AnnouncementRepository();
        Announcement announcement = new Announcement(true, 1, 1.0f, TypeOfBusiness.SELL, new Land(1,new City("lisboa"),1,photographs), agent);
        assertTrue(repository.save(announcement));
    }


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class PublishAnnouncementController 

```java
 public void createAnnouncement(TypeOfBusiness sellOrRent, int posTypeOfProperty, int bedrooms, int bathrooms, int parkingSpaces,
        ArrayList<String> equipmentList,boolean hasBasement, boolean hasLoft, SunExposure sunExposure,
        int area, City location, int cityCentreDistance, float commission, float price, ArrayList photographs, String agentName){
        RegisterEmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

        // get the employee corresponding to the agent email
        String emailAdress = null;
        Employee agent = employeeRepository.findByEmail(emailAdress);

        agentName = String.valueOf(authenticationController.getCurrentSession());
        
```


## Class Announcemnet

```java
 public Announcement(boolean visible, float price, float commission, TypeOfBusiness typeOfBusiness, Property property, Employee agent) {
        this.setVisible(visible);
        this.setPrice(price);
        this.setCommission(commission);
        this.setTypeOfBusiness(typeOfBusiness);
        this.setProperty(property);
        this.setAgent(agent);
    }

```

# 6. Integration and Demo 

N/A

# 7. Observations

N/A




