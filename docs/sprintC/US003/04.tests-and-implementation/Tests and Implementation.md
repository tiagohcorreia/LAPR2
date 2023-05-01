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
        this.controller = controller;
    }
    @Override
    public void run() {

        //Employee name
        String emplyeeName = Utils.readLineFromConsole("Insert Employee name: ");

        //Passport Number
        Integer employeePassportNumber = Utils.readIntegerFromConsole("Insert Passport Number: ");

        //TaxNumber
        Integer taxNumber = Utils.readIntegerFromConsole("Insert Tax Number: ");

        //Address
        String address = Utils.readLineFromConsole("Insert Address: ");

        //E-mail
        String eMail = Utils.readLineFromConsole("Insert E-mail: ");

        //Telephone Number
        Integer telephoneNumber = Utils.readIntegerFromConsole("Insert Telephone Number: ");

        //Role
        List<Role> x = this.controller.getRolesAsList();
        Utils.showList(x, "Roles");
        Integer posRole = Utils.readIntegerFromConsole("Choose a Role for the Employee: ");

        //Agency
        List<Agency> y = this.controller.getAgency();
        Utils.showList(y, "Agency");
        Integer posAgency = Utils.readIntegerFromConsole("Choose a Agency for the Employee:


        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if (optValidation == 1) {
            
            this.controller.createEmployee(emplyeeName, employeePassportNumber, taxNumber, address, eMail, telephoneNumber, posRole, posAgency);

            System.out.println("Employee name: " + emplyeeName);
            System.out.println("Employee Passport Number: " + employeePassportNumber);
            System.out.println("Employee Address: " + address);
            System.out.println("Employee E-mail: " + eMail);
            System.out.println("Employee Telephone Number: " + telephoneNumber);
            System.out.println("Employee Role: " + Role.getRoleById(posRole));
            System.out.println("Employee Agency: " + Agency.getAgencyById(posAgency));

        } else {
            System.err.println("Operation Canceled!");
        }

    }
}
```


## Class RegisterEmployeeController

```java
public class RegisterEmployeeController {

    private RegisterEmployeeRepository employeeRepository;

    public RegisterEmployeeController(RegisterEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Role> getRolesAsList() {
        return Arrays.stream(Role.values()).toList();
    }

    public List<Agency> getAgency() {
        return Arrays.stream(Agency.values()).toList();
    }


    public String createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                                 long telephoneNumber, Integer posRole, Integer posAgency)  {

        Employee newEmployee = new Employee(employeeName, passportNumber, taxNumber, address, eMail, telephoneNumber,
                Role.getRoleById(posRole), Agency.getAgencyById(posAgency));

        try {

            this.employeeRepository.saveEmployee(newEmployee);
            System.out.println();
            return newEmployee.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }
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

        this.name = setName(name);
        this.passportNumber = setPassportNumber(passportNumber);
        this.taxNumber = setTaxNumber(taxNumber);
        this.address = setAddress(address);
        this.emailAdress = setEmailAdress(emailAdress);
        this.telephoneNumber = setTelephoneNumber(telephoneNumber);
        this.role = role;
        this.agency = agency;
    }

    public Employee(String employeeName) {
    }

    public String getName() {
        return name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public Agency getAgency() {
        return agency;
    }

    public String setName(String name) {

        if (name == null) {

            throw new NullPointerException("Employee name can't be null");

        } else if (name.trim().isEmpty()) {

            throw new IllegalArgumentException("Employee name must be filled");

        }
        return name;
    }

    public int setPassportNumber(int passportNumber) {

        if (passportNumber < 0) {

            throw new IllegalArgumentException("Passport number can't be negative");

        } else if (passportNumber >= 100000000 && passportNumber <= 999999999) {

            throw new IllegalArgumentException("Passport number must have 9 digits.");
        }
        return passportNumber;
    }

    public int setTaxNumber(int taxNumber) {

        if (taxNumber < 0) {

            throw new IllegalArgumentException("Tax Number can't be negative");

        } else if (taxNumber >= 100000000 && taxNumber <= 999999999) {

            throw new IllegalArgumentException("Tax Number must have 9 digits");
        }
        return taxNumber;
    }

    public String setAddress(String address) {

        if (address == null) {

            throw new IllegalArgumentException("Employee address can't be null");

        } else if (address.trim().isEmpty()) {

            throw new IllegalArgumentException("Employee address must be filled");
        }
        return address;
    }

    public String setEmailAdress(String emailAdress) {

        if (emailAdress == null) {

            throw new IllegalArgumentException("Employee name can't be null");

        } else if (emailAdress.trim().isEmpty()) {

            throw new IllegalArgumentException("Employee name must be filled");

        } else if (!emailAdress.contains("@")) {

            throw new IllegalArgumentException("E-mail address must have @");
        }
        return emailAdress;
    }

    public long setTelephoneNumber(long telephoneNumber) {

        if (telephoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (telephoneNumber >= 1_000_000_000L && telephoneNumber <= 9_999_999_999L) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");
        }
        return telephoneNumber;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Employee{ ");

        sb.append("name='").append(name).append('\'');
        sb.append(", PassportNumber=").append(passportNumber);
        sb.append(", taxNumber=").append(taxNumber);
        sb.append(", address='").append(address).append('\'');
        sb.append(", emailAdress='").append(emailAdress).append('\'');
        sb.append(", contactNumber=").append(telephoneNumber);
        sb.append(", role=").append(role);
        sb.append(", agency=").append(agency);
        sb.append('}');

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return passportNumber == employee.passportNumber && taxNumber == employee.taxNumber && telephoneNumber == employee.telephoneNumber && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(emailAdress, employee.emailAdress) && role == employee.role && agency == employee.agency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber, taxNumber, address, emailAdress, telephoneNumber, role, agency);
    }

    /*private void verifyIfEmployeeDataIsNotNull(String name, int passportNumber, int taxNumber, String address, String emailAdress, long telephoneNumber) {

        if (name.trim().isEmpty() || Integer.toString(passportNumber).trim().isEmpty() || Integer.toString(taxNumber).trim().isEmpty() || address.trim().isEmpty() || emailAdress.trim().isEmpty() || Long.toString(telephoneNumber).trim().isEmpty()) {
            throw new NullPointerException("Employee data can't be empty. Please fill all the required fields.");
        }

        if (name.length() < 1) {

            throw new NullPointerException("Employee data can't be empty. Please fill all the required fields.");
        }
    }*/
}

```

## Class RegisterEmployeeRepository

```java
public class RegisterEmployeeRepository {

    public static List<Employee> employeeList = new ArrayList();

    public Employee createEmployee (String employeeName) {

        return new Employee(employeeName);
    }

    public boolean saveEmployee(Employee employee) {

        if(validateEmployee(employee)) {

            return addEmployee(employee);
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {

        if(employee != null && validateEmployee(employee)) {

            return this.employeeList.add(employee);
        }
        return false;
    }

    public boolean validateEmployee(Employee employee) {

        for(Employee employee1 : employeeList) {

            if(employee.equals(employee)) {

                return false;
            }
        }
        return true;
    }

    public List<Employee> getEmployeeList() {

        return new ArrayList<>(employeeList);
    }

    public static Employee getEmployee(String employeeID) {

        for(Employee employee : employeeList) {

            if(employee.getName().equals(employeeID)) {

                return employee;
            }
        }
        return null;
    }

    public String getEmployeeListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Employee employee : this.employeeList) {

            stringBuilder.append("-").append(employee.toString()).append("\n");

        }
        return stringBuilder.toString();
    }
    public List<Employee> getAgent() {
        List<Employee> agent= new ArrayList();
        for(Employee employee : employeeList) {

            if(employee.getRole().equals("AGENT")) {
                agent.add(employee);
            }
        }
        return agent;
    }
}

```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.


# 7. Observations

* N/A





