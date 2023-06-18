package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.State;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type State repository.
 */
public class StateRepository implements Serializable {
    private static List<State> states = new ArrayList<>();

    /**
     * Save.
     *
     * @param state the state
     */
    public void save(State state) {
        if (stateIsValid(state)) {
            states.add(state);
        }
    }

    /**
     * Find by name state.
     *
     * @param name the name
     * @return the state
     */
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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<State> findAll() {
        return new ArrayList<>(states);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return states.isEmpty();
    }

    /**
     * Add district to state.
     *
     * @param state    the state
     * @param district the district
     */
    public void addDistrictToState(State state, District district) {
        if (state != null && district != null) {
            state.getDistricts().add(district);
        }
    }

    /**
     * Create state state.
     *
     * @param name      the name
     * @param districts the districts
     * @return the state
     */
    public State createState(String name, List<District> districts){
        return new State(name, districts);
    }

    /**
     * Create state state.
     *
     * @param name the name
     * @return the state
     */
    public State createState(String name){
        return new State(name, new ArrayList<>());
    }

    /**
     * Read object.
     */
    public void readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/state.ser"));
            states = (List<State>) ois.readObject();
            System.out.println(states);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    /**
     * Write object.
     */
    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/state.ser"));
            oos.writeObject(states);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }
}



