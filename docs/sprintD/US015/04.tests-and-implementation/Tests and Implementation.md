# US 015 - List all booking requests managed by agent

# 4. Tests 

**Tests for sortVisitsAscending:** 

    ```java

     @DisplayName("Ensure sorting a null array returns null")
    @Test
    public void ensureSortingNullArrayReturnsNull() {
        // Act
        Visit[] visits = VisitRepository.sortVisitsAscending(null);

        // Assert
        assertNull(visits); // check result is null

    }


    @DisplayName("Ensure sorting an array with empty array works")
    @Test
    public void ensureSortingAnEmptyArrayWorks() {
       
        Visit[] visits = {};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {};

        assertArrayEquals(expected, result);
       
    }

    @DisplayName("Ensure sorting an array with one element works")
    @Test
    public void ensureSortingOneElementArrayWorks() {
    
        LocalDate date = LocalDate.now();

        LocalTime time = LocalTime.now();

        Visit visit = new Visit(date, time, true);

        Visit[] visits = {visit};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit};

        assertArrayEquals(expected, result);


    }

    @DisplayName("Ensure sorting an array with two (already sorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoSortedElementsWorks() {
       
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.plusDays(2);

        LocalTime time1 = LocalTime.of(10:0:0);

        LocalTime time2 = LocalTime.of(11:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date2, time2, true);

        Visit[] visits = {visit1, visit2};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }


    @DisplayName("Ensure sorting an array with two (unsorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoUnsortedElementsWorks() {
        
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.plusDays(2);

        LocalTime time1 = LocalTime.of(10:0:0);

        LocalTime time2 = LocalTime.of(11:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date2, time2, true);

        Visit[] visits = {visit2, visit1};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with two (sorted) elements works where they have the same date different time.")
    @Test
    public void ensureSortingArrayWithTwoSortedElementsWorksWhereTheyHaveSameDateDifferentTime() {
        
        LocalDate date1 = LocalDate.now();

        LocalTime time1 = LocalTime.of(10:0:0);

        LocalTime time2 = LocalTime.of(11:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date1, time2, true);

        Visit[] visits = {visit1, visit2};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }


    @DisplayName("Ensure sorting an array with two (unsorted) elements works where they have the same date different time.")
    @Test
    public void ensureSortingArrayWithTwoUnsortedElementsWorksWhereTheyHaveSameDateDifferentTime() {
        
        LocalDate date1 = LocalDate.now();

        LocalTime time1 = LocalTime.of(10:0:0);

        LocalTime time2 = LocalTime.of(11:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date1, time2, true);

        Visit[] visits = {visit2, visit1};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with two (sorted) elements works where they have the same time different date.")
    @Test
    public void ensureSortingArrayWithTwoSortedElementsWorksWhereTheyHaveSameTimeDifferentDate() {
        
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.plusDays(2);

        LocalTime time1 = LocalTime.of(10:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date2, time1, true);

        Visit[] visits = {visit1, visit2};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }


    @DisplayName("Ensure sorting an array with two (unsorted) elements works where they have the same time different date.")
    @Test
    public void ensureSortingArrayWithTwoUnsortedElementsWorksWhereTheyHaveSameTimeDifferentDate() {
        
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.plusDays(2);

        LocalTime time1 = LocalTime.of(10:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date2, time1, true);

        Visit[] visits = {visit2, visit1};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }



    @DisplayName("Ensure sorting an array with two equal elements works.")
    @Test
    public void ensureSortingArrayWithTwoEqualElementsWorks() {
        
        LocalDate date1 = LocalDate.now();

        LocalTime time1 = LocalTime.of(10:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date1, time1, true);

        Visit[] visits = {visit1, visit2};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with several unordered elements works.")
    @Test
    public void ensureSortingArrayWithSeveralUnsortedElementsWorks() {
       
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.plusDays(2);

        LocalDate date3 = LocalDate.plusDays(1);

        LocalDate date4 = LocalDate.plusDays(3);

        LocalTime time1 = LocalTime.of(10:0:0);

        LocalTime time2 = LocalTime.of(11:0:0);

        LocalTime time3 = LocalTime.of(13:0:0);

        LocalTime time4 = LocalTime.of(14:0:0);

        Visit visit1 = new Visit(date1, time1, true);

        Visit visit2 = new Visit(date2, time2, true);

        Visit visit3 = new Visit(date3, time3, true);

        Visit visit4 = new Visit(date4, time4, true);

        Visit[] visits = {visit4, visit3, visit2, visit1};

        Visit[] result = VisitRepository.sortVisitsAscending(visits);

        Visit[] expected = {visit1, visit3, visit2, visit4};

        assertArrayEquals(expected, result);
    }

```
    


# 5. Construction (Implementation)


## Class ListAllBookingsRequestsToAgentUI 

```java
public class ListAllBookingsRequestsToAgentUI implements Runnable {


    private ListAllBookingsRequestsToAgentController controller = new ListAllBookingsRequestsToAgentController();

    @Override
    public void run() {

    }


}
```


## Class ListAllBookingsRequestsToAgentController

```java
public class ListAllBookingsRequestsToAgentController {

}

```

## Class Repositories

```java
public class Repositories {

    VisitRepository visitRepository = new VisitRepository();

    public static Repositories getInstance() 
    {
    
    }

    public VisitRepository getVisitRepository() {
       
    }

}

```


## Class VisitRepository

```java
public class VisitRepository {

   private final List<Visit> visits = new ArrayList<>();


    public List<Visit> getAllVisitsByAgentAndDateRange(Agent agent, Date start, Date end){}

    public List<Visit> sortVisitsAscending(List<Visit> visits){}

}

```

## Class Util

```java
public class Util {

  public String getChosenSortingAlgorithm(){}

}

```

## Class VisitMapper

```java
public class VisitMapper {

  public List<VisitDTO> toDTOlist(List<Visit> visits){}

  public VisitDTO toDTO(Visit visit){}

}

```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.


# 7. Observations

* N/A





