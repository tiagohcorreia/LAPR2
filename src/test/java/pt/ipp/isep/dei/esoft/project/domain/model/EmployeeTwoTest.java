package pt.ipp.isep.dei.esoft.project.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Employee two test.
 */
public class EmployeeTwoTest {

    public static final Branch branch = new Branch();

    //Name

    /**
     * Ensure null employee name fails.
     */
    @DisplayName("Ensure Empty Employee Name Fails")
    @Test
    void EnsureNullEmployeeNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(String.valueOf(982822882)), Role.AGENT, branch);
            e1.setName("");
        });
    }

    /**
     * Ensure empty employee name fails.
     */
    @DisplayName("Ensure Null Employee Name Fails")
    @Test
    void EnsureEmptyEmployeeNameFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(String.valueOf(982822882)), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", -12345678, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);


        });
    }

    /**
     * Ensure employee passport number with 10 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 982822882, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);

        });
    }

    /**
     * Ensure employee passport number with 8 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeePassportNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 12345678, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);

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

            Employee e1 = new Employee("Employee", 123456789, -23456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);

        });
    }

    /**
     * Ensure employee tax number with 10 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 10 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith10DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 982822882, 982822882, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);

        });
    }

    /**
     * Ensure employee tax number with 8 digits fails.
     */
    @DisplayName("Ensure Employee Passport Number with 8 digits Fails")
    @Test
    void EnsureEmployeeTaxNumberWith8DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 12345678, 12345678, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);

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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(982822882), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "employee123", String.valueOf(982822882), Role.AGENT, branch);
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

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(-234567891), Role.AGENT, branch);

        });
    }

    /**
     * Ensure employee telephone number with 9 digits fails.
     */
    @DisplayName("Ensure Employee Telephone Number with 9 digits fails")
    @Test
    void EnsureEmployeeTelephoneNumberWith9DigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "9876543210", Role.AGENT, branch);
            e1.setTelephoneNumber("987654321");
        });
    }

    @DisplayName("Ensure Employee Telephone Number with digits fails")
    @Test
    void EnsureEmployeeTelephoneNumberWithDigitsFails() {


        assertThrows(IllegalArgumentException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "9876543210", Role.AGENT, branch);
            e1.setTelephoneNumber("987654321a");
        });
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------

    @DisplayName("Ensure isNumeric is working")
    @Test
    void ensureIsNumericWorking2() {

        Employee e4 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "9876543210", Role.AGENT, branch);
        String num = e4.getTelephoneNumber();
        assertTrue(e4.isNumeric(num));

    }

    //isNumeric

    /*@DisplayName("Ensure isNumeric is working")
    @Test
    void ensureIsNumericWorking() {

        Employee e4 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "P876543210", Role.AGENT, branch);
        String num = e4.getTelephoneNumber();
        assertFalse(e4.isNumeric(num));

    }
*/

}
