package pt.ipp.isep.dei.esoft.project.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The enum Role.
 */
public enum Role implements Serializable {

    /**
     * The Admnistrator.
     */
    ADMNISTRATOR(1) {
        @Override
        public String toString() {
            return String.format("Administrator");
        }

    },
    /**
     * The Network Manager.
     */
    NETWORK_MANAGER(2) {
        @Override
        public String toString() {
            return String.format("Network Manager");
        }

    },
    /**
     * The Agent.
     */
    AGENT(3) {
        @Override
        public String toString() {
            return String.format("Agent");
        }
    };

    private final int valor;

    Role(int valor) {
        this.valor = valor;
    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public int getRoleID() {
        return this.valor;
    }

    /**
     * Gets role by id.
     *
     * @param id the id
     * @return the role by id
     */
    public static Role getRoleById(int id) {

        Role[] array = Role.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getRoleID()) {

                return array[i];
            }
        }
        return null;
    }
}
