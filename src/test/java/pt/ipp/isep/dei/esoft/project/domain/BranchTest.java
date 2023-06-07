package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.domain.model.Branch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Branch test.
 */
class BranchTest {


    /**
     * Ensure name equal 40 chars works.
     */
    @DisplayName("Ensure name equal 40 chars works")
    @Test
    void EnsureNameEqual40CharsWorks() {

        assertDoesNotThrow( ()->{

          Branch b = new Branch();

         b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");

        });
    }

    /**
     * Ensure name bigger than 40 chars fails.
     */
    @DisplayName("Ensure name bigger than 40 chars fails")
    @Test
    void EnsureNameBiggerThan40CharsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqa");


        });
    }

    /**
     * Ensure name smaller than 40 chars works.
     */
    @DisplayName("Ensure name smaller than 40 chars works")
    @Test
    void EnsureNameSmallerThan40CharsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setName("a");

        });
    }


    /**
     * Ensure null data fails.
     */
    @DisplayName("Ensure null data fails")
    @Test
    void EnsureNullDataFails() {

        assertThrows(NullPointerException.class, () -> {

            Branch b = new Branch(0, null, null ,String.valueOf(0),null);

        });
    }

    /**
     * Ensure create branch works.
     */
    @DisplayName("Ensure create branch works")
    @Test
    void EnsureCreateBranchWorks() {

        assertDoesNotThrow( ()->{

            //Branch b = new Branch(1, "MEGA STORE", "Porto" ,982822882,"mega@asda.com");
            Branch b = new Branch(1, "MEGA STORE", new Location("123 Street", new City(), 12345),String.valueOf(982822882),"mega@asda.com");

        });
    }

    /**
     * Ensure phone number with 9 digits works.
     */
    @DisplayName("Ensure phone number with 9 digits works")
    @Test
    void EnsurePhoneNumberWith9DigitsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setPhoneNumber(String.valueOf(981321232));

        });
    }


    /**
     * Ensure phone number with 7 digits fails.
     */
    @DisplayName("Ensure phone number with 7 digits fails")
    @Test
    void EnsurePhoneNumberWith7DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setPhoneNumber(String.valueOf(9813232));

        });
    }



}