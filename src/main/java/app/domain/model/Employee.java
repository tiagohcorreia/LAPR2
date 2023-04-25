package app.domain.model;

import java.util.Objects;

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
