package app.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {


    @DisplayName("Ensure name equal 40 chars works")
    @Test
    void EnsureNameEqual40CharsWorks() {

        assertDoesNotThrow( ()->{

          Branch b = new Branch();

         b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");

        });
    }

    @DisplayName("Ensure name bigger than 40 chars fails")
    @Test
    void EnsureNameBiggerThan40CharsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqa");


        });
    }

    @DisplayName("Ensure name smaller than 40 chars works")
    @Test
    void EnsureNameSmallerThan40CharsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setName("a");

        });
    }


    @DisplayName("Ensure null data fails")
    @Test
    void EnsureNullDataFails() {

        assertThrows(NullPointerException.class, () -> {

            Branch b = new Branch(0, null, null ,0,null);

        });
    }

    @DisplayName("Ensure create branch works")
    @Test
    void EnsureCreateBranchWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch(1, "MEGA STORE", "Porto" ,982822882,"mega@asda.com");

        });
    }

    @DisplayName("Ensure phone number with 9 digits works")
    @Test
    void EnsurePhoneNumberWith9DigitsWorks() {

        assertDoesNotThrow( ()->{

            Branch b = new Branch();

            b.setPhoneNumber(981321232);

        });
    }


    @DisplayName("Ensure phone number with 7 digits fails")
    @Test
    void EnsurePhoneNumberWith7DigitsFails() {

        assertThrows(IllegalArgumentException.class, () -> {

            Branch b = new Branch();

            b.setPhoneNumber(9813232);

        });
    }



}