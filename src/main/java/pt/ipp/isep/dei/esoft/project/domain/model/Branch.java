package pt.ipp.isep.dei.esoft.project.domain.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Branch.
 */
public class Branch implements Serializable {

    private int ID;
    private String name;
    private Location location;
    private String phoneNumber;
    private String email;

    /**
     * Instantiates a new Branch.
     *
     * @param ID          the id
     * @param name        the name
     * @param location    the location
     * @param phoneNumber the phone number
     * @param email       the email
     */
    public Branch(int ID, String name, Location location, String phoneNumber, String email) {

        checkIfDataIsNull(ID, name, location, phoneNumber, email);
        checkNameLength(name);
        checkValidEmail(email);
        checkValidPhoneNumber(phoneNumber);

        this.ID = ID;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Instantiates a new Branch.
     */
    public Branch() {

    }

    /**
     * Check if data is null.
     *
     * @param ID          the id
     * @param name        the name
     * @param location    the location
     * @param phoneNumber the phone number
     * @param email       the email
     */
    public void checkIfDataIsNull(int ID, String name, Location location, String phoneNumber, String email) {

        if (ID == 0 || name == null || location == null || phoneNumber == null || email == null) {
            throw new NullPointerException("All fields required");
        }
    }

    /**
     * Check name length.
     *
     * @param name the name
     */
    public void checkNameLength(String name) {
        if (!(name.length() <= 40)) {
            throw new IllegalArgumentException("Name should be 40 chars or less");
        }
    }

    /**
     * Check valid email.
     *
     * @param email the email
     */
    public void checkValidEmail(String email) {
        if (Pattern.matches("[a-z0-9]+@[a-z]+\\.[a-z]", email)) {
            throw new IllegalArgumentException("Email doesn't match the email pattern ***@***.***");
        }
    }

    /**
     * Check valid phone number.
     *
     * @param phoneNumber the phone number
     */
    public void checkValidPhoneNumber(String phoneNumber) {
        if (!Pattern.matches("[0-9]{10}", phoneNumber)) {
            throw new IllegalArgumentException("Phone Number can only have 10 digits");
        }
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        checkValidPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        checkValidEmail(email);
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Branch{");
        sb.append("ID:").append(ID);
        sb.append(", Name:'").append(name).append('\'');
        sb.append(", Location:").append(location);
        sb.append(", PhoneNumber:").append(phoneNumber);
        sb.append(", E-mail:'").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return ID == branch.ID && phoneNumber == branch.phoneNumber && Objects.equals(name, branch.name) && Objects.equals(location, branch.location) && Objects.equals(email, branch.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, location, phoneNumber, email);
    }
}
