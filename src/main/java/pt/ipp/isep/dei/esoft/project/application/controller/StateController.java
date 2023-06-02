package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.State;
import pt.ipp.isep.dei.esoft.project.domain.repository.StateRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type State controller.
 */
public class StateController {
    private StateRepository stateRepository;

    /**
     * Instantiates a new State controller.
     *
     * @param stateRepository the state repository
     */
    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    /**
     * Add state.
     *
     * @param name the name
     */
    public void addState(String name) {
        State state = new State(name, new ArrayList<>());
        stateRepository.save(state);
        stateRepository.writeObject();
    }

    /**
     * Find state by name state.
     *
     * @param name the name
     * @return the state
     */
    public State findStateByName(String name) {
        return stateRepository.findByName(name);
    }

    /**
     * Gets all states.
     *
     * @return the all states
     */
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    /**
     * Add district to state.
     *
     * @param state    the state
     * @param district the district
     */
    public void addDistrictToState(State state, District district) {
        stateRepository.addDistrictToState(state, district);
    }
}
