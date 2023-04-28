package app.domain.model;

import app.exceptions.NegativeNumberException;

import java.util.Objects;

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
