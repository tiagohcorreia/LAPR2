# US 003 - Register a new Employee  

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Employee class with null values. 

	
	

**Test 2:**  

	


*It is also recommended to organize this content by subsections.* 

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
        String Role = this.controller.getRole();
        Integer pos1 = Utils.readIntegerFromConsole("Choose a Role for the Employee: ");

        //Agency
        String Agency = this.controller.getAgency();
        Integer pos2 = Utils.readIntegerFromConsole("Choose a Agency for the Employee: ");


        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if (optValidation == 1) {
            /*this.controller.createEmployee(emplyeeName, employeePassportNumber,
                    address, address, eMail, telephoneNumber,role,agency);*/

            System.out.println("Employee name: " + emplyeeName);
            System.out.println("Employee Passport Number: " + employeePassportNumber);
            System.out.println("Employee Address: " + address);
            System.out.println("Employee E-mail: " + eMail);
            System.out.println("Employee Telephone Number: " + telephoneNumber);
            //System.out.println("Employee Role: " + );
            //System.out.println("Employee Agency: " + );

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

    public String getRole() {
        return Role.asString();
    }

    public String getAgency() {
        return Agency.asString();
    }

    public void createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                               int telephoneNumber, Role role, Agency agency) {

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
    private int telephoneNumber;
    private Role role;
    private Agency agency;


    public Employee(String name, int passportNumber, int taxNumber, String address, String emailAdress, int telephoneNumber, Role role, Agency agency) {

        verifyIfEmployeeDataIsNotNull(name, passportNumber, taxNumber, address, emailAdress, telephoneNumber);

        this.name = name;
        this.passportNumber = setPassportNumber(passportNumber);
        this.taxNumber = setTaxNumber(taxNumber);
        this.address = address;
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

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int setPassportNumber(int passportNumber) {

        if(Integer.toString(passportNumber).length() != 9) {
            throw new IllegalArgumentException("Passport number must have 9 digits.");
        }

        return passportNumber = passportNumber;
    }

    public int setTaxNumber(int taxNumber) {

        if(Integer.toString(taxNumber).length() != 9) {

            throw new IllegalArgumentException("Tax Number must have 9 digits");

        } else if(telephoneNumber < 0) {

            throw new IllegalArgumentException("Tax Number can't be negative");
        }

        return this.taxNumber = taxNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String setEmailAdress(String emailAdress) {

        if(!emailAdress.contains("@")) {
            throw new IllegalArgumentException("Invalid E-mail address.");
        }

        return this.emailAdress = emailAdress;
    }

    public int setTelephoneNumber(int telephoneNumber) {

        if(Integer.toString(telephoneNumber).length() != 10) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");

        } else if(telephoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");
        }

        return this.telephoneNumber = telephoneNumber;
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

    private void verifyIfEmployeeDataIsNotNull(String name, int passportNumber, int taxNumber, String address, String emailAdress, int telephoneNumber) {

        if (name == null || passportNumber == 0 || taxNumber == 0 || address == null || emailAdress == null || telephoneNumber == 0) {
            throw new NullPointerException("Employee data can't be empty. Please fill all the required fields.");
        }
    }
}
```

## Enum Role

```java
public enum Role {

    ADMNISTRATOR, MANAGER, AGENT;

    public static String asString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0").append(ADMNISTRATOR.toString()).append("\n");
        stringBuilder.append("1").append(MANAGER.toString()).append("\n");
        stringBuilder.append("2").append(AGENT.toString()).append("\n");

        return stringBuilder.toString();
    }

    public static List<Role> getRolesAsList() {

        List<Role> roles = new ArrayList<>();

        roles.add(ADMNISTRATOR);  //0
        roles.add(MANAGER);      //1
        roles.add(AGENT);       //2

        return roles;
    }

    public static Role getRoleByID(int position) {

        List<Role> aux = getRolesAsList();

        return aux.get(position);
    }


}

```

## Enum Agency

```java
public enum Agency {

    AGENCY1, AGENCY2, AGENCY3;

    public static String asString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0").append(AGENCY1.toString()).append("\n");
        stringBuilder.append("1").append(AGENCY2.toString()).append("\n");
        stringBuilder.append("2").append(AGENCY3.toString()).append("\n");

        return stringBuilder.toString();
    }

    public static List<Agency> getAgencyAsList() {

        List<Agency> agency = new ArrayList<>();

        agency.add(AGENCY1); //0
        agency.add(AGENCY2); //1
        agency.add(AGENCY3); //2

        return agency;
    }

    public static Agency getRolebyID(int position) {

        List<Agency> aux = getAgencyAsList();

        return aux.get(position);
    }

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





