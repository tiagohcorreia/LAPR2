package app.controller;

import app.domain.model.District;
import app.domain.model.State;
import app.domain.repository.StateRepository;

import java.util.ArrayList;
import java.util.List;

public class StateController {
    private StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public void addState(String name) {
        State state = new State(name, new ArrayList<>());
        stateRepository.save(state);
    }

    public State findStateByName(String name) {
        return stateRepository.findByName(name);
    }

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
    public void addDistrictToState(State state, District district) {
        stateRepository.addDistrictToState(state, district);
    }
}
