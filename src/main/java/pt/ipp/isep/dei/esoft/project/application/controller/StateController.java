package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.State;
import pt.ipp.isep.dei.esoft.project.domain.repository.StateRepository;

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
