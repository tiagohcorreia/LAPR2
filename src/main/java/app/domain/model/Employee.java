package app.domain.model;

import java.util.Objects;

public class Employee {

    private String name;
    private int PassportNumber;
    private int taxNumber;
    private String address;
    private String emailAdress;
    private int contactNumber;
    private Roles role;
    private Agency agency;


    public Employee(String name, int passportNumber, int taxNumber, String address, String emailAdress, int contactNumber, Roles role, Agency agency) {
        this.name = name;
        PassportNumber = passportNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.emailAdress = emailAdress;
        this.contactNumber = contactNumber;
        this.role = role;
        this.agency = agency;
    }

    public Employee(String employeeName) {
    }

    public String getName() {
        return name;
    }

    public int getPassportNumber() {
        return PassportNumber;
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

    public int getContactNumber() {
        return contactNumber;
    }

    public Roles getRole() {
        return role;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportNumber(int passportNumber) {
        PassportNumber = passportNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{ ");
        sb.append("name='").append(name).append('\'');
        sb.append(", PassportNumber=").append(PassportNumber);
        sb.append(", taxNumber=").append(taxNumber);
        sb.append(", address='").append(address).append('\'');
        sb.append(", emailAdress='").append(emailAdress).append('\'');
        sb.append(", contactNumber=").append(contactNumber);
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
        return PassportNumber == employee.PassportNumber && taxNumber == employee.taxNumber && contactNumber == employee.contactNumber && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(emailAdress, employee.emailAdress) && role == employee.role && agency == employee.agency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, PassportNumber, taxNumber, address, emailAdress, contactNumber, role, agency);
    }
}
