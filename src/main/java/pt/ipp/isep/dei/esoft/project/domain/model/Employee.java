package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.Objects;

/**
 * The type Employee.
 */
public class Employee {

    private String name;
    private int passportNumber;
    private int taxNumber;
    private String address;
    private String emailAdress;
    private int telephoneNumber;
    private Role role;
    private Agency agency;


    /**
     * Instantiates a new Employee.
     *
     * @param name            the name
     * @param passportNumber  the passport number
     * @param taxNumber       the tax number
     * @param address         the address
     * @param emailAdress     the email adress
     * @param telephoneNumber the telephone number
     * @param role            the role
     * @param agency          the agency
     */
    public Employee(String name, int passportNumber, int taxNumber, String address, String emailAdress, int telephoneNumber, Role role, Agency agency) {

        this.name = setName(name);
        this.passportNumber = setPassportNumber(passportNumber);
        this.taxNumber = setTaxNumber(taxNumber);
        this.address = setAddress(address);
        this.emailAdress = setEmailAdress(emailAdress);
        this.telephoneNumber = setTelephoneNumber(telephoneNumber);
        this.role = role;
        this.agency = agency;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param employeeName the employee name
     */
    public Employee(String employeeName) {
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
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Gets telephone number.
     *
     * @return the telephone number
     */
    public long getTelephoneNumber() {
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

    /**
     * Gets agency.
     *
     * @return the agency
     */
    public Agency getAgency() {
        return agency;
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
    public int setTelephoneNumber(int telephoneNumber) {

        if (telephoneNumber < 0) {

            throw new IllegalArgumentException("Telephone Number can't be negative");

        } else if (Integer.toString(telephoneNumber).trim().length() != 10) {

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

    /**
     * Sets agency.
     *
     * @param agency the agency
     */
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