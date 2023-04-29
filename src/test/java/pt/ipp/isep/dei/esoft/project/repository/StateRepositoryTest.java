package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.State;
import pt.ipp.isep.dei.esoft.project.domain.repository.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StateRepositoryTest {
    private StateRepository stateRepository;

    @BeforeEach
    void setUp() {
        stateRepository = new StateRepository();
    }

    @Test
    void save() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        State newState = new State("New York", Arrays.asList(newYorkDistrict));
        stateRepository.save(newState);

        State foundState = stateRepository.findByName("New York");
        assertEquals(newState, foundState);
    }
 
    @Test
    void findByName() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        State newState = new State("New York", Arrays.asList(newYorkDistrict));
        stateRepository.save(newState);

        State foundState = stateRepository.findByName("New York");
        assertEquals(newState, foundState);
    }

    @Test
    void findByNameNotFound() {
        State foundState = stateRepository.findByName("Nonexistent State");
        assertNull(foundState);
    }

    @Test
    void findAll() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        State newState = new State("New York", Arrays.asList(newYorkDistrict));

        City losAngelesCity = new City("Los Angeles");
        District losAngelesDistrict = new District("Hollywood", Arrays.asList(losAngelesCity));
        State californiaState = new State("California", Arrays.asList(losAngelesDistrict));

        stateRepository.save(newState);
        stateRepository.save(californiaState);

        List<State> states = stateRepository.findAll();
        assertEquals(2, states.size());
        assertEquals(newState, states.get(0));
        assertEquals(californiaState, states.get(1));
    }
}