package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Validator;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Employee.
 */
public class Employee implements Serializable, Validator {

    private String name;
    private int passportNumber;
    private int taxNumber;
    private String address;
    private String emailAddress;
    private String telephoneNumber;
    private Role role;
    private Branch branch;


    /**
     * Instantiates a new Employee.
     *
     * @param name            the name
     * @param passportNumber  the passport number
     * @param taxNumber       the tax number
     * @param address         the address
     * @param emailAddress    the email adress
     * @param telephoneNumber the telephone number
     * @param role            the role
     * @param branch          the agency
     */
    public Employee(String name, int passportNumber, int taxNumber, String address, String emailAddress, String telephoneNumber, Role role, Branch branch) {

        this.name = setName(name);
        this.passportNumber = setPassportNumber(passportNumber);
        this.taxNumber = setTaxNumber(taxNumber);
        this.address = setAddress(address);
        this.emailAddress = setEmailAdress(emailAddress);
        this.telephoneNumber = setTelephoneNumber(telephoneNumber);
        this.role = role;
        this.branch = branch;

        validate();
    }

    /**
     * Instantiates a new Employee.
     *
     * @param employeeName the employee name
     */
    public Employee(String employeeName) {
        this.name = employeeName;
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
     * Gets passport number.
     *
     * @return the passport number
     */
    public int getPassportNumber() {
        return passportNumber;
    }

    /**
     * Gets tax number.
     *
     * @return the tax number
     */
    public int getTaxNumber() {
        return taxNumber;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets email adress.
     *
     * @return the email adress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets telephone number.
     *
     * @return the telephone number
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }


    public Branch getBranch() {
        return branch;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public String setName(String name) {

        if (name == null) {

            throw new NullPointerException("Employee name can't be null");

        } else if (name.trim().isEmpty()) {

            throw new IllegalArgumentException("Employee name must be filled");

        }
        return name;
    }

    /**
     * Sets passport number.
     *
     * @param passportNumber the passport number
     * @return the passport number
     */
    public int setPassportNumber(int passportNumber) {

        if (passportNumber < 0) {

            throw new IllegalArgumentException("Passport number can't be negative");

        } else if (Integer.toString(passportNumber).trim().length() != 9) {

            throw new IllegalArgumentException("Passport Number must have 9 digits.");
        }
        return passportNumber;
    }

    /**
     * Sets tax number.
     *
     * @param taxNumber the tax number
     * @return the tax number
     */
    public int setTaxNumber(int taxNumber) {

        if (taxNumber < 0) {

            throw new IllegalArgumentException("Tax Number can't be negative");

        } else if (Integer.toString(passportNumber).trim().length() != 9) {

            throw new IllegalArgumentException("Tax Number must have 9 digits");
        }
        return taxNumber;
    }

    /**
     * Sets address.
     *
     * @param address the address
     * @return the address
     */
    public String setAddress(String address) {

        if (address == null) {

            throw new IllegalArgumentException("Employee address can't be null");

        } else if (address.trim().isEmpty()) {

            throw new IllegalArgumentException("Employee address must be filled");
        }
        return address;
    }

    /**
     * Sets email adress.
     *
     * @param emailAdress the email adress
     * @return the email adress
     */
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

    /**
     * Sets telephone number.
     *
     * @param telephoneNumber the telephone number
     * @return the telephone number
     */
    public String setTelephoneNumber(String telephoneNumber) {

        if(!isNumeric(telephoneNumber)) {

            throw new IllegalArgumentException("Telephone number must contain only numbers");
        }

        if (Long.parseLong(telephoneNumber) < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (telephoneNumber.trim().length() != 10) {

            throw new IllegalArgumentException("Telephone Number must have 10 digits");
        }
        return telephoneNumber;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }


    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("");
        sb.append("Name:").append(name).append('\'');
        sb.append(" Passport Number:").append(passportNumber);
        sb.append(" Tax Number:").append(taxNumber);
        sb.append(" Address:'").append(address).append('\'');
        sb.append(" E-mail Adress:'").append(emailAddress).append('\'');
        sb.append(" Contact Number:").append(telephoneNumber);
        sb.append(" Role:").append(role);
        sb.append(" Branch:").append(branch);


        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(passportNumber, other.passportNumber) && Objects.equals(taxNumber, other.taxNumber) &&
               Objects.equals(telephoneNumber, other.telephoneNumber) && Objects.equals(emailAddress, other.emailAddress);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber, taxNumber, address, emailAddress, telephoneNumber, role, branch);
    }

    private boolean validate() {

        boolean valid = false;

        valid = validateString(this.name) && validatePassportNumber(this.passportNumber) && validateTaxNumber(this.taxNumber) &&
                validateEmail(this.emailAddress) && validatePhoneNumber(this.telephoneNumber);

        if (!valid) {

            throw new IllegalStateException("Employee is invalid");
        }
        return true;
    }

    public boolean isNumeric(String telephoneNumber) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(telephoneNumber);

        return matcher.matches();
    }

}
