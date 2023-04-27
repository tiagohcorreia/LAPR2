package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public enum Agency {

    AGENCY1(1) {
        @Override
        public String toString() {
            return String.format("AGENCY1");
        }

    }, AGENCY2(2) {
        @Override
        public String toString() {
            return String.format("AGENCY2");
        }

    }, AGENCY3(3) {
        @Override
        public String toString() {
            return String.format("AGENCY3");
        }
    };

    private final int valor;

    Agency(int valor) {
        this.valor = valor;
    }

    public int getAgencyID() {
        return this.valor;
    }

    public static Agency getAgencyById(int id) {

        Agency[] array = Agency.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getAgencyID()) {

                return array[i];
            }
        }
        return null;
    }

}
