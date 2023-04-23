package app.domain.model;

import java.util.List;

public class State {
    private String name;
    private List<District> districts;

    public State(String name, List<District> districts) {
        this.name = name;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", districts=" + districts +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        State state = (State) otherObject;
        return name.equals(state.name);
    }

}
