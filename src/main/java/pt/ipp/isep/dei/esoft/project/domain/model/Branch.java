package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.regex.Pattern;

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
