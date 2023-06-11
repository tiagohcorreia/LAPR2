# US 013 - List all employees

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


## Class ListAllEmployeesUI 

```java
public class ListAllEmployeesUI implements Runnable {


    private ListAllEmployeesController controller = new ListAllEmployeesController();

    @Override
    public void run() {

    }


}
```


## Class ListAllEmployeesController

```java
public class ListAllEmployeesController {

}

```

## Class Repositories

```java
public class Repositories {

    EmployeeRepository employeeRepository = new EmployeeRepository();

    BranchRepository branchRepository = new BranchRepository();


    public static Repositories getInstance() 
    {
    
    }


    public EmployeeRepository getEmployeeRepository() {
       
    }

    public BranchRepository getBranchRepository() 
    {
        
    }


}

```


## Class BranchRepository

```java
public class BranchRepository {

   private final List<Branch> branches = new ArrayList<>();


    public List<Branch> getAllBranches(){}

    public List<Branch> sortBranchesByListings(List<Branch> branches){}

    public int getListingTotalByBranch(Branch branch){}


}

```

## Class EmployeeRepository

```java
public class EmployeeRepository {

   private final List<Employee> employees = new ArrayList<>();


    public List<Employee> getEmployeesByBranchID(Branch branch){}

    public List<Employee> sortEmployeesAlphabetically(Branch branch){}

}

```


# 6. Integration and Demo 

* A new option on the Administrator menu options was added.


# 7. Observations

* N/A





