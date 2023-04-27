package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public enum Role {

    ADMNISTRATOR(1) {
        @Override
        public String toString() {
            return String.format("Administrator");
        }

    }, MANAGER(2) {
        @Override
        public String toString() {
            return String.format("Manager");
        }

    }, AGENT(3) {
        @Override
        public String toString() {
            return String.format("Agent");
        }
    };

    private final int valor;

    Role(int valor) {
        this.valor = valor;
    }

    public int getRoleID() {
        return this.valor;
    }

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
