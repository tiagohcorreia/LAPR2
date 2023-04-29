package pt.ipp.isep.dei.esoft.project.domain.model;

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
        StringBuilder sb = new StringBuilder();
        sb.append("State: ").append(name).append("\n");
        sb.append("Districts:\n");

        if (districts.isEmpty()) {
            sb.append("No districts in this state.\n");
        } else {
            for (District district : districts) {
                sb.append("- ").append(district.getName()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        State state = (State) otherObject;
        return name.equals(state.name);
    }
}
