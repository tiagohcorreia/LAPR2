# US 005 - Register a Store

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


## Class RegisterBranchUI 

```java
public class RegisterBranchUI implements Runnable {


    private RegisterBranchController controller = new RegisterBranchController(new RegisterBranchRepository());

    public RegisterBranchUI(RegisterBranchController controller) {
        //this.controller = controller;
    }
    @Override
    public void run() {

        //Branch ID
        Integer branchID = Utils.readIntegerFromConsole("Insert Branch ID: ");

        //Branch name
        String branchName = Utils.readLineFromConsole("Insert Branch name: ");

        //Branch location
        String branchLocation = Utils.readLineFromConsole("Insert Branch location: ");

        //Branch phoneNumber
        Integer branchPhoneNumber = Utils.readIntegerFromConsole("Insert Branch phone number: ");

        //Branch email
        String branchEmail = Utils.readLineFromConsole("Insert Branch email: ");



        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if (optValidation == 1) {

            controller.createBranch(branchID, branchName, branchLocation, branchPhoneNumber, branchEmail);

            System.out.println("Branch created!");

        } else {

            System.err.println("Operation Canceled!");

        }

    }


}
```


## Class RegisterBranchController

```java
public class RegisterBranchController {

    private RegisterBranchRepository branchRepository;

    public RegisterBranchController(RegisterBranchRepository branchRepo) {
        branchRepository = branchRepo;
    }

    public String createBranch(int ID, String name, String location, int phoneNumber,  String email) {

        Branch newBranch = new Branch(ID, name, location, phoneNumber, email);

        try {

            branchRepository.saveBranch(newBranch);

            return newBranch.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }


    }

}

```

## Class Branch

```java
public class Branch {

    private int ID;
    private String name;
    private String location;
    private int phoneNumber;
    private String email;

    public Branch(int ID, String name, String location, int phoneNumber, String email) {

        checkIfDataIsNull(ID,name,location,phoneNumber,email);
        checkNameLength(name);
        checkValidEmail(email);
        checkValidPhoneNumber(phoneNumber);

        this.ID = ID;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Branch(){

    }

    /**
     *
     * @param ID
     * @param name
     * @param location
     * @param phoneNumber
     * @param email
     */
    public void checkIfDataIsNull(int ID, String name, String location, int phoneNumber, String email){

        if (ID == 0 || name == null || location == null || phoneNumber == 0 || email == null) {
            throw new NullPointerException("All fields required");
        }
    }

    /**
     *
     * @param name
     */
    public void checkNameLength(String name){
        if(!(name.length() <= 40)){
            throw new IllegalArgumentException("Name should be 40 chars or less");
        }
    }

    /**
     *
     * @param email
     */
    public void checkValidEmail(String email){
        if(Pattern.matches("[a-z0-9]+@[a-z]+\\.[a-z]", email)){
            throw new IllegalArgumentException("Email doesn't match the email pattern ***@***.***");
        }
    }

    /**
     *
     * @param phoneNumber
     */
    public void checkValidPhoneNumber(int phoneNumber){

        if(!Pattern.matches("[0-9]{9}", Integer.toString(phoneNumber))){
            throw new IllegalArgumentException("Phone Number can only have 9 digits");
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(int phoneNumber) {
        checkValidPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        checkValidEmail(email);
        this.email = email;
    }
}

```

## Class RegisterBranchRepository

```java
public class RegisterBranchRepository {



    /**
     *
     * @param branch object to be saved
     */
    public void saveBranch(Branch branch){

        System.out.println("Saving branch...");
        //does nothing for now

    }

}

```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.


# 7. Observations

* N/A





