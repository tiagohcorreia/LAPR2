package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.Agency;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Employee two test.
 */
class EmployeeTwoTest {

    //Name

    /**
     * Ensure null employee name fails.
     */
    @DisplayName("Ensure Empty Employee Name Fails")
    @Test
    void EnsureNullEmployeeNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setName("");
        });
    }

    /**
     * Ensure empty employee name fails.
     */
    @DisplayName("Ensure Null Employee Name Fails")
    @Test
    void EnsureEmptyEmployeeNameFails() {

        assertThrows(NullPointerException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setName(null);
        });
    }


    //-----------------------------------------------------------------------------------------------------------------

    //PassportNumber

    /**
     * Ensure negative employee passport number fails.
     */
    @DisplayName("Ensure Negative Employee Passport Number Fails")
    @Test
    void EnsureNegativeEmployeePassportNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", -12345678 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);


        });
    }

    /**
     * Ensure employee passport number with 10 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 1234567891 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

        });
    }

    /**
     * Ensure employee passport number with 8 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 12345678 , 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

        });
    }


    //----------------------------------------------------------------------------------------------------------------

    //Tax Number

    /**
     * Ensure negative employee tax number fails.
     */
    @DisplayName("Ensure Negative Employee Tax Number fails")
    @Test
    void EnsureNegativeEmployeeTaxNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , -23456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

        });
    }

    /**
     * Ensure employee tax number with 10 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 1234567891 , 1234567891, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

        });
    }

    /**
     * Ensure employee tax number with 8 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 12345678 , 12345678, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);

        });
    }

    //-----------------------------------------------------------------------------------------------------------------

    //Address

    /**
     * Ensure emptyl employee address fails.
     */
    @DisplayName("Ensure Empty Employee Address Fails")
    @Test
    void EnsureEmptylEmployeeAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress("");
        });
    }

    /**
     * Ensure null employee address fails.
     */
    @DisplayName("Ensure Null Employee Address Fails")
    @Test
    void EnsureNullEmployeeAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress(null);
        });
    }


    //----------------------------------------------------------------------------------------------------------------

    //E-mail

    /**
     * Ensure null employee email address fails.
     */
    @DisplayName("Ensure Null Employee E-mail Address Fails")
    @Test
    void EnsureNullEmployeeEmailAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setEmailAdress(null);
        });
    }

    /**
     * Ensure empty employee email address fails.
     */
    @DisplayName("Ensure Empty Employee E-mail Address Fails")
    @Test
    void EnsureEmptyEmployeeEmailAddressFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setEmailAdress("");
        });
    }

    /**
     * Ensure null employee email address without an arroba fails.
     */
    @DisplayName("Ensure Employee E-mail Address Without @ Fails")
    @Test
    void EnsureNullEmployeeEmailAddressWithoutAnArrobaFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "employee123", 1234567891, Role.AGENT, Agency.AGENCY1);
            e1.setAddress("employee123");
        });
    }

    //----------------------------------------------------------------------------------------------------------------

    //Telephone Number

    /**
     * Ensure negative employee telephone number fails.
     */
    @DisplayName("Ensure Negative Employee Telephone Number fails")
    @Test
    void EnsureNegativeEmployeeTelephoneNumberFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 123456789, "Rua 1", "e1@gmail.com", -234567891, Role.AGENT, Agency.AGENCY1);

        });
    }

    /**
     * Ensure employee telephone number with 9 digits fails.
     */
    @DisplayName("Ensure Employee Telephone Number with 9 digits fails")
    @Test
    void EnsureEmployeeTelephoneNumberWith9DigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789 , 123456789, "Rua 1", "e1@gmail.com", 123456789, Role.AGENT, Agency.AGENCY1);

        });
    }

    // ---------------------------------------------------------------------------------------------------------------






}