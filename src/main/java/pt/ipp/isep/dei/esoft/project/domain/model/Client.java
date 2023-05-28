package pt.ipp.isep.dei.esoft.project.domain.model;

import javax.management.InvalidAttributeValueException;
import java.util.List;

public class Client {
    private String name;
    private String email;
    private String password;
    private int cCNumber;
    private int taxNumber;
    private String address;
    protected Location location;
    private int telephoneNumber;

    public Client(String name, String email, int cCNumber, int taxNumber, int telephoneNumber) {
        this.name = name;
        this.email = email;
        this.cCNumber = cCNumber;
        this.taxNumber = taxNumber;
        this.telephoneNumber = telephoneNumber;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Client(String name, String email, String password, int cCNumber, int taxNumber, String address, int telephoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cCNumber = cCNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public Client(String name, String email, String password, int cCNumber, int taxNumber, Location location, int telephoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cCNumber = cCNumber;
        this.taxNumber = taxNumber;
        this.location = location;
        this.telephoneNumber = telephoneNumber;
    }

    public Client(List<String> input){

        try {
            name = input.get(0);
            email = input.get(1);
            password = input.get(2);
            cCNumber = Integer.parseInt(input.get(3));
            taxNumber = Integer.parseInt(input.get(4));
            address = input.get(5);
            telephoneNumber = Integer.parseInt(input.get(6));

            validate();
        } catch (Exception e) {
            System.out.println("Couldn't create user. " + e.getMessage());
        }
    }



    //TODO: check validation
    private boolean validate(){
        try{
            isValidName();
            isValidAddress();
            isValidEmail();
            isValidPassword();
            isValidCCNumber();
            isValidTaxNumber();
            isValidAddress();
            isValidTelephoneNumber();
        } catch (InvalidAttributeValueException e){
            System.out.println("Invalid attribute: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    private void isValidName() throws InvalidAttributeValueException {
        if (name == null || name.equals(""))
            throw new InvalidAttributeValueException("Name is invalid.");
    }

    private void isValidEmail() throws InvalidAttributeValueException {
        if (email == null || email.equals(""))
            throw new InvalidAttributeValueException("Email is invalid.");
    }

    private void isValidPassword() throws InvalidAttributeValueException {
        if (password == null || password.equals(""))
            throw new InvalidAttributeValueException("Password is invalid.");
    }

    private void isValidCCNumber() throws InvalidAttributeValueException {
        if (cCNumber < 1_000_000 || cCNumber > 10_000_000)
            throw new InvalidAttributeValueException("CC Number is invalid.");
    }

    private void isValidTaxNumber() throws InvalidAttributeValueException {
        if (taxNumber < 1_000_000 || taxNumber > 10_000_000)
            throw new InvalidAttributeValueException("Tax Number is invalid.");
    }

    private void isValidAddress() throws InvalidAttributeValueException {
        if (address == null)
            throw new InvalidAttributeValueException("Address is invalid.");
    }

    private void isValidTelephoneNumber() throws InvalidAttributeValueException {
        if (telephoneNumber < 100_000_000 || telephoneNumber > 999_999_999)
            throw new InvalidAttributeValueException("Telephone Number is invalid");
    }

    private void isValidLocation() throws InvalidAttributeValueException {
        if (location == null)
            throw new InvalidAttributeValueException("Location is invalid.");
    }

}
