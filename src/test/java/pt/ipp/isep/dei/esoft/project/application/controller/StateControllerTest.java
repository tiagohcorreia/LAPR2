package pt.ipp.isep.dei.esoft.project.application.controller;

import app.controller.StateController;
import app.domain.model.State;
import app.domain.repository.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StateControllerTest {
    private StateRepository stateRepository;
    private StateController stateController;

    @BeforeEach
    void setUp() {
        stateRepository = Mockito.mock(StateRepository.class);
        stateController = new StateController(stateRepository);
    }

    @Test
    void addState() {
        String stateName = "California";
        stateController.addState(stateName);

        State state = new State(stateName, new ArrayList<>());
        verify(stateRepository, times(1)).save(state);
    }

    @Test
    void findStateByName() {
        State california = new State("California", new ArrayList<>());
        when(stateRepository.findByName("California")).thenReturn(california);

        State foundState = stateController.findStateByName("California");
        assertEquals(california, foundState);
    }

    @Test
    void getAllStates() {
        List<State> states = new ArrayList<>(Arrays.asList(
                new State("California", new ArrayList<>()),
                new State("Texas", new ArrayList<>()),
                new State("New York", new ArrayList<>())
        ));
        when(stateRepository.findAll()).thenReturn(states);

        List<State> allStates = stateController.getAllStates();
        assertEquals(states, allStates);
    }
}
