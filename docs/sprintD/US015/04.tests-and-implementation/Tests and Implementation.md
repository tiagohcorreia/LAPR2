# US 015 - List all booking requests managed by agent

# 4. Tests 

**Tests for Branch Name:** 

    @DisplayName("Ensure name equal 40 chars works")
    @Test
    void EnsureNameEqual40CharsWorks() {

        assertDoesNotThrow( ()->{

          Branch b = new Branch();

         b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");

        });
    }

    @DisplayName("Ensure name bigger than 40 chars fails")
    @Test
    void EnsureNameBiggerThan40CharsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqa");


        });
    }

    @DisplayName("Ensure name smaller than 40 chars works")
    @Test
    void EnsureNameSmallerThan40CharsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setName("a");

        });
    }

**Tests for Branch Phone Number:**



    @DisplayName("Ensure phone number with 9 digits works")
    @Test
    void EnsurePhoneNumberWith9DigitsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setPhoneNumber(981321232);

        });
    }


    @DisplayName("Ensure phone number with 7 digits fails")
    @Test
    void EnsurePhoneNumberWith7DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setPhoneNumber(9813232);

        });
    }


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





