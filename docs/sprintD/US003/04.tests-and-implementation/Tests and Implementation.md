# US 003 - Register a new Employee  

# 4. Tests 

**Tests for Employee Name:** Check that it is not possible to create an instance of the Employee class with null values. 

	@DisplayName("Ensure Empty Employee Name Fails")
    @Test
    void EnsureNullEmployeeNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setName("");
        });
    }

     @DisplayName("Ensure Null Employee Name Fails")
    @Test
    void EnsureEmptyEmployeeNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setName(null);
        });
    }
	

**Tests for Employee Passport Number:**

        @DisplayName("Ensure Negative Employee Passport Number Fails")
        @Test
        void EnsureNegativeEmployeePassportNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", -12345678 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 1234567891 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 12345678 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

**Tests for Employee Tax Number:**  

       @DisplayName("Ensure Negative Employee Tax Number fails")
       @Test
       void EnsureNegativeEmployeeTaxNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , -23456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 1234567891, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 12345678, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

**Tests for Employee Address:**  

       @DisplayName("Ensure Empty Employee Address Fails")
       @Test
       void EnsureEmptylEmployeeAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress("");
        });
    }

    @DisplayName("Ensure Null Employee Address Fails")
    @Test
    void EnsureNullEmployeeAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress(null);
        });
    }


**Tests for Employee E-mail:**  

    @DisplayName("Ensure Null Employee E-mail Address Fails")
    @Test
    void EnsureNullEmployeeEmailAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setEmailAdress(null);
        });
    }

    @DisplayName("Ensure Empty Employee E-mail Address Fails")
    @Test
    void EnsureEmptyEmployeeEmailAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setEmailAdress("");
        });
    }

    @DisplayName("Ensure Employee E-mail Address Without @ Fails")
    @Test
    void EnsureNullEmployeeEmailAddressWithoutAnArrobaFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "employee123", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress("employee123");
        });
    }


**Tests for Employee Telephone Number:**  

    @DisplayName("Ensure Negative Employee Telephone Number fails")
    @Test
    void EnsureNegativeEmployeeTelephoneNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 123456789, "Rua 1", "e1@gmail.com", -234567891, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Telephone Number with 9 digits fails")
    @Test
    void EnsureEmployeeTelephoneNumberWith9DigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 123456789, "Rua 1", "e1@gmail.com", 123456789, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

    @DisplayName("Ensure Employee Telephone Number with 11 digits fails")
    @Test
    void EnsureEmployeeTelephoneNumberWith11DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 123456789, "Rua 1", "e1@gmail.com", 12_345_678_910L, Role.AGENT, Agency.AGENCY1);
            assertNotNull(e1);
        });
    }

# 5. Construction (Implementation)


## Class RegisterEmployeeUI 

```java
public class RegisterEmployeeUI implements Runnable {

    private RegisterEmployeeController controller;

    public RegisterEmployeeUI(RegisterEmployeeController controller) {
       
    }
    @Override
    public void run() {
        
    }
}
```


## Class RegisterEmployeeController

```java
public class RegisterEmployeeController {

    private RegisterEmployeeRepository employeeRepository;

    public RegisterEmployeeController(RegisterEmployeeRepository employeeRepository) {
       
    }

    public List<Role> getRolesAsList() {
       
    }

    public List<Branch> getBranch() {
        
    }
    
    public String createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                                 long telephoneNumber, Integer posRole, Integer posAgency)  {
        
        }
    }

```

## Class Employee

```java
public class Employee {

    private String name;
    private int passportNumber;
    private int taxNumber;
    private String address;
    private String emailAdress;
    private long telephoneNumber;
    private Role role;
    private Agency agency;


    public Employee(String name, int passportNumber, int taxNumber, String address, String emailAdress, long telephoneNumber, Role role, Agency agency) {
        
    }

    public Employee(String employeeName) {
    }

    public String getName() {
        
    }

    public int getPassportNumber() {
        
    }

    public int getTaxNumber() {
        
    }

    public String getAddress() {
        
    }

    public String getEmailAdress() {
        
    }

    public long getTelephoneNumber() {
        
    }

    public Role getRole() {
        
    }

    public Agency getAgency() {
        
    }

    public String setName(String name) {
        
    }

    public int setPassportNumber(int passportNumber) {
        
    }

    public int setTaxNumber(int taxNumber) {
        
    }

    public String setAddress(String address) {
        
    }

    public String setEmailAdress(String emailAdress) {
        
    }

    public long setTelephoneNumber(long telephoneNumber) {
        
    }

    public void setRole(Role role) {
       
    }

    public void setAgency(Agency agency) {
        
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

## Class RegisterEmployeeRepository

```java
public class RegisterEmployeeRepository {

    public static List<Employee> employeeList = new ArrayList();

    public Employee createEmployee (String employeeName) {
        
    }

    public boolean saveEmployee(Employee employee) {
        
    }

    public boolean addEmployee(Employee employee) {
        
    }

    public boolean validateEmployee(Employee employee) {
        
    }

    public List<Employee> getEmployeeList() {
        
    }

    public static Employee getEmployee(String employeeID) {
        
    }

    public String getEmployeeListAsString() {
        
    }
    
}

```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.


# 7. Observations

* N/A





