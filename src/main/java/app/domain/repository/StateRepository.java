package app.domain.repository;

import app.domain.model.District;
import app.domain.model.State;

import java.util.ArrayList;
import java.util.List;

public class StateRepository {
    private List<State> states = new ArrayList<>();

    public void save(State state) {
        if (stateIsValid(state)) {
            states.add(state);
        }
    }

    public State findByName(String name) {
        for (State state : states) {
            if (state.getName().equalsIgnoreCase(name)) {
                return state;
            }
        }
        return null;
    }

    private boolean stateIsValid(State state) {
        return state != null && !states.contains(state);
    }

    public List<State> findAll() {
        return new ArrayList<>(states);
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }
    public void addDistrictToState(State state, District district) {
        if (state != null && district != null) {
            state.getDistricts().add(district);
        }
    }
}



