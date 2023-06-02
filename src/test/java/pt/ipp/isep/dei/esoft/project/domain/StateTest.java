package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type State test.
 */
class StateTest {
    private State state;
    private List<District> districts;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        List<City> newYorkCities = new ArrayList<>(Arrays.asList(new City("New York"), new City("Buffalo")));
        List<City> californiaCities = new ArrayList<>(Arrays.asList(new City("Los Angeles"), new City("San Francisco")));

        // Use County as district
        District kingsCounty = new District("Kings County", newYorkCities);
        District losAngelesCounty = new District("Los Angeles County", californiaCities);

        districts = new ArrayList<>(Arrays.asList(kingsCounty, losAngelesCounty));
        state = new State("New York", districts);
    }

    /**
     * Gets name.
     */
    @Test
    void getName() {
        assertEquals("New York", state.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        state.setName("California");
        assertEquals("California", state.getName());
    }

    /**
     * Gets districts.
     */
    @Test
    void getDistricts() {
        assertEquals(districts, state.getDistricts());
    }

    /**
     * Sets districts.
     */
    @Test
    void setDistricts() {
        List<City> texasCities = new ArrayList<>(Arrays.asList(new City("Houston"), new City("Austin")));
        List<City> floridaCities = new ArrayList<>(Arrays.asList(new City("Miami"), new City("Orlando")));

        // Use County as district
        District harrisCounty = new District("Harris County", texasCities);
        District miamiDadeCounty = new District("Miami-Dade County", floridaCities);

        List<District> newDistricts = new ArrayList<>(Arrays.asList(harrisCounty, miamiDadeCounty));
        state.setDistricts(newDistricts);
        assertEquals(newDistricts, state.getDistricts());
    }

    /**
     * Test to string.
     */
    /*@Test
    void testToString() {
        assertEquals("State{name='New York', districts=" + districts + "}", state.toString());
    }*/

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        State anotherState = new State("New York", districts);
        assertEquals(state, anotherState);

        anotherState.setName("California");
        assertNotEquals(state, anotherState);
    }
}