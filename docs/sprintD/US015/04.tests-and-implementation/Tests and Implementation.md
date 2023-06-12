# US 015 - List all booking requests managed by agent

# 4. Tests 

**Tests for sortVisitsAscending:** 

    ```java

     @DisplayName("Ensure sorting a null array returns null")
    @Test
    public void ensureSortingNullArrayReturnsNull() {
        // Act
        Employee[] employees = EmployeeRepository.sortEmployeesAlphabetically(null);

        // Assert
        assertNull(employees); // check result is null

    }


    @DisplayName("Ensure sorting an array with empty array works")
    @Test
    public void ensureSortingAnEmptyArrayWorks() {
       
        Employee[] employees = {};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {};

        assertArrayEquals(expected, result);
       
    }

    @DisplayName("Ensure sorting an array with one element works")
    @Test
    public void ensureSortingOneElementArrayWorks() {
    
        Role role = new Role(1);

        Branch branch = new Branch(1,"Loja Teste","location teste","9823232323","loga@gmail.com");

        Employee employee = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee[] employees = {employee};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {employee};

        assertArrayEquals(expected, result);


    }

    @DisplayName("Ensure sorting an array with two (already sorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoSortedElementsWorks() {
       
        Role role = new Role(1);

        Branch branch = new Branch(1,"Loja Teste","location teste","9823232323","loga@gmail.com");

        Employee employee1 = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee employee2 = new Employee("Teste2", 999123123, "Rua de cima2, México2", "teste2@gmail.com", "4213123123", role, branch);

        Employee[] employees = {employee1, employee2};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {employee1, employee2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with two (unsorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoUnsortedElementsWorks() {
        
        Role role = new Role(1);

        Branch branch = new Branch(1,"Loja Teste","location teste","9823232323","loga@gmail.com");

        Employee employee1 = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee employee2 = new Employee("Teste2", 999123123, "Rua de cima2, México2", "teste2@gmail.com", "4213123123", role, branch);

        Employee[] employees = {employee2, employee1};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {employee1, employee2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with two equal elements works.")
    @Test
    public void ensureSortingArrayWithTwoEqualElementsWorks() {
        
        Role role = new Role(1);

        Branch branch = new Branch(1,"Loja Teste","location teste","9823232323","loga@gmail.com");

        Employee employee1 = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee employee2 = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee[] employees = {employee1, employee2};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {employee1, employee2};

        assertArrayEquals(expected, result);
    }

    @DisplayName("Ensure sorting an array with several unordered elements works.")
    @Test
    public void ensureSortingArrayWithSeveralUnsortedElementsWorks() {
       
        Role role = new Role(1);

        Branch branch = new Branch(1,"Loja Teste","location teste","9823232323","loga@gmail.com");

        Employee employee1 = new Employee("Teste", 999123123, "Rua de cima, México", "teste@gmail.com", "4213123123", role, branch);

        Employee employee2 = new Employee("Teste2", 999123123, "Rua de cima2, México2", "teste2@gmail.com", "4213123123", role, branch);
        
        Employee employee3 = new Employee("Teste3", 999123123, "Rua de cima3, México3", "teste3@gmail.com", "4213123123", role, branch);

        Employee[] employees = {employee2, employee3, employee1};

        Employee[] result = EmployeeRepository.sortEmployeesAlphabetically(employees);

        Employee[] expected = {employee1, employee2, employee3};

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





